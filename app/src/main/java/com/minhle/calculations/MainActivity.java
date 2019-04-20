package com.minhle.calculations;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.MathQuestion;
import model.MathQuestionsFileManagement;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnStart,btnMinus,btnStop,btnQuit,btnEqual,btnSave,btnResult,btnClear;
    TextView textViewQuestion;
    TextView textViewCountDown;
    EditText editTextResult;
    ArrayList getMathQuestionsListTemp;
    ArrayList mathQuestionsList;
    String content;
    float totalcount;
    float correctcount;
    BottomNavigationView menu;

    //For the DrawerLayout
    DrawerLayout drawerLayout;
    ListView listViewNavigationbar;
    ArrayAdapter<String> NavigationItemsAdapter;
    String[] listofNavigations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   Intent intent = new Intent(MainActivity.this, TriviaGameActivity.class);

                   switch (item.getItemId()) {
                       case R.id.nag_math:
                           MainActivity.this.startActivity(new Intent(MainActivity.this, MainActivity.class));

                           break;

                       case R.id.nag_history:
                           intent.putExtra("tag", getString(R.string.history));
                           startActivity(intent);
                           break;

                       case R.id.nag_art:
                           intent.putExtra("tag", getString(R.string.art));
                           startActivity(intent);
                           break;

                       case R.id.nag_sport:
                           intent.putExtra("tag", getString(R.string.sport));
                           startActivity(intent);
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
        btnStart = findViewById(R.id.buttonStart);
        btnMinus = findViewById(R.id.buttonMinus);
        btnStop = findViewById(R.id.buttonStop);
        btnClear = findViewById(R.id.buttonClear);
        btnQuit = findViewById(R.id.buttonQuit);
        btnEqual = findViewById(R.id.buttonEqual);
        btnSave = findViewById(R.id.buttonSave);
        btnResult = findViewById(R.id.buttonResult);
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
        btnStart.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        editTextResult = findViewById(R.id.editTextAnswer);
        textViewCountDown = findViewById(R.id.textViewCountDown);
        mathQuestionsList = new ArrayList<MathQuestion>();
        getMathQuestionsListTemp = new ArrayList<MathQuestion>();
        content = "";
        totalcount = 0;
        correctcount = 0;

        btnSave.setEnabled(false);
        btnStop.setEnabled(false);

        drawerLayout = findViewById(R.id.mainUI);
        listViewNavigationbar = findViewById(R.id.listviewnavigationbar);
        listofNavigations = getResources().getStringArray(R.array.navigationBar);
        //listViewNavigationbar.setOnItemClickListener();

        NavigationItemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1
                ,listofNavigations);
        listViewNavigationbar.setAdapter(NavigationItemsAdapter);
    }


    public void onClick(View view) {



        switch (view.getId()) {

            case R.id.button0:
                editTextResult.setText(editTextResult.getText() + "0");
                break;

            case R.id.button1:
                editTextResult.setText(editTextResult.getText() + "1");
                break;

            case R.id.button2:
                editTextResult.setText(editTextResult.getText() + "2");
                break;

            case R.id.button3:
                editTextResult.setText(editTextResult.getText() + "3");
                break;

            case R.id.button4:
                editTextResult.setText(editTextResult.getText() + "4");
                break;

            case R.id.button5:
                editTextResult.setText(editTextResult.getText() + "5");
                break;

            case R.id.button6:
                editTextResult.setText(editTextResult.getText() + "6");
                break;

            case R.id.button7:
                editTextResult.setText(editTextResult.getText() + "7");
                break;

            case R.id.button8:
                editTextResult.setText(editTextResult.getText() + "8");
                break;

            case R.id.button9:
                editTextResult.setText(editTextResult.getText() + "9");
                break;

            case R.id.buttonStart:
                getMathQuestionsListTemp.removeAll(getMathQuestionsListTemp);
                CountDownController.getFailAnswerList().removeAll(CountDownController.getFailAnswerList());
                CountDownController.startCountDown(this, textViewCountDown, textViewQuestion);
                    editTextResult.setText("");
                    textViewQuestion.setText(OperatorController.getQuestion());
                    content = " " + textViewQuestion.getText().toString();
                    btnSave.setEnabled(false);
                    btnStop.setEnabled(true);
                    btnStart.setEnabled(false);
                break;

            case R.id.buttonMinus:
                //MathQuestionsFileManagement.deleteFile(this);
                editTextResult.setText(editTextResult.getText()+"-");
                break;

            case R.id.buttonStop:
                textViewCountDown.setText(R.string.Instruction);
                CountDownController.stopCount(this,textViewCountDown);
                textViewQuestion.setText("");
                editTextResult.setText("");
                btnSave.setEnabled(true);
                btnStart.setEnabled(true);
                break;

            case R.id.buttonQuit:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
               // finish();
                break;

            case R.id.buttonEqual:
                try {
                    CountDownController.stopCount(this, textViewCountDown);
                    CountDownController.startCountDown(this, textViewCountDown, textViewQuestion);
                    int eslapsedTime = 10 - Integer.parseInt(textViewCountDown.getText().toString());
                    if (editTextResult.getText().length() != 0 && textViewQuestion.getText().length() != 0) {
                        totalcount++;
                        if (Float.parseFloat(String.valueOf(editTextResult.getText())) == OperatorController.getAnswer()) {
                            Toast.makeText(this, R.string.CorrectAnswer, Toast.LENGTH_LONG).show();
                            getMathQuestionsListTemp.add(new MathQuestion(getString(R.string.RightAnswerIn)+" "+ eslapsedTime +" "+ getString(R.string.seconds),
                                    textViewQuestion.getText().toString(),
                                    OperatorController.getAnswer(),
                                    Float.parseFloat(editTextResult.getText().toString()),
                                    eslapsedTime, getString(R.string.correct)));
                            textViewQuestion.setText(OperatorController.getQuestion());
                            editTextResult.setText("");
                            correctcount++;
                        } else {
                            Toast.makeText(this, getString(R.string.incorrectanswer)+" "+ String.format("%.2f", OperatorController.getAnswer()), Toast.LENGTH_LONG).show();
                            getMathQuestionsListTemp.add(new MathQuestion(getString(R.string.wronganswerIn)+" " + eslapsedTime + " "+getString(R.string.seconds),
                                    textViewQuestion.getText().toString(),
                                    OperatorController.getAnswer(),
                                    Float.parseFloat(editTextResult.getText().toString()),
                                    eslapsedTime,
                                    getString(R.string.wrong2)));
                            textViewQuestion.setText(OperatorController.getQuestion());
                            editTextResult.setText("");
                        }
                    } else
                        Toast.makeText(this, R.string.warning1, Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(this, R.string.warning1, Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.buttonSave:
                mathQuestionsList.addAll(CountDownController.getFailAnswerList());
                mathQuestionsList.addAll(getMathQuestionsListTemp);
                MathQuestionsFileManagement.writeMathQuestionsFile(this,mathQuestionsList);
                Toast.makeText(this,R.string.savesuccess,Toast.LENGTH_LONG).show();
                btnStop.setEnabled(false);
                btnSave.setEnabled(false);

                break;

            case R.id.buttonClear:
                editTextResult.setText("");
                break;


            case R.id.buttonResult:
                float percent = correctcount/totalcount*100;
                if (mathQuestionsList.toString()==null) {
                    Intent intent = new Intent(this, MathResult.class);
                    CountDownController.setFailAnswerList();
                    startActivity(intent);
                    break;
                }
                else
                {
                    Intent intent = new Intent(this, MathResult.class);
                    CountDownController.setFailAnswerList();
                    startActivity(intent);
                    break;
                }


        }
    }
}
