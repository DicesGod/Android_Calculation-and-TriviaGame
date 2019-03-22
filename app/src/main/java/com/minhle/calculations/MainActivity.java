package com.minhle.calculations;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import model.Navigation;
import model.Operator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnDot,btnMinus,btnGenerate,btnQuit,btnEqual,btnShowAll,btnClear;
    TextView textViewQuestion;
    EditText editTextResult;
    Operator oper;
    ArrayList Arrayresult;
    String content;
    float totalcount;
    float correctcount;
    BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        Navigation nag = new Navigation();
//        Context a = getApplicationContext();
//        nag.navigation(menu,a);

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                   switch (item.getItemId()) {
                       case R.id.nag_math:
                           MainActivity.this.startActivity(new Intent(MainActivity.this, MainActivity.class));
                           break;

                       case R.id.nag_history:
                           MainActivity.this.startActivity(new Intent(MainActivity.this, History.class));
                           break;


                   }
                return false;
               }
           });

        }





    public void initialize(){
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnDot = findViewById(R.id.buttonDot);
        btnMinus = findViewById(R.id.buttonMinus);
        btnGenerate = findViewById(R.id.buttonGenerate);
        btnClear = findViewById(R.id.buttonClear);
        btnQuit = findViewById(R.id.buttonQuit);
        btnEqual = findViewById(R.id.buttonEqual);
        btnShowAll = findViewById(R.id.buttonShowAll);
        menu = findViewById(R.id.navigation);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnGenerate.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnShowAll.setOnClickListener(this);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        editTextResult = findViewById(R.id.editTextAnswer);
        Arrayresult = new ArrayList<String>();
        oper = new Operator();
        content = "";
        totalcount = 0;
        correctcount = 0;
    }


    public void onClick(View view) {



        switch (view.getId()) {

            case R.id.button0:
                editTextResult.setText(editTextResult.getText()+"0");
                break;

            case R.id.button1:
                editTextResult.setText(editTextResult.getText()+"1");
                break;

            case R.id.button2:
                editTextResult.setText(editTextResult.getText()+"2");
                break;

            case R.id.button3:
                editTextResult.setText(editTextResult.getText()+"3");
                break;

            case R.id.button4:
                editTextResult.setText(editTextResult.getText()+"4");
                break;

            case R.id.button5:
                editTextResult.setText(editTextResult.getText()+"5");
                break;

            case R.id.button6:
                editTextResult.setText(editTextResult.getText()+"6");
                break;

            case R.id.button7:
                editTextResult.setText(editTextResult.getText()+"7");
                break;

            case R.id.button8:
                editTextResult.setText(editTextResult.getText()+"8");
                break;

            case R.id.button9:
                editTextResult.setText(editTextResult.getText()+"9");
                break;

            case R.id.buttonDot:
                editTextResult.setText(editTextResult.getText()+".");
                break;

            case R.id.buttonMinus:
                editTextResult.setText(editTextResult.getText()+"-");
                break;

            case R.id.buttonGenerate:
                editTextResult.setText("");
                textViewQuestion.setText(oper.generator());
                content = " "+textViewQuestion.getText().toString();

                break;

            case R.id.buttonClear:
                textViewQuestion.setText("");
                editTextResult.setText("");
                break;

            case R.id.buttonQuit:
                finish();
                break;

            case R.id.buttonEqual:
                if (editTextResult.getText().length() != 0 && textViewQuestion.getText().length() !=0) {
                    totalcount++;
                    if (Float.parseFloat(String.valueOf(editTextResult.getText())) == oper.calculation()) {
                        Toast.makeText(this, "YOUR ANSWER IS CORRECT!", Toast.LENGTH_LONG).show();
                        Arrayresult.add("\n"+content +" = " + editTextResult.getText() + "\n" + " Your Answer is Correct."+"\n"+"---------------------------");
                        textViewQuestion.setText("");
                        editTextResult.setText("");
                        correctcount++;
                    }
                    else {
                        Toast.makeText(this, "YOUR ANSWER IS WRONG! CORRECT ANSWER IS: " + String.format("%.2f", oper.calculation()), Toast.LENGTH_LONG).show();
                        Arrayresult.add("\n"+content + " = " + editTextResult.getText() + "\n" + " Your Answer is Wrong!"+"\n"+" Correct answer is: "+String.format("%.2f", oper.calculation())+"\n"+"---------------------------");
                        textViewQuestion.setText("");
                        editTextResult.setText("");
                    }
                }
                else
                    Toast.makeText(this,"YOU HAVE NO OPERATION OR THE ANSWER!",Toast.LENGTH_LONG).show();
                break;

            case R.id.buttonShowAll:
                //startActivityForResult(new Intent(getApplicationContext(),Result.class),999);
                float percent = correctcount/totalcount*100;
                if (Arrayresult.toString()==null) {
                    Intent intent = new Intent(this, Result.class);
                    intent.putExtra("tag", Arrayresult);
                    startActivity(intent);
                    break;
                }
                else
                {
                    Arrayresult.add(" "+percent+"% Correct Answer."+"\n"+" "+(100-percent)+"% Wrong Answer.");
                    Intent intent = new Intent(this, Result.class);
                    intent.putExtra("tag", Arrayresult);
                    startActivity(intent);
                    break;
                }


        }
    }
}
