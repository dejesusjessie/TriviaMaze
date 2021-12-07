package triviaMaze;

/**
 * The prompt panel.
 * @author Kannika Armstrong
 * @version Fall 2021
 */

public class Player {

    private String myUserName;

    public Player (String theUserName){
        this.myUserName = theUserName;
    }

    public String getUserName() {
        return this.myUserName;
    }

    public void setUserName(String theUserName) {
        this.myUserName = theUserName;
    }

    @Override
    public String toString() {
        return "Player: " + myUserName + "";
    }
}
