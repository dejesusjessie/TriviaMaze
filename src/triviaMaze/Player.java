package triviaMaze;

/**
 * The Player class will use for the store the player information
 * We don't use it in this version, but we created it because
 * in the first plan, we want to store the information of the Player in the database
 * to create the ranking. We will keep it for the case
 * that we will use it again in the future version
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
