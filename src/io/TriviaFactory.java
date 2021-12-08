package io;

public class TriviaFactory {
    static Trivia createQuestion(String theQuestion, String theAnswer, String[] theOptions, String theType) {
        Trivia trivia = null;
        switch (theType) {
            case "MULTIPLE_CHOICE":
                trivia = new MultipleChoice(theQuestion, theAnswer, theOptions);
                break;
            case "TRUE_FALSE":
                trivia = new TrueFalse(theQuestion, theAnswer);
                break;
        }
        return trivia;
    }
}
