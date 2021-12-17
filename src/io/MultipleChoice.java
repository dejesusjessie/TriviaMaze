package io;

import java.util.Arrays;

/**
 * Implements behaviors specific to multiple choice trivia
 * Author: Jessie De Jesus
 */

public class MultipleChoice extends Question {
    /**
     * The options for the multiple choice question
     */
    private final String[] myOptions;

    /**
     * The hint for the multiple choice question
     */
    private final String myHint;


    /**
     * Constructs a multiple choice trivia with the question, associated options, and answer
     * @param theQuestion the question for the trivia
     * @param theAnswer the correct answer for the trivia
     * @param theOptions the available options for the trivia
     */
    public MultipleChoice(String theQuestion, String theAnswer, String[] theOptions, String theHint) {
        super(theQuestion, theAnswer, "MULTIPLE_CHOICE");
        this.myOptions = Arrays.copyOf(theOptions, theOptions.length);
        this.myHint = theHint;
    }

    /**
     * Returns the available options for the trivia
     * @return the available options
     */
    @Override
    public String[] getOptions() {
        return myOptions;
    }

    /**
     * Returns the hint for the trivia
     * @return the hint
     */
    public String getHint() {
        return myHint;
    }


}