package com.minhle.calculations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import model.MathQuestion;

public class MathQuestionsAdapter extends ArrayAdapter<MathQuestion> {
    public MathQuestionsAdapter(Context context, ArrayList<MathQuestion> mathQuestionList) {
        super(context, 0, mathQuestionList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MathQuestion MathQuestion = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_adapter, parent, false);
        }
        // Lookup view for data population
        TextView textViewmathResult = (TextView) convertView.findViewById(R.id.showResult);
        TextView textViewmathQuestion = (TextView) convertView.findViewById(R.id.columnQuestion);
        TextView textViewmathAnswer = (TextView) convertView.findViewById(R.id.columnAnswer);
        TextView textViewmathTime = (TextView) convertView.findViewById(R.id.columnTime);
        TextView textViewmathStatus = (TextView) convertView.findViewById(R.id.columnStatus);
        // Populate the data into the template view using the data object
        textViewmathResult.setText(MathQuestion.getResult());
        textViewmathQuestion.setText(MathQuestion.getMathQuestion());
        textViewmathAnswer.setText(String.valueOf(MathQuestion.getUserAnswer()));
        textViewmathTime.setText(String.valueOf(MathQuestion.getTime()));
        textViewmathStatus.setText(MathQuestion.getStatus());
        // Return the completed view to render on screen
        return convertView;
    }

}
