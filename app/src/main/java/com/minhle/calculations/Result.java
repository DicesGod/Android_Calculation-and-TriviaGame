package com.minhle.calculations;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Result extends AppCompatActivity{

    Button btnBack;
    TextView textViewResult;
    ArrayList listresult;
    TextView textViewPercent;

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
        listresult = (ArrayList) getIntent().getExtras().getSerializable("tag");
        String result="";

        for (int i = 0; i < listresult.size()-1;i++)
        {
            result = result.concat(listresult.get(i).toString());


        }
        textViewResult.setText(result);
        textViewPercent.setText(listresult.get(listresult.size()-1).toString());
    }

    public void initialize()
    {
        btnBack = findViewById(R.id.buttonBack);
        textViewResult = findViewById(R.id.textViewResult);
        textViewPercent = findViewById(R.id.textViewPercent);
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
        //intent.putExtra("key",listresult);
        //onSaveInstanceState(savedInstanceState);
        startActivity(intent);
    }
}
