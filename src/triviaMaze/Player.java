package triviaMaze;

public class Player {

    private String userName;

    public Player (String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Player: " + userName + "";
    }
}
