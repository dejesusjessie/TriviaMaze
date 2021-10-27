package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A basic GUI for the game.
 * @author Codi Chun
 * @version Fall 2021
 */
public class TriviaMazeGUI extends JFrame implements ActionListener {
	
	/**
	 * The width of the frame.
	 */
	private static final int MY_WIDTH = 600;
	
	/**
	 * The height of the frame.
	 */
	private static final int MY_HEIGHT = 350;

	/**
	 * The title of the frame.
	 */
	private static final String MY_TITLE = "Trivia Maze";
	
	/**
	 * Constructor.
	 * Constructs a new TriviaMazeGui.
	 */
	public TriviaMazeGUI() {
		BasicPanel();
	}
	
	/**
	 * Creating the basic frame and panel.
	 */
	public void BasicPanel() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(MY_HEIGHT, MY_WIDTH, MY_HEIGHT, MY_WIDTH));
		panel.setLayout(new GridLayout());
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(MY_TITLE);
		frame.pack();
		frame.setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
