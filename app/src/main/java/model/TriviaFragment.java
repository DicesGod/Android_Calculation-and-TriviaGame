package model;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.minhle.calculations.R;



public class TriviaFragment extends android.app.Fragment {

    static int i = 0,j = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_triviagame, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RadioGroup radioGroup = getActivity().findViewById(R.id.radioGroup);
        //TriviaQuestion triviaQuestion = new TriviaQuestion();
        TriviaQuestion triviaQuestion = (TriviaQuestion)getArguments().getSerializable("triviaQuestion");
        TextView textViewQuestion = getActivity().findViewById(R.id.textViewQuestion);
        RadioButton radioButton1 = getActivity().findViewById(R.id.radioQuestion1);
        RadioButton radioButton2 = getActivity().findViewById(R.id.radioQuestion2);
        RadioButton radioButton3 = getActivity().findViewById(R.id.radioQuestion3);
        RadioButton radioButton4 = getActivity().findViewById(R.id.radioQuestion4);

        textViewQuestion.setText(triviaQuestion.getQuestion());
        radioButton1.setText(triviaQuestion.getOption1());
        radioButton2.setText(triviaQuestion.getOption2());
        radioButton3.setText(triviaQuestion.getOption3());
        radioButton4.setText(triviaQuestion.getOption4());
    }

    //check if there is next question or not
//    public boolean next(int i, int j) {
//        try {
//            Questions history = new Questions();
//            textViewQuestion.setText(history.getQuestion(i));
//            radioButton1.setText(history.getAnswers(j));
//            radioButton2.setText(history.getAnswers(j + 1));
//            RadioButton3.setText(history.getAnswers(j + 2));
//            radioButton4.setText(history.getAnswers(j + 3));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
}
