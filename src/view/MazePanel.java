package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The maze panel that shows the maze on GUI. 
 * @author Codi Chun
 * @version Fall 2021
 */
public class MazePanel extends JPanel {
	
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 2669892546274779870L;

	/**
	 * The Dir of the folder. 
	 */
	String myDir = System.getProperty("user.dir");
	
	/**
	 * The string that decides what the maze panel looks like.
	 * It generates from the maze model. 
	 * It changes each movement. 
	 */
	String myMaze;
	
	// For testing.
	int myX = -75;	// TODO can be delete later. 
	int myY = 90;	// TODO can be delete later. 
	
	/**
	 * The constructor. 
	 * @param theMaze
	 * @throws IOException
	 */
	public MazePanel(String theMaze) throws IOException {
		myMaze = theMaze;  
	}
	
	/**
	 * A method that tests the movement of the character.
	 * TODO can be delete later. 
	 */
	public void move() {
		myX += 150;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(255,222,173));
		
		//Adding the images for the panel
		ImageIcon myWallH = new ImageIcon(myDir + "/src/image/WallH.png");
		ImageIcon myWallV = new ImageIcon(myDir + "/src/image/WallV.png");
		
		ImageIcon myDoorH = new ImageIcon(myDir + "/src/image/DoorH.png");
		ImageIcon myDoorV = new ImageIcon(myDir + "/src/image/DoorV.png");
		
		ImageIcon myOpenedDoorH = new ImageIcon(myDir + "/src/image/OpenedDoorH.png");
		ImageIcon myOpenedDoorV = new ImageIcon(myDir + "/src/image/OpenedDoorV.png");
		
		ImageIcon myClosedDoorH = new ImageIcon(myDir + "/src/image/ClosedDoorH.png");
		ImageIcon myClosedDoorV = new ImageIcon(myDir + "/src/image/ClosedDoorV.png");
		
		ImageIcon myBlokerH = new ImageIcon(myDir + "/src/image/croH.png");
		ImageIcon myBridgeH = new ImageIcon(myDir + "/src/image/bridgeH.png");
		ImageIcon myBridgeV = new ImageIcon(myDir + "/src/image/bridgeV.png");
			
		ImageIcon myHusky = new ImageIcon(myDir + "/src/image/husky.png");
		ImageIcon myFruit = new ImageIcon(myDir + "/src/image/fruit.png");
		
		//myHusky.paintIcon(this, g, myX, myY);	// TODO can be delete later. 
		
		//Setting the wall size.
		int wallSize = 150;
		
		//Setting the initial coordinate x and y value.  
		int x = 50;
		int y = 0;
		
		//To start building the maze GUI base on the argument.
		for(int i=0; i<myMaze.length(); i++) {
			if(myMaze.charAt(i) == 'W') {
				myWallH.paintIcon(this, g, x, y);
				x+=wallSize;

			} else if(myMaze.charAt(i) == 'V') {
				x-=wallSize/2;
				myWallV.paintIcon(this, g, x, y);
				x += wallSize;
				
			} else if(myMaze.charAt(i) == 'n') {
				x = 50;
				y+=wallSize/2;
				
			} else if(myMaze.charAt(i) == '+') {
				//x += 30;
				
			} else if(myMaze.charAt(i) == '|') {
				myDoorV.paintIcon(this, g, x, y);
				//myBlokerH.paintIcon(this, g, x+50, y+50);
				//myBridgeV.paintIcon(this, g, x+50, y+50);
				x+=wallSize;			
			} else if(myMaze.charAt(i) == '-') {
				myDoorH.paintIcon(this, g, x, y);
				x+=wallSize;
			} else if(myMaze.charAt(i) == ' ') {
				//x+=wallSize;
			} else if(myMaze.charAt(i) == 'E') {
				//x-=wallSize/2;
				myWallV.paintIcon(this, g, x, y);
				x += wallSize;
			} else if(myMaze.charAt(i) == 'P') {
				myHusky.paintIcon(this, g, x-50, y+30);
			} else if (myMaze.charAt(i) == 'x') {
				myDoorV.paintIcon(this, g, x, y);
				myBlokerH.paintIcon(this, g, x+50, y+50);
				x+=wallSize;
			} else if (myMaze.charAt(i) == 'e') {

				myFruit.paintIcon(this, g, x-50, y+30);
			} else if (myMaze.charAt(i) == 'b') {
				myDoorH.paintIcon(this, g, x, y);
				myBlokerH.paintIcon(this, g, x+50, y+50);
				x+=wallSize;
			} else if (myMaze.charAt(i) == 'o') {
				myDoorV.paintIcon(this, g, x, y);
				myBridgeV.paintIcon(this, g, x+50, y+50);
				x+=wallSize;
			} else if (myMaze.charAt(i) == 'k') {
				myDoorH.paintIcon(this, g, x, y);
				myBridgeH.paintIcon(this, g, x+50, y+50);
				x+=wallSize;
			}
			
			
// 			//***********************************************************************************		
//			// Don't delete
//			// use later
//			
//			//adding bloker and bridge 
//			if(answer wrong) {
//				g2d.drawImage(myBlokerH,x+50,y+50,wallSize/3,wallSize/3, null);
//			}
//			
//			if(anser correct) {
//				g2d.drawImage(myBridgeH,x+50,y+50,wallSize/3,wallSize/3, null);
//			}
//			
// 			//**********************************************************************************
		}
		
		
	}
	
	/**
	 * The setter.
	 * Repaint the panel when pass a new argument. 
	 * @param theString
	 */
	public void setMaze(String theString) {
		myMaze = theString;
		revalidate();
		repaint();
	}
	
	// TODO can be delete later. 
//	public void reDraw() {
//		revalidate();
//		repaint();
//	}
	


}
