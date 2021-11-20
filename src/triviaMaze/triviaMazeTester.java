package triviaMaze;

public class triviaMazeTester {

    public static void main(String[] args) {
        //userNameMethodTest();
        userMazeSizeTest();
    }

    private static void userMazeSizeTest() {
        PromptUser promptUser = new PromptUser();
        promptUser.userMazeSize();
    }

    private static void userNameMethodTest() {
        PromptUser promptUser = new PromptUser();
        promptUser.userName();
    }
}
