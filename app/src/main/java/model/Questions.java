package model;

import java.util.ArrayList;

public class Questions {

    ArrayList<String> historyquestion = new ArrayList<>();
    ArrayList<String> historyanswers = new ArrayList<>();
    ArrayList<String> historyrightanswer = new ArrayList<>();
    
    
    private void setHistoryquestion() {
        historyquestion.add("Who said Witches should be burned with their cat's ?");
        historyquestion.add("Who was a queen of Russia ?");
        historyquestion.add("Who was fighting in the French and Indian war ?");
        historyquestion.add("When did Germany attack Poland ?");
        historyquestion.add("How many men died in Stalingrad ?");
    }

    private void setHistoryanswers() {
        historyanswers.add("Innocent Pope I");
        historyanswers.add("King George C");
        historyanswers.add("Shakespeare");
        historyanswers.add("Queen Victoria");
        historyanswers.add("Cleopatra");
        historyanswers.add("Catherine the great");
        historyanswers.add("Victoria I");
        historyanswers.add("Jenny the I");
        historyanswers.add("The French against the Indians");
        historyanswers.add("The French and the Indians against England");
        historyanswers.add("The French against England");
        historyanswers.add("The Indians and England against the French");
        historyanswers.add("September 1 1939");
        historyanswers.add("December 7 1941");
        historyanswers.add("June 6 1944");
        historyanswers.add("August 6 1945");
        historyanswers.add("50 000");
        historyanswers.add("250 000");
        historyanswers.add("2000");
        historyanswers.add("30 000");
    }

    public String getQuestion(int i)
    {
        setHistoryquestion();
        return historyquestion.get(i).toString();
    }
    
    public String getAnswers(int i)
    {
        setHistoryanswers();
        return historyanswers.get(i).toString();
    }


}
