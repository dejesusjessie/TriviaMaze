package test;

import org.junit.jupiter.api.Test;
import triviaMaze.PromptUser;

import static org.junit.jupiter.api.Assertions.*;

class PromptUserTest {

    @Test
    void testUserNameMethod() {
        PromptUser promptUser = new PromptUser();
        promptUser.setMyUserName("Player");
        //assertEquals("Player",promptUser.setMyUserName());

    }

    @Test
    void userMazeSize() {
    }

    @Test
    void userSelectedDirection() {
    }

    @Test
    void displayTrivia() {
    }

    @Test
    void displayWinningMessage() {
    }

    @Test
    void displayLosingMessage() {
    }

    @Test
    void closeScanner() {
    }
}