package com.minhle.calculations;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.minhle.calculations.R;

import java.io.Serializable;
import java.util.ArrayList;

import model.TriviaFragment;
import model.TriviaQuestion;
import model.TriviaQuestionsFileManagement;


public class TriviaGame extends AppCompatActivity implements View.OnClickListener {

    TextView textViewWelcome;
    Button btnAnswer,btnFinish;
    ArrayList<TriviaQuestion> triviaQuestionList;
    static int i = 1, j = 4;
    String filename = "Questions.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triviagame);
        initialize();
    }

    public void initialize(){
        textViewWelcome = findViewById(R.id.textViewWelcome);
        String section = (String) getIntent().getExtras().getSerializable("tag");
        textViewWelcome.setText("Welcome to Trivia Game: "+section+"!");
        btnAnswer = findViewById(R.id.btnAnswer);
        btnFinish = findViewById(R.id.btnFinish);
        btnAnswer.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
        btnFinish.setEnabled(false);

        triviaQuestionList = new ArrayList<TriviaQuestion>();
        triviaQuestionList = TriviaQuestionsFileManagement.readTriviaQuestionsFile(this,filename,section);

        Bundle bundle = new Bundle();
        bundle.putSerializable("triviaQuestion",triviaQuestionList.get(0));


        //REPLACE THE LINEAR LAYOUT WITH FRAGMENT
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


    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnAnswer:
//               // TriviaFragment a = (TriviaFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
//                boolean check;
//               // check = a.next(i,j);
//                if(check == true){
//                i++;
//                j+=4;
//                }
//                else
//                {
//                btnFinish.setEnabled(true);
//                btnAnswer.setEnabled(false);
//                Toast.makeText(this,"You have finished the test! Please select the FINISH button",Toast.LENGTH_LONG).show();
//                }
                break;

            case R.id.btnFinish:
//                Intent intent = new Intent(this, Result.class);
//                intent.putExtra("tag", Arrayresult);
//                startActivity(intent);
//                break;

                break;
        }
    }

}
