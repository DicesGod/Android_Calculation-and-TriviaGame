package model;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TriviaQuestionsFileManagement {

    public static ArrayList<TrviaQuestion> readTriviaQuestionsFile(Context context, String fileName){
        ArrayList<TrviaQuestion> listOfTriviaQuestions = new ArrayList<>();

        AssetManager assetManager = context.getResources().getAssets();


        try {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));

            BufferedReader br = new BufferedReader(isr);

            String oneLine = br.readLine();

            while (oneLine != null){
                StringTokenizer st = new StringTokenizer(oneLine,",");
                String question = st.nextToken();
                String option1 = st.nextToken();
                String option2 = st.nextToken();
                String option3 = st.nextToken();
                String option4 = st.nextToken();
                String rightanswer = st.nextToken();

                listOfTriviaQuestions.add(new TrviaQuestion(question,option1,option2,option3,option4,rightanswer));
                oneLine = br.readLine();
            }
            br.close();
            isr.close();

        } catch (IOException e) {
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        return listOfTriviaQuestions;

    }
}

