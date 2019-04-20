package com.minhle.calculations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import model.TriviaGameResult;

public class Activity_TriviaGamesResult extends AppCompatActivity implements View.OnClickListener {

    Button btnBack;
    TextView textViewPrecentRight,textViewPercentWrong;

    ArrayList<TriviaGameResult> triviaGameResultsList;
    ArrayList<String> triviaGameStringResultsList;
    ArrayAdapter<String> resultsArrayAdapter;
    ListView listViewTriviaGameResult;
    float countRight = 0;
    float percentright;
    float precentwrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__trivia_games_result);

        initialize();
    }

    public void initialize(){
        btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(this);
        textViewPrecentRight = findViewById(R.id.textViewPercentCorrect);
        textViewPercentWrong = findViewById(R.id.textViewPercentIncorrect);

        triviaGameResultsList = new ArrayList<TriviaGameResult>();
        triviaGameStringResultsList = new ArrayList<String>();
        triviaGameResultsList = (ArrayList) getIntent().getExtras().getSerializable("triviaresult");
        for (TriviaGameResult triviaGameResult: triviaGameResultsList) {
            triviaGameStringResultsList.add(triviaGameResult.getResult());
            if (triviaGameResult.getStatus().equals("Right"))
            {
                countRight++;
            }
        }
        listViewTriviaGameResult = findViewById(R.id.listViewTriviaGameResult);

        resultsArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,triviaGameStringResultsList);
        listViewTriviaGameResult.setAdapter(resultsArrayAdapter);

        percentright = countRight/triviaGameResultsList.size()*100;
        precentwrong = 100-percentright;

        textViewPrecentRight.setText(String.valueOf(percentright)+"%");
        textViewPercentWrong.setText(String.valueOf(precentwrong)+"%");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
