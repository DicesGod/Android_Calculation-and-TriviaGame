package com.minhle.calculations;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;


public class CountDownController {

    private static CountDownTimer countDownTimer;

    public static void stopCount(final Context context, final TextView textViewCountDown){
        textViewCountDown.setTextColor(Color.BLACK);
        textViewCountDown.setTextSize(18);
        countDownTimer.cancel();
    }

    public static String startCountDown(final Context context, final TextView textViewCountDown, final TextView textViewQuestion)
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
                            textViewQuestion.setText(OperatorController.getQuestion());
                            startCountDown(context, textViewCountDown, textViewQuestion);
                        }


                    };
            countDownTimer.start();
            //countDownTimer.cancel();
            return "0";

        }


}
