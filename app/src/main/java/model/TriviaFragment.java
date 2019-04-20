package model;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.minhle.calculations.Activity_TriviaGamesResult;
import com.minhle.calculations.R;

import java.util.ArrayList;


public class TriviaFragment extends android.app.Fragment implements View.OnClickListener {

    TextView textViewQuestion;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    ArrayList<TriviaQuestion> TriviaQuestionsList;
    Button btnAnswer, btnFinish;
    static int i = 0, j = 0;
    int index = 0;
    ArrayList<TriviaGameResult> triviaGameResultList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_triviagame, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnAnswer = getActivity().findViewById(R.id.btnAnswer);
        btnFinish = getActivity().findViewById(R.id.btnFinish);
        btnAnswer.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
        btnFinish.setEnabled(false);

        radioGroup = getActivity().findViewById(R.id.radioGroup);

        TriviaQuestionsList = (ArrayList<TriviaQuestion>) getArguments().getSerializable("triviaQuestion");
        textViewQuestion = getActivity().findViewById(R.id.textViewQuestion);
        radioButton1 = getActivity().findViewById(R.id.radioQuestion1);
        radioButton2 = getActivity().findViewById(R.id.radioQuestion2);
        radioButton3 = getActivity().findViewById(R.id.radioQuestion3);
        radioButton4 = getActivity().findViewById(R.id.radioQuestion4);

        textViewQuestion.setText(TriviaQuestionsList.get(index).getQuestion());
        radioButton1.setText(TriviaQuestionsList.get(index).getOption1());
        radioButton2.setText(TriviaQuestionsList.get(index).getOption2());
        radioButton3.setText(TriviaQuestionsList.get(index).getOption3());
        radioButton4.setText(TriviaQuestionsList.get(index).getOption4());

        triviaGameResultList = new ArrayList<TriviaGameResult>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnAnswer:
                int radiobuttonID = radioGroup.getCheckedRadioButtonId();
                String answer = "";

                switch (radiobuttonID) {
                    case R.id.radioQuestion1:
                        answer = TriviaQuestionsList.get(index).getOption1();
                        break;

                    case R.id.radioQuestion2:
                        answer = TriviaQuestionsList.get(index).getOption2();
                        break;

                    case R.id.radioQuestion3:
                        answer = TriviaQuestionsList.get(index).getOption3();
                        break;

                    case R.id.radioQuestion4:
                        answer = TriviaQuestionsList.get(index).getOption4();
                        break;
                }



                if (answer.equals(TriviaQuestionsList.get(index).getRightanswer()))
                {
                    triviaGameResultList.add(new TriviaGameResult(TriviaQuestionsList.get(index).getQuestion()+": "
                            +"\n"
                            +TriviaQuestionsList.get(index).getRightanswer()
                            +"\n"
                            +"Your answer is right!","right"));
                }
                else{
                    triviaGameResultList.add(new TriviaGameResult(TriviaQuestionsList.get(index).getQuestion()+": "
                            +"\n"
                            +TriviaQuestionsList.get(index).getRightanswer()
                            +"\n"
                            +"Your answer is wrong("
                            +answer+")","wrong"));
                }

                try {
                    index++;
                    textViewQuestion.setText(TriviaQuestionsList.get(index).getQuestion());
                    radioButton1.setText(TriviaQuestionsList.get(index).getOption1());
                    radioButton2.setText(TriviaQuestionsList.get(index).getOption2());
                    radioButton3.setText(TriviaQuestionsList.get(index).getOption3());
                    radioButton4.setText(TriviaQuestionsList.get(index).getOption4());
                } catch (Exception e) {
                    btnFinish.setEnabled(true);
                    btnAnswer.setEnabled(false);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        Toast.makeText(getContext(), getString(R.string.finishtriviatest), Toast.LENGTH_LONG).show();
                    }
                }
                break;

            case R.id.btnFinish:
                Intent intent = new Intent();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    intent = new Intent(getContext(), Activity_TriviaGamesResult.class);
                }
                intent.putExtra("triviaresult", triviaGameResultList);
                startActivity(intent);
                break;
        }
    }
}