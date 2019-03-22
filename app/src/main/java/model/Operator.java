package model;

import java.util.Random;

public class Operator {

    float num1 = 0;
    float num2 = 0;
    String question = "";
    float answer=0;
    String operator="";

    public String generator()
    {
        Random rand = new Random();
        num1 = rand.nextInt(10) + 1;
        num2 = rand.nextInt(10) + 1;
        String[] operators = {"+", "-", "/", "*", "%"};
        operator = operators[rand.nextInt(3) + 1];
        question = String.format("%.0f",num1) + " " + operator + " " + String.format("%.0f",num2);
        return question;
    }

    public float calculation()
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
