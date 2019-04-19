package model;

import java.io.Serializable;

public class TrviaQuestion implements Serializable {

    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String rightanswer;

    public TrviaQuestion(String question, String option1, String option2, String option3, String option4, String rightanswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightanswer = rightanswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getRightanswers() {
        return rightanswer;
    }

    @Override
    public String toString() {
        return "TrviaQuestion{" +
                "question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", rightanswer='" + rightanswer + '\'' +
                '}';
    }
}
