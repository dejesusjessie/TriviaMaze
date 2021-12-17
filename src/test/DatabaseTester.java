package test;

import io.Database;
import io.Trivia;

import java.util.Arrays;

/**
 * The class to test the database
 * @author Kannika Armstrong
 * @version Fall 2021
 */

public class DatabaseTester {

    public static void main(String[] args) {

        checkNumberOfQuestions();

        readAllQuestions();

        checkRandomlyQuestions();

        checkMethodToGetOptionsAndAnswer();
    }

    private static void checkMethodToGetOptionsAndAnswer() {
        System.out.println(" --------- Check the method to get question/options/correct answer ---------");
        Trivia currentQuestion = Database.getQuestionList().get(0);
        System.out.println("Question      : " + currentQuestion.getQuestion());
        if (currentQuestion.getOptions().length == 4){
            System.out.println("\nOptions represents in [ A, B, C, D] format.");
            System.out.println("Options: " + Arrays.toString(currentQuestion.getOptions()));
        } else {
            System.out.println("\nOptions       : " + Arrays.toString(currentQuestion.getOptions()));
        }
        System.out.println("\nCorrect Answer: " + currentQuestion.getAnswer());
        System.out.println(" ---------------------------------------------------------------------------");
    }

    private static void checkRandomlyQuestions() {
        System.out.println(" --------- Check randomly question from database ---------");
        System.out.println("First question in the list from the first call : " + Database.getQuestionList().get(0).getQuestion());
        System.out.println("First question in the list from the second call: " + Database.getQuestionList().get(0).getQuestion());
        System.out.println("First question in the list from the third call : " + Database.getQuestionList().get(0).getQuestion());
        System.out.println("First question in the list from the fourth call: " + Database.getQuestionList().get(0).getQuestion());
        System.out.println("First question in the list from the fifth call : " + Database.getQuestionList().get(0).getQuestion());
        System.out.println(" ---------------------------------------------------------\n");
    }

    private static void readAllQuestions() {
        System.out.println(" ------- Check reading all questions from database ------");
        System.out.print("[ " );
        for (int i = 0; i < Database.getQuestionList().size(); i++){
            System.out.print(Database.getQuestionList().get(i).getQuestion());
            if (i < Database.getQuestionList().size() - 1) {
                System.out.println(",");
            }
            if (i == Database.getQuestionList().size() - 1) {
                System.out.println(" ]");
            }
        }
        System.out.println(" ---------------------------------------------------------\n");
    }

    private static void checkNumberOfQuestions() {
        System.out.println(" ----- Check the number of question in the database -----");
        System.out.println("Expected: There are 28 Questions in the database");
        System.out.println("Actual:   There are " + Database.getQuestionList().size() + " Questions in the database" );
        System.out.println("---------------------------------------------------------\n");
    }


}
