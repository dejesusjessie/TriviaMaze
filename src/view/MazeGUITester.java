package view;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import maze.Maze;
import maze.MazeBuilder;

public class MazeGUITester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame();
		JPanel p = new JPanel();
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        String myMaze = maze.toGUI();
		MazeGraphic m = new MazeGraphic(myMaze);
		
		p.add(m);
		f.add(p);
		f.setSize(680, 880);
		f.setPreferredSize(new Dimension(680,880));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(false);
		

	}

}
