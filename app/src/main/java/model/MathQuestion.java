package model;

import java.io.Serializable;

public class MathQuestion implements Serializable {
    private String mathQuestion;
    private float rightAnswer;
    private float userAnswer;
    private int time;
    private String status;

    public String getStatus() {
        return status;
    }

    public String getMathQuestion() {
        return mathQuestion;
    }

    public float getUserAnswer() {
        return userAnswer;
    }

    public int getTime() {
        return time;
    }

    public MathQuestion(String mathQuestion, float rightAnswer, float userAnswer, int time, String status) {
        this.mathQuestion = mathQuestion;
        this.rightAnswer = rightAnswer;
        this.userAnswer = userAnswer;
        this.time = time;
        this.status = status;
    }

    @Override
    public String toString() {
        if (rightAnswer == userAnswer) {
            return "The user entered the right answer in "+time+" seconds"+"\n";
        }
        else if (userAnswer == 0.0f) {
            return "The user didn’t answer during 10 seconds";
        }
        else {
            return "The user answered during "+time+" seconds"+"\n";
        }
    }
}
