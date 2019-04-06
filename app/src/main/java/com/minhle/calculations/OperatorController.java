package com.minhle.calculations;

import java.util.Random;

public class OperatorController {

    static private float num1 = 0;
    static private float num2 = 0;
    static private String question = "";
    static private float answer=0;
    static private String operator="";

    public static float getAnswer() {
        answer = calculation();
        return answer;
    }


    public static String getQuestion() {
        question = generator();
        return question;
    }

    private static String generator()
    {
        Random rand = new Random();
        num1 = rand.nextInt(10) + 1;
        num2 = rand.nextInt(10) + 1;
        String[] operators = {"+", "-", "/", "*", "%"};
        operator = operators[rand.nextInt(3) + 1];
        question = String.format("%.0f",num1) + " " + operator + " " + String.format("%.0f",num2);
        return question;
    }

    private static float calculation()
    {
        switch (operator)
        {
            case "+":
                answer = num1 + num2;
                return answer;

            case "-":
                answer = num1 - num2;
                return answer;


            case "*":
                answer = num1 * num2;
                return answer;


            case "/":
                answer = num1 / num2;
                return answer;

        }
        return answer;
    }
}
