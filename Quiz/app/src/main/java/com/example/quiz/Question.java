package com.example.quiz;

import java.util.ArrayList;

public class Question {
    private String Question;
    private ArrayList<String> Answer = new ArrayList<>();
    private int correctAns;

    public Question() {
        Question = null;
        Answer = null;
        this.correctAns=0;
    }

    public Question(String question, ArrayList<String> answer, int correctAns) {
        Question = question;
        Answer = answer;
        this.correctAns = correctAns;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public void setAnswer(ArrayList<String> answer) {
        Answer = answer;
    }

    public void setCorrectAns(int correctAns) {
        this.correctAns = correctAns;
    }

    public String getQuestion() {
        return Question;
    }

    public ArrayList<String> getAnswer() {
        return Answer;
    }

    public int getCorrectAns() {
        return correctAns;
    }
}
