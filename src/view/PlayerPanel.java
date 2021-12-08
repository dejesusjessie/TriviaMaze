package view;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
    private static final RoomPanel2 MY_ROOM_PANEL = new RoomPanel2();
    private static final TriviaPanel MY_TRIVIA_PANEL = new TriviaPanel();

    public PlayerPanel() {
        this.setLayout(new GridLayout(1, 2));
        this.add(MY_ROOM_PANEL);
        //this.add(MY_TRIVIA_PANEL);
    }
}
