package model;

import java.io.Serializable;

public class MathQuestion implements Serializable {
    private String mathQuestion;
    private Float rightAnswer;
    private Float userAnswer;
    private int time;
    private String status;

    public String getStatus() {
        return status;
    }

    public String getMathQuestion() {
        return mathQuestion;
    }

    public Float getUserAnswer() {
        return userAnswer;
    }

    public int getTime() {
        return time;
    }

    public MathQuestion(String mathQuestion, Float rightAnswer, Float userAnswer, int time, String status) {
        this.mathQuestion = mathQuestion;
        this.rightAnswer = rightAnswer;
        this.userAnswer = userAnswer;
        this.time = time;
        this.status = status;
    }

    @Override
    public String toString() {
        if (userAnswer == null) {
            return "The user didn’t answer during 10 seconds";
        }
        else if (rightAnswer == userAnswer) {
            return "The user entered the right answer in "+time+" seconds"+"\n";
        }

        else {
            return "The user answered during "+time+" seconds"+"\n";
        }
    }
}
