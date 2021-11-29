package application;


import java.io.IOException;
import model.gameRunner;
import view.InitialGUI;
import view.TriviaMazeGUI;

/**
 * The main of the program.
 * @author Codi Chun
 * @version Fall 2021
 */
public class TriviaMaze {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		//Version 1
//        MazeBuilder myBuilder = new MazeBuilder();
//        Maze myMaze = myBuilder.buildRoom();
//        String myMazeString = myMaze.toGUI();
//		TriviaMazeGUI myGUI = new TriviaMazeGUI(myMazeString);
//		new gameRunner(myBuilder, myMaze, myMazeString, myGUI);
		
        //Version 2
        InitialGUI myInitialGUI = new InitialGUI();
		new gameRunner(myInitialGUI.getBuilder(), myInitialGUI.getMaze(), 
				myInitialGUI.getString(), myInitialGUI.getGUI());

		
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					String myMaze = maze.toGUI();
//					game.basicWindow(myMaze);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		});
		
	}

}
