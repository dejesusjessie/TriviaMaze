package test;

import org.junit.jupiter.api.Test;
import triviaMaze.PromptUser;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PromptUserTest {

    @Test
    void testGetMyUserNameMethod() {
        PromptUser promptUser = new PromptUser();
        promptUser.setMyUserName("Kira");
        assertEquals("Kira", promptUser.getMyUserName());
    }

    @Test
    void testUserNameMethod() {
        String userInput = String.format("Kira",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        String expected = "Welcome Kira to the Husky Trivia Maze Game.";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

        PromptUser promptUser = new PromptUser();
        promptUser.userName();

        String[] lines = out.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    void testUserMazeSizeMethod() {
        String userInput = String.format("B",
                System.lineSeparator());
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        String expected = "You select the beginner level.";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

        PromptUser promptUser = new PromptUser();
        promptUser.userMazeSize();

        String[] lines = out.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    void testUserSelectedDirectionMethod() {
        String userInput = String.format("N",
                System.lineSeparator());
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        String expected = "You want to go North.";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

        PromptUser promptUser = new PromptUser();
        promptUser.userSelectedDirection();

        String[] lines = out.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }
}