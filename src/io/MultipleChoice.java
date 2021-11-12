package model;

import java.util.Arrays;

public class MultipleChoice extends Question {
    private final String[] myOptions;

    public MultipleChoice(String theQuestion, String theAnswer, String[] theOptions) {
        super(theQuestion, theAnswer);
        this.myOptions = Arrays.copyOf(theOptions, theOptions.length);
    }


    @Override
    public String[] getOptions() {
        return myOptions;
    }
}
