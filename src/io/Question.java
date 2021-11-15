package io;

public abstract class Question implements Trivia {

    private final String myQuestion;
    private final String myAnswer;


    protected Question(String theQuestion, String theAnswer){
        this.myQuestion = theQuestion;
        this.myAnswer = theAnswer;
    }

    @Override
    public String getQuestion() {
        return myQuestion;
    }

    @Override
    public String getAnswer() {
        return myAnswer;
    }


}
