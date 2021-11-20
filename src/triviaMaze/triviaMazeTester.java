package triviaMaze;

public class triviaMazeTester {

    public static void main(String[] args) {
        //userNameTest();
        //userMazeSizeTest();
        userSelectedDirectionTest();
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
