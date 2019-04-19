package model;

import java.io.Serializable;

public class MathQuestion implements Serializable {
    private String result;
    private String mathQuestion;
    private Float rightAnswer;
    private Float userAnswer;
    private int time;
    private String status;

    public MathQuestion(String result,String mathQuestion, Float rightAnswer, Float userAnswer, int time, String status) {
        this.result = result;
        this.mathQuestion = mathQuestion;
        this.rightAnswer = rightAnswer;
        this.userAnswer = userAnswer;
        this.time = time;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        result = result;
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

    public Float getRightAnswer() {
        return rightAnswer;
    }

    @Override
    public String toString() {
        if (userAnswer == null) {
            return result+","+mathQuestion+","+rightAnswer+","+userAnswer+","+time+","+status+"\n";
        }
        else if (rightAnswer == userAnswer) {
            return result+","+mathQuestion+","+rightAnswer+","+userAnswer+","+time+","+status+"\n";
        }

        else {
            return result+","+mathQuestion+","+rightAnswer+","+userAnswer+","+time+","+status+"\n";
        }
    }
}
