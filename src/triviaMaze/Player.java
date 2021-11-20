package triviaMaze;

public class Player {

    private String myUserName;

    public Player (String userName){
        this.myUserName = userName;
    }

    public String getUserName() {
        return this.myUserName;
    }

    public void setUserName(String userName) {
        this.myUserName = userName;
    }

    @Override
    public String toString() {
        return "Player: " + myUserName + "";
    }
}
