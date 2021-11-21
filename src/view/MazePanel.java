package view;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;


public class MazePanel extends JPanel {
	
	MazeGraphic maze;
	//Player p = new Player();
	
	public MazePanel(String theMaze) throws IOException {
		maze = new MazeGraphic(theMaze);

		setLayout(new BorderLayout());
		//setBackground(new Color(255,255,255));
		add(maze);
		//p.setSize(0,0);
		//add(p);


	}
	
	

}
