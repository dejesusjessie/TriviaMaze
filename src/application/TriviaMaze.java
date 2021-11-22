package application;

import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

import maze.Maze;
import maze.MazeBuilder;
import view.MazeGraphic;
import view.TriviaMazeGUI;

public class TriviaMaze {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
        MazeBuilder builder = new MazeBuilder();
        Maze maze = builder.buildRoom();
        String myMaze = maze.toGUI();

		TriviaMazeGUI game = new TriviaMazeGUI(myMaze);
		//System.out.println(maze.toGUI());
		
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


		
        Scanner input = new Scanner(System.in);		
        while(!maze.reachExit()) {
            System.out.println(maze.toString());
            
            //maze panel repaint;
            myMaze = maze.toGUI();
            game.repaintMaze(myMaze);

            
            System.out.println("Select your option: \nn --> Move North\ns --> Move South" +
                    "\nw --> Move West\ne --> Move East");

            char dir = input.next().charAt(0);
            switch(dir) {
                case('n'):
                    maze.moveNorth();

    
        		
                    break;
                case('s'):
                    maze.moveSouth();
                    break;
                case('w'):
                    maze.moveWest();
                    break;
                case('e'):
                    maze.moveEast();
                	game.repaint();
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }

		
	}

}
