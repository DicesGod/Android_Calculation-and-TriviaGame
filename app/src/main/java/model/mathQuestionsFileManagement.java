package model;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

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

public class mathQuestionsFileManagement {

        static String fileName = "mathQuestion.txt";
        static  File mathQuestionsFile;
        static FileOutputStream outputStream;

        public static void checkAndCreateAFile(Context context, ArrayList<MathQuestion> mathQuestionsList) {
//            try{
//                if (mathQuestionsFile.exists() == false) {
                    //File mathQuestionsFile = new File(context.getFilesDir(), fileName);
//                    //mathQuestionsFile.mkdir();
            try {
                mathQuestionsFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
//                    //fileName = mathQuestionsFile.get
                    //Toast.makeText(context,mathQuestionsList.get(0).toString(),Toast.LENGTH_LONG).show();
//                }
//                else {
                    try {

                        //Formatter f = new Formatter(mathQuestionsFile.getParent());
                        outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                        for (int i = 0; i < mathQuestionsList.size();i++) {

                            outputStream.write(mathQuestionsList.get(i).toString().getBytes());

                            Toast.makeText(context,mathQuestionsList.toString(),Toast.LENGTH_LONG).show();
//                            f.format(mathQuestionsList.get(i).toString());
//                            f.close();

                        }
                        outputStream.close();
                        Toast.makeText(context,mathQuestionsList.toString(),Toast.LENGTH_LONG).show();
//                    } catch (FileNotFoundException e) {
//                        Toast.makeText(context, e.toString(),Toast.LENGTH_LONG).show();
//                    }

               // }
            } catch (IOException e) {
                    e.printStackTrace();
            }
        //}


//        public static ArrayList<MathQuestion> readFile(Context context){
//            ArrayList<MathQuestion> mathQuestionsList = new ArrayList<>();
//            ArrayList<String> temporaryarray;
//            String line = "";
//
//            try {
//                mathQuestionsFile = new File(mathQuestionsFile.getParent());
//                Scanner reader = new Scanner(mathQuestionsFile);
//                while(reader.hasNextLine()) {
//                    line = reader.nextLine();
//                    temporaryarray = new ArrayList(Arrays.asList(line.split(",")));
//                    mathQuestionsList.add(new MathQuestion(temporaryarray.get(0),
//                            null,
//                            Float.parseFloat(temporaryarray.get(2)),
//                            Integer.parseInt(temporaryarray.get(3)),
//                            temporaryarray.get(4)));
//                   // content += sc.nextLine()+"\r\n";
//                }
//
//
//                reader.close();
//            } catch (FileNotFoundException e) {
//                Toast.makeText(context,"Failed to read the file!",Toast.LENGTH_LONG).show();
//            }
//
//            return mathQuestionsList;
//
     }
    }


