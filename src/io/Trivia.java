package io;

/**
 * Interface defining trivia behaviors that are common to all implementing subclasses
 * Author: Jessie De Jesus
 */
public interface Trivia {

    /**
     * Provides the question for this trivia
     * @return the question
     */
    String getQuestion();

    /**
     * Provides the correct answer for this trivia
     * @return the correct answer
     */
    String getAnswer();

    /**
     * Provides the available options for this trivia
     * @return the options
     */
    String[] getOptions();

    /**
     * Provides the type for this trivia
     * @return the trivia type
     */
    String getType();

    /**
     * Provides the hint for this trivia
     * @return the trivia hint
     */
    String getHint();
}

