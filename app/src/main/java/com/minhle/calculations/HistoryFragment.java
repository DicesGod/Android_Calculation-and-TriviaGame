package com.minhle.calculations;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import model.Questions;


public class HistoryFragment extends Fragment {

    RadioGroup radioGroup;
    RadioButton radioButton1,radioButton2,RadioButton3,radioButton4;
    TextView textViewQuestion;
    Fragment fragment;
    static int i = 0,j = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        radioGroup = view.findViewById(R.id.radioGroup);
        radioButton1 = view.findViewById(R.id.radioQuestion1);
        radioButton2 = view.findViewById(R.id.radioQuestion2);
        RadioButton3 = view.findViewById(R.id.radioQuestion3);
        radioButton4 = view.findViewById(R.id.radioQuestion4);
        textViewQuestion = view.findViewById(R.id.textViewQuestion);

        intialize();

        return view;

    }

    public void intialize()
    {
        Questions history = new Questions();
        textViewQuestion.setText(history.getQuestion(0));
        radioButton1.setText(history.getAnswers(0));
        radioButton2.setText(history.getAnswers(1));
        RadioButton3.setText(history.getAnswers(2));
        radioButton4.setText(history.getAnswers(3));
    }



    public boolean next(int i, int j) {
        try {
            Questions history = new Questions();
            textViewQuestion.setText(history.getQuestion(i));
            radioButton1.setText(history.getAnswers(j));
            radioButton2.setText(history.getAnswers(j + 1));
            RadioButton3.setText(history.getAnswers(j + 2));
            radioButton4.setText(history.getAnswers(j + 3));
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
