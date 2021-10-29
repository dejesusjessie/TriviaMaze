package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * A basic GUI for the game.
 * @author Codi Chun
 * @version Fall 2021
 */
public class TriviaMazeGUI extends JFrame implements ActionListener {
	
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

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
	private static final String MY_TITLE = "Trivia Maze 1.0";
	
	/**
	 * The basic Frame
	 */
	public static final JFrame myWindow  = new JFrame();
	
	/**
	 * The maze panel
	 */
	private static final MazePanel myMazePanel = new MazePanel();
	
	
	/**
	 * The File menu at menu bar.
	 */
	private static final JMenu myFileMenu = new JMenu("File");
	
	/**
	 * The Help menu at menu bar.
	 */
	private static final JMenu helpMenu = new JMenu("Help");
	
	
	
	/**
	 * Constructor.
	 * Constructs a new TriviaMazeGui.
	 */
	public TriviaMazeGUI() {
		basicWindow();
	}
	
	/**
	 * Creating the basic frame and panel.
	 */
	public void basicWindow() {
		
		//basic setting for the window.
		myMazePanel.setBorder(BorderFactory.createEmptyBorder(MY_HEIGHT, MY_WIDTH, MY_HEIGHT, MY_WIDTH));
		myMazePanel.setLayout(new GridLayout());
		myWindow.add(myMazePanel, BorderLayout.CENTER);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setting the title of the frame.
		myWindow.setTitle(MY_TITLE);

		
		//adding menu bar
		JMenuBar menuBar = new JMenuBar();
		myWindow.setJMenuBar(menuBar);
		
		// adding File menu
		menuBar.add(myFileMenu);
		addSaveMenu();
		addLoadMenu();
		addExitMenu();
		
		//adding Help menu 
		menuBar.add(helpMenu);
		addAboutMenu();
		addInstructionMenu();
		addCheatsMenu();
		
		//packing and showing the frame
		myWindow.pack();
		myWindow.setVisible(true);
	} 

	/**
	 * Adding the exit menu and the action listener.
	 */
	private void addExitMenu() {
		JMenuItem exitMenu = new JMenuItem("Exit");
		myFileMenu.add(exitMenu);
		exitMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * Adding the save menu and the action listener.
	 */
	private void addSaveMenu() {
		JMenuItem saveMenu = new JMenuItem("Save Game");
		myFileMenu.add(saveMenu);
	}
	
	/**
	 * Adding the load menu and the action listener.
	 */
	private void addLoadMenu() {
		JMenuItem loadMenu = new JMenuItem("Load Game");
		myFileMenu.add(loadMenu);
	}

	/**
	 * Adding the about menu and the action listener.
	 */
	private void addAboutMenu() {
		JMenuItem aboutMenu = new JMenuItem("About");
		helpMenu.add(aboutMenu);
		aboutMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Trivia Maze\nVersion 1.0\n");
			}
		});
		
	}
	
	/**
	 * Adding the instruction menu and the action listener.
	 */
	private void addInstructionMenu() {
		JMenuItem instructionMenu = new JMenuItem("Game Play Instructions");
		helpMenu.add(instructionMenu);
		instructionMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "1. For moving to another room, you need to open a door."
						+"\n2. You need to selecte the correct answer to open a door, otherwise, the door closes forever.");
			}
		});
	}
	
	/**
	 * Adding the cheats menu and the action listener.
	 */
	private void addCheatsMenu() {
		JMenu cheatsMenu = new JMenu("Cheats");
		JMenuItem doorKeyMenu = new JMenuItem("Door Key");
		JMenuItem hinsAngelMenu = new JMenuItem("Hins Angel");
		cheatsMenu.add(doorKeyMenu);
		cheatsMenu.add(hinsAngelMenu);
		helpMenu.add(cheatsMenu);
		
		doorKeyMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "needs to be edied");
			}
		});
		
		hinsAngelMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "The choice is wrong! (needs to be edied)");
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
