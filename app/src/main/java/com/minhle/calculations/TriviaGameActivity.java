package com.minhle.calculations;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.minhle.calculations.R;

import java.io.Serializable;
import java.util.ArrayList;

import model.Navigation;
import model.TriviaFragment;
import model.TriviaQuestion;
import model.TriviaQuestionsFileManagement;


public class TriviaGame extends AppCompatActivity{

    TextView textViewWelcome;
    ArrayList<TriviaQuestion> triviaQuestionList;
    static int i = 1, j = 4;
    String filename = "Questions.txt";
    int index = 0;
    Bundle bundle = new Bundle();
    BottomNavigationView menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triviagame);
        initialize();

        Navigation nag = new Navigation();

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent1 = new Intent(TriviaGame.this,MainActivity.class);
                Intent intent2 = new Intent(TriviaGame.this,TriviaGame.class);

                switch (item.getItemId()) {
                    case R.id.nag_math:
                        startActivity(intent1);
                        break;

                    case R.id.nag_history:
                        intent2.putExtra("tag", "History");
                        startActivity(intent2);
                        break;

                    case R.id.nag_art:
                        intent2.putExtra("tag", "Art");
                        startActivity(intent2);
                        break;

                    case R.id.nag_sport:
                        intent2.putExtra("tag", "Sport");
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });


    }

    public void initialize(){
        menu = findViewById(R.id.navigation);
        textViewWelcome = findViewById(R.id.textViewWelcome);
        String section = (String) getIntent().getExtras().getSerializable("tag");
        textViewWelcome.setText("Welcome to Trivia Game: "+section+"!");
        triviaQuestionList = new ArrayList<TriviaQuestion>();
        triviaQuestionList = TriviaQuestionsFileManagement.readTriviaQuestionsFile(this,filename,section);

        //send data from the activity -> Fragment

        bundle.putSerializable("triviaQuestion",triviaQuestionList.get(index));
        index++;
        //Create an instance of Fragment class
        TriviaFragment triviaFragment = new TriviaFragment();
        triviaFragment.setArguments(bundle);

        //REFERENCE THE FRAGMENT MANAGER
        android.app.FragmentManager fragmentManager = getFragmentManager();

        //BEGIN THE TRANSACTION
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //REPLACE LINEAR LAYOUT MAIN_UI WITH THE FRAGMENT
        fragmentTransaction.replace(R.id.triviagame_fragment,triviaFragment);

        //COMMIT THE TRANSACTION
        fragmentTransaction.commit();

        setTitle(triviaQuestionList.get(0).getCategory());
    }
}
