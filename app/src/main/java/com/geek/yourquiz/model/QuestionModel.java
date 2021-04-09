package com.geek.yourquiz.model;

import java.io.Serializable;

public class QuestionModel implements Serializable {
    private final String currentLevel;
    private final String question;
    private final String firstAnswer;
    private final String secondAnswer;
    private final String thirdAnswer;
    private final String fourthAnswer;

    public QuestionModel(String currentLevel, String question, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer) {
        this.currentLevel = currentLevel;
        this.question = question;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public String getQuestion() {
        return question;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public String getFourthAnswer() {
        return fourthAnswer;
    }
}
