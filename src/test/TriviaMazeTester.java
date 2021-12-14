package test;

import triviaMaze.PromptUser;
import triviaMaze.TriviaMazeBuilder;

/**
 *
 * @author Kannika Armstrong
 *
 */
public class TriviaMazeTester {

    public static void main(String[] args) {
        //======= Uncomment to test each method =======//
         new TriviaMazeBuilder();
        // userNameTest();
        // userMazeSizeTest();
        // userSelectedDirectionTest();
        // displayTriviaQuestionTest();
        // displayWinningMessageTest();
        // displayLosingMessageTest();
    }

    private static void displayLosingMessageTest() {
        PromptUser promptUser = new PromptUser();
        promptUser.displayLosingMessage();
    }

    private static void displayWinningMessageTest() {
        PromptUser promptUser = new PromptUser();
        promptUser.displayWinningMessage();
    }

    private static void displayTriviaQuestionTest() {
        PromptUser promptUser = new PromptUser();
        promptUser.displayTrivia();
    }

    private static void userSelectedDirectionTest() {
        PromptUser promptUser = new PromptUser();
        promptUser.userSelectedDirection();
    }

    private static void userMazeSizeTest() {
        PromptUser promptUser = new PromptUser();
        promptUser.userMazeSize();
    }

    private static void userNameTest() {
        PromptUser promptUser = new PromptUser();
        promptUser.userName();
    }
}
