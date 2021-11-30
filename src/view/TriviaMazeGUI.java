package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import io.GameData;
import io.Load;
import io.Save;

/**
 * A basic GUI for the game.
 * @author Codi Chun
 * @version Fall 2021
 */
public class TriviaMazeGUI extends JFrame implements ActionListener {
	
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 7115556081062648196L;

	/**
	 * The width of the frame.
	 */
	private static final int MY_WIDTH = 1280;
	
	/**
	 * The height of the frame.
	 */
	private static final int MY_HEIGHT = 1360;

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
	//private static final MazePanel MY_MAZE_PANEL = new MazePanel(MY_WIDTH, MY_HEIGHT);	
	private final MazePanel MY_MAZE_PANEL;
	/**
	 * The info panel.
	 */
	public static final InfoPanel MY_INFO_PANEL = new InfoPanel();
	
	/**
	 * The player panel.
	 */
	private static PlayerPanel MY_PLAYER_PANEL = new PlayerPanel();


	/**
	 * The left panel.
	 * which will contain the info panel and the room panel.
	 */
	private static final JPanel leftPanel = new JPanel(new GridLayout(0,1));

	/**
	 * The File menu at menu bar.
	 */
	private static final JMenu myFileMenu = new JMenu("File");
	
	/**
	 * The Help menu at menu bar.
	 */
	private static final JMenu helpMenu = new JMenu("Help");
	
	/**
	 * The file chooser of loading game.
	 */
	private final JFileChooser myFileChooser = new JFileChooser(System.getProperty("user.dir") + "/savedGame");
	
	/**
	 * Set a filter that only allow to load .bin file
	 */
	final FileNameExtensionFilter fileNameFilter = new FileNameExtensionFilter("Binary Files", "bin");
	
	String myDir = System.getProperty("user.dir");
	BufferedImage myHusky = ImageIO.read(new File(myDir + "/src/image/husky.png"));
	
	
	/**
	 * Constructor.
	 * Constructs a new TriviaMazeGui.
	 * @throws IOException 
	 */
	public TriviaMazeGUI(String theMaze) throws IOException {
		MY_MAZE_PANEL = new MazePanel(theMaze);
		basicWindow(theMaze);
	}
	
//	public TriviaMazeGUI(GameData theGameData) {
//		basicWindow();
//	}
	
	
	/**
	 * Creating the basic frame and panel.
	 * @throws IOException 
	 */
	public void basicWindow(String theMaze) throws IOException {

		
		//Setting the panels.
		//setMazePanel();
		setInfoPanel();
		setRoomPanel();
		setLeftPanel();
		setMainPanel();

		//Basic setting of the window.
		myWindow.add(MY_MAIN_PANEL);
		myWindow.setSize(MY_HEIGHT, MY_WIDTH);
		myWindow.setPreferredSize(new Dimension(MY_HEIGHT, MY_WIDTH));
		//myWindow.setResizable(false);
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


		//prevent the resizable
		myWindow.setResizable(false);

	} 
	
	/**
	 * Setting the main panel.
	 */
	private void setMainPanel() {
		//MY_MAIN_PANEL.setBackground(new Color(255,248,220));
		MY_MAIN_PANEL.setSize(MY_WIDTH, MY_HEIGHT);
		MY_MAIN_PANEL.add(leftPanel, BorderLayout.EAST);
		MY_MAIN_PANEL.add(MY_MAZE_PANEL, BorderLayout.CENTER);
		//mg.setSize(MY_WIDTH/2, MY_HEIGHT/2);
		//MY_MAIN_PANEL.add(mg, BorderLayout.CENTER);
	}
	
	/**
	 * Setting the maze panel.
	 * @throws IOException 
	 */
	private void setMazePanel() throws IOException {
	}
	
	/**
	 * Setting the info panel.
	 */
	private void setInfoPanel() {
		//MY_INFO_PANEL.setBackground(Color.white);
	}
	
	/**
	 * Setting the room panel.
	 */
	private void setRoomPanel() {
<<<<<<< HEAD
		MY_PLAYER_PANEL.setBackground(Color.pink);
=======
		//MY_ROOM_PANEL.setBackground(Color.pink);
>>>>>>> 4b5c7299fe2e36a0b67813560d41543dac1e24d1
	}
	
	/**
	 * 
	 */
	private void setLeftPanel() {
		leftPanel.setOpaque(false);
		leftPanel.add(MY_INFO_PANEL);
		leftPanel.add(MY_PLAYER_PANEL);
		leftPanel.setSize(MY_WIDTH/2, MY_HEIGHT);
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
		saveMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userFileName = JOptionPane.showInputDialog("Enter the file name: ");
					
					try {
						new Save(userFileName);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

			}
		});
	}
	
	/**
	 * Adding the load menu and the action listener.
	 */
	private void addLoadMenu() {
		JMenuItem loadMenu = new JMenuItem("Load Game");
		myFileMenu.add(loadMenu);
		
		//Set only allow to load .bin file
		myFileChooser.addChoosableFileFilter(fileNameFilter);
		myFileChooser.setAcceptAllFileFilterUsed(false);
			
		loadMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				final int selection = myFileChooser.showOpenDialog(null);
				if(selection == JFileChooser.APPROVE_OPTION) {
					try {
						String fileName = myFileChooser.getSelectedFile().getName();
						new Load(fileName);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, 
                                "The selected file did not contain an game record!", 
                                "Error!", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
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
				JOptionPane.showMessageDialog(null, ","
						+"\n1. For moving to another room, you need to open a door."
						+"\n2. You need to selecte the correct answer to open a door, otherwise, the door closes forever.");
			}
		});
	}
	
	/**
	 * Adding the cheats menu and the action listener.
	 */
	private void addCheatsMenu() {
		JMenu cheatsMenu = new JMenu("Cheats");
		JMenuItem doorKeyMenu = new JMenuItem("Bridge");
		JMenuItem hinsAngelMenu = new JMenuItem("Hins");
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
	
	public static void reloadGUI(GameData theGameData) {
		MY_INFO_PANEL.setSystemTime(theGameData.getSystemTime());
		MY_INFO_PANEL.setGameTime(theGameData.getGameTime());
<<<<<<< HEAD
=======
		
>>>>>>> 4b5c7299fe2e36a0b67813560d41543dac1e24d1
	}
	
	public void repaintMaze(String theString) {
		MY_MAZE_PANEL.setMaze(theString);
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
