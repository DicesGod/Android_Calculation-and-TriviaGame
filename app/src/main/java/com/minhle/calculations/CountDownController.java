package com.minhle.calculations;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.MathQuestion;


public class CountDownController {

    private static CountDownTimer countDownTimer;
    private static ArrayList<MathQuestion> failAnswerList = new ArrayList<>();

    public static ArrayList<MathQuestion> getFailAnswerList() {
        return failAnswerList;
    }

    public static void setFailAnswerList() {
        CountDownController.failAnswerList.removeAll(failAnswerList);
    }

    public static void stopCount(final Context context, final TextView textViewCountDown){
        textViewCountDown.setTextColor(Color.BLACK);
        textViewCountDown.setTextSize(18);
        countDownTimer.cancel();
    }

    public static void startCountDown(final Context context, final TextView textViewCountDown, final TextView textViewQuestion)
    {

        countDownTimer = new CountDownTimer(10000, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            textViewCountDown.setText(String.valueOf((int) millisUntilFinished / 1000));
                            textViewCountDown.setTextColor(Color.RED);
                            textViewCountDown.setTextSize(30);
                        }

                        @Override
                        public void onFinish() {
                            failAnswerList.add(new MathQuestion("The user didn’t answer during 10 seconds",textViewQuestion.getText().toString(), OperatorController.getAnswer(),null,0,"Fail"));
                            textViewQuestion.setText(OperatorController.getQuestion());
                            startCountDown(context, textViewCountDown, textViewQuestion);
                            //Toast.makeText(context,"Test",Toast.LENGTH_LONG).show();
                        }

                    };
            countDownTimer.start();

        //return failAnswer;

        }


}
