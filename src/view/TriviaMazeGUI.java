package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	private static final int MY_WIDTH = 400;
	
	/**
	 * The height of the frame.
	 */
	private static final int MY_HEIGHT = 350;

	/**
	 * The title of the frame.
	 */
	private static final String MY_TITLE = "Trivia Maze 1.0";
	
	/**
	 * The basic Frame.
	 */
	public static final JFrame myWindow  = new JFrame();
	
	/**
	 * The main panel.
	 */
	private static final JPanel MY_MAIN_PANEL = new JPanel(new GridLayout(1, 2));
	
	/**
	 * The maze panel.
	 */
	private static final MazePanel MY_MAZE_PANEL = new MazePanel();
	
	/**
	 * The info panel.
	 */
	private static final InfoPanel MY_INFO_PANEL = new InfoPanel();
	
	/**
	 * The room panel.
	 */
	private static final RoomPanel MY_ROOM_PANEL = new RoomPanel();
	
	/**
	 * The left panel.
	 * which will contain the info panel and the room panel.
	 */
	private static final JPanel leftPanel = new JPanel(new GridLayout(0, 1));
	
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
		
		//Setting the panels.
		setMazePanel();
		setInfoPanel();
		setRoomPanel();
		setLeftPanel();
		setMainPanel();

		//Basic setting of the window.
		myWindow.add(MY_MAIN_PANEL);
		myWindow.setSize(MY_HEIGHT, MY_WIDTH);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setting the title of the window.
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
	 * Setting the main panel.
	 */
	private void setMainPanel() {
		MY_MAIN_PANEL.setBackground(Color.black);
		MY_MAIN_PANEL.add(leftPanel, BorderLayout.EAST);
		MY_MAIN_PANEL.add(MY_MAZE_PANEL, BorderLayout.CENTER);
	}
	
	/**
	 * Setting the maze panel.
	 */
	private void setMazePanel() {
		MY_MAZE_PANEL.setBorder(BorderFactory.createEmptyBorder(MY_HEIGHT, MY_WIDTH, MY_HEIGHT, MY_WIDTH));
		MY_MAZE_PANEL.setSize(MY_WIDTH, MY_HEIGHT);
		MY_MAZE_PANEL.setLayout(new BorderLayout(1, 1));
		MY_MAZE_PANEL.setBackground(Color.GRAY);
		MY_MAZE_PANEL.setSize(MY_WIDTH, MY_HEIGHT);
	}
	
	/**
	 * Setting the info panel.
	 */
	private void setInfoPanel() {
		MY_INFO_PANEL.setBackground(Color.CYAN);
	}
	
	/**
	 * Setting the room panel.
	 */
	private void setRoomPanel() {
		MY_ROOM_PANEL.setBackground(Color.pink);
		MY_ROOM_PANEL.setSize(MY_WIDTH/2, MY_HEIGHT/2);
		MY_ROOM_PANEL.setSize(MY_WIDTH/2, MY_HEIGHT/2);
	}
	
	/**
	 * Setting the lest penel.
	 */
	private void setLeftPanel() {
		leftPanel.setOpaque(false);
		leftPanel.add(MY_INFO_PANEL);
		leftPanel.add(MY_ROOM_PANEL);
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
