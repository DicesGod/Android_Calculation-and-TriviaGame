package com.minhle.calculations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import model.MathQuestionsFileManagement;

public class MathResult extends AppCompatActivity{

    Button btnBack;
    TextView textViewResult;
    ArrayList mathResultsList;
    TextView textViewPercent;
    ListView listViewMathResult;
    MathQuestionsAdapter mathResulstArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initialize();
    }

    public void initialize()
    {
        mathResultsList = MathQuestionsFileManagement.readMathQuestionsFile(this);

        btnBack = findViewById(R.id.buttonBack);
        listViewMathResult = findViewById(R.id.listViewResult);
        textViewPercent = findViewById(R.id.textViewPercent);
        mathResulstArrayAdapter = new MathQuestionsAdapter(this, mathResultsList) {
        };
        listViewMathResult = findViewById(R.id.listViewResult);
        listViewMathResult.setAdapter(mathResulstArrayAdapter);
        textViewPercent.setText(MathQuestionsFileManagement.calculateResult(mathResultsList,getApplicationContext()));
    }

    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
