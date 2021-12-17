package io;

/**
 * An abstract class that implements attributes and behavior shared by the Trivia class.
 * Author: Jessie De Jesus
 */
public abstract class Question implements Trivia {

    /**
     * The question
     */
    private final String myQuestion;

    /**
     * The correct answer
     */
    private final String myAnswer;

    /**
     * The type of trivia
     */
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
