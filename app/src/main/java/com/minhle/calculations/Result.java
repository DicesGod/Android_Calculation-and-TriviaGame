package com.minhle.calculations;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.MathQuestion;
import model.mathQuestionsFileManagement;

public class Result extends AppCompatActivity{

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



        //if (savedInstanceState != null) {
            //String message = savedInstanceState.getString("lesson");
           // Toast.makeText(this, "!=null", Toast.LENGTH_LONG).show();
            //listresult = savedInstanceState.getStringArrayList("myarraylist");
            //listresult.addAll((ArrayList) getIntent().getExtras().getSerializable("tag"));
       // }
        //else{
            //String message = savedInstanceState.getString("lesson");
            //Toast.makeText(this, "=null", Toast.LENGTH_LONG).show();

       // }

       // String result="";



    }

    public void initialize()
    {
        mathResultsList = mathQuestionsFileManagement.readMathQuestionsFile(this);

        btnBack = findViewById(R.id.buttonBack);
        listViewMathResult = findViewById(R.id.listViewResult);
        textViewPercent = findViewById(R.id.textViewPercent);
        mathResulstArrayAdapter = new MathQuestionsAdapter(this, mathResultsList) {
        };
        listViewMathResult = findViewById(R.id.listViewResult);
        listViewMathResult.setAdapter(mathResulstArrayAdapter);
        textViewPercent.setText(mathQuestionsFileManagement.calculateResult(mathResultsList));
//        mathResulstArrayAdapter.addAll(mathResultsList);
//        mathResulstArrayAdapter.notifyDataSetChanged();
    }

    //@Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//
//        outState.putString("lesson", "a");
//
//
//
//    }

//    @Override
//    protected void onSaveInstanceState(Bundle savedInstanceState) {
//        //savedInstanceState.putStringArrayList("myarraylist",listresult);
//        savedInstanceState.putString("message", "This is my message to be reloaded");
//        super.onSaveInstanceState(savedInstanceState);
//    }

    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
