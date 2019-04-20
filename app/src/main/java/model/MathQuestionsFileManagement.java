package model;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.widget.Toast;

import com.minhle.calculations.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Arrays;

public class MathQuestionsFileManagement {

    static String fileName = "mathQuestions";
    static File mathQuestionsFile;
    static FileOutputStream outputStream;

    public static void deleteFile(Context context){
        mathQuestionsFile = new File(context.getFilesDir(), fileName);
        mathQuestionsFile.delete();
    }

    public static void writeMathQuestionsFile(Context context, ArrayList<MathQuestion> mathQuestionsList) {
        try {
            mathQuestionsFile = new File(context.getFilesDir(), fileName);
            mathQuestionsFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream = context.openFileOutput(fileName, Context.MODE_APPEND);
            for (int i = 0; i < mathQuestionsList.size(); i++) {
                outputStream.write(mathQuestionsList.get(i).toString().getBytes());
            }
            outputStream.close();
            Toast.makeText(context, mathQuestionsList.toString(), Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static ArrayList<MathQuestion> readMathQuestionsFile(Context context) {
        ArrayList<MathQuestion> mathQuestionsList = new ArrayList<>();
        ArrayList<String> temporaryarray;
        String line = "";

        try {
            mathQuestionsFile = new File(context.getFilesDir(), fileName);
            Scanner reader = new Scanner(mathQuestionsFile);
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                temporaryarray = new ArrayList(Arrays.asList(line.split(",")));
                //check if useranser is null or not
                if(temporaryarray.get(3).equals("null")) {
                    mathQuestionsList.add(new MathQuestion(temporaryarray.get(0),
                            temporaryarray.get(1),
                            null,
                            null,
                            Integer.parseInt(temporaryarray.get(4)),
                            temporaryarray.get(5)));
                }
                else
                {
                    mathQuestionsList.add(new MathQuestion(temporaryarray.get(0),
                            temporaryarray.get(1),
                            null,
                            Float.parseFloat(temporaryarray.get(3)),
                            Integer.parseInt(temporaryarray.get(4)),
                            temporaryarray.get(5)));
                }
            }


            reader.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(context, "Failed to read the file!", Toast.LENGTH_LONG).show();
        }

        return mathQuestionsList;

    }

    public static String calculateResult(ArrayList<MathQuestion> mathQuestionsList,Context context) {
        float totalQuestions = mathQuestionsList.size();
        float totalAnsweredQuestions = 0;
        float totalDuration = 10 * mathQuestionsList.size();;
        float elapsedTime = 0;
        float correctAnswers = 0;
        float faiAnswers = 0;
        float percentCorrectAnswer = 0;
        float percentfailAnswer = 0;
        float velocity = 0;


        for (MathQuestion mathQuestion: mathQuestionsList)
        {
            if(mathQuestion.getStatus() != "Fail"){
                totalAnsweredQuestions ++;
            }
            elapsedTime = elapsedTime+mathQuestion.getTime();

            if(mathQuestion.getStatus().equals("Correct")){

                correctAnswers++;
            }
        }

        percentCorrectAnswer = correctAnswers/totalQuestions*100;
        percentfailAnswer = 100-percentCorrectAnswer;
        velocity = elapsedTime/totalDuration;



        return  context.getString(R.string.totalquestions)+" "+totalQuestions+"\n"
                +context.getString(R.string.totalanswered)+" "+totalAnsweredQuestions+"\n"
                +context.getString(R.string.totalduration)+" "+totalDuration+"\n"
                +context.getString(R.string.elapsedtime)+" "+elapsedTime+"\n"
                +context.getString(R.string.percentright)+" "+percentCorrectAnswer+"%"+"\n"
                +context.getString(R.string.percentfail)+" "+percentfailAnswer+"%"+"\n"
                +context.getString(R.string.velocity)+" "+velocity;
    }

}

