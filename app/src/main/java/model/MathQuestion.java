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

    public Float getRightAnswer() {
        return rightAnswer;
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
            return mathQuestion+","+rightAnswer+","+userAnswer+","+time+","+status+"\n";
        }
        else if (rightAnswer == userAnswer) {
            return mathQuestion+","+rightAnswer+","+userAnswer+","+time+","+status+"\n";
        }

        else {
            return mathQuestion+","+rightAnswer+","+userAnswer+","+time+","+status+"\n";
        }
    }
}
