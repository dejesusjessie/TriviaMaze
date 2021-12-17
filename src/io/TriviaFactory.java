package io;

/**
 * Creates Trivia Objects
 * Author: Jessie De Jesus
 */
public class TriviaFactory {
    /**
     * Creates new trivia objects from trivia attributes
     * @param theQuestion the trivia question
     * @param theAnswer the correct answer for the trivia
     * @param theOptions the available options for the trivia
     * @param theType the type of trivia
     * @return the new trivia object
     */
    static Trivia createQuestion(String theQuestion, String theAnswer, String[] theOptions, String theType, String theHint) {
        Trivia trivia = null;
        switch (theType) {
            case "MULTIPLE_CHOICE":
                trivia = new MultipleChoice(theQuestion, theAnswer, theOptions, theHint);
                break;
            case "TRUE_FALSE":
                trivia = new TrueFalse(theQuestion, theAnswer);
                break;
        }
        return trivia;
    }
}

