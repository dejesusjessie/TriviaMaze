package view;

import javax.swing.*;
import java.awt.*;

/**
 * Splits the player panel to the room panel and trivia panel
 * Author: Kannika Armstrong, Jessie De Jesus, Codi Chun
 */
public class PlayerPanel extends JPanel {
    private static final RoomPanel MY_ROOM_PANEL = new RoomPanel();
    private static final TriviaPanel MY_TRIVIA_PANEL = new TriviaPanel();

    /**
     * Constructs the player panel and splits room panel (left) and trivia panel (right)
     */
    public PlayerPanel() {
        this.setLayout(new GridLayout(1, 2));
        this.add(MY_ROOM_PANEL);
        this.add(MY_TRIVIA_PANEL);
    }
    
    public RoomPanel getRoomPanel() {
    	return MY_ROOM_PANEL;
    }
}
