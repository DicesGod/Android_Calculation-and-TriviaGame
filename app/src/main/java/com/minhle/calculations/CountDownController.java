package com.minhle.calculations;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;


public class CountdownTimer2 {

    static public void startCountDown(Context context, final TextView textViewCountDown) {

        CountDownTimer countDownTimer =
                new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        textViewCountDown.setText(String.valueOf((int) millisUntilFinished));
                    }

                    @Override
                    public void onFinish() {

                    }
                };
        countDownTimer.start();

    }
}
