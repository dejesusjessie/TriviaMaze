package io;

/**
 * Implements behaviors specific to True/False trivia
 * Author: Jessie De Jesus
 */
public class TrueFalse extends Question{

    /**
     * The options for the True/False trivia
     */
    private final String[] myOptions = {"True", "False"};

    /**
     * Constructs a true/false trivia with the question and answer
     * @param theQuestion the question for the trivia
     * @param theAnswer the correct answer for the trivia
     */
    public TrueFalse(String theQuestion, String theAnswer) {
        super(theQuestion, theAnswer, "TRUE_FALSE");
    }

    /**
     * Returns the available options for the trivia
     * @return the available options
     */
    @Override
    public String[] getOptions() {
        return myOptions;
    }

    @Override
    public String getHint() {
        return "No hints available. You have a 50/50 chance";
    }
}

