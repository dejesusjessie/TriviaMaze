package view;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;


public class MazePanel extends JPanel {
	
	MazeGraphic maze = new MazeGraphic();
	
	public MazePanel() throws IOException {

		setLayout(new BorderLayout());
		//setBackground(new Color(255,255,255));
		add(maze, BorderLayout.CENTER);


	}

}
