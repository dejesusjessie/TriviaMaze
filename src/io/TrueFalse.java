package io;

public class TrueFalse extends Question{

    private final String[] myOptions = {"True", "False"};

    public TrueFalse(String theQuestion, String theAnswer) {
        super(theQuestion, theAnswer, "TRUE_FALSE");
    }

    @Override
    public String[] getOptions() {
        return myOptions;
    }
}
