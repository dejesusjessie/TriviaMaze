package io;

public abstract class Question implements Trivia {

    private final String myQuestion;
    private final String myAnswer;
    private final String myType;


    protected Question(String theQuestion, String theAnswer, String theType){
        this.myQuestion = theQuestion;
        this.myAnswer = theAnswer;
        this.myType = theType;
    }

    @Override
    public String getQuestion() {
        return myQuestion;
    }

    @Override
    public String getAnswer() {
        return myAnswer;
    }

    @Override
    public String getType() {
        return myType;
    }



}
