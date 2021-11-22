package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MazePanel extends JPanel {
//	
//	MazeGraphic maze;
//	//Player p = new Player();
//	
//	public MazePanel(String theMaze) throws IOException {
//		maze = new MazeGraphic(theMaze);
//
//		setLayout(new BorderLayout());
//		//setBackground(new Color(255,255,255));
//		add(maze);
//		//p.setSize(0,0);
//		//add(p);
//
//
//	}
//	
//	public void repaintMaze() {
//		maze.repaint();
//	}
//	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2669892546274779870L;
	
	/**
	 * The width of the frame.
	 */
	private static final int MY_WIDTH = 680;
	
	/**
	 * The height of the frame.
	 */
	private static final int MY_HEIGHT = 880;

	/**
	 * 
	 */
	String myDir = System.getProperty("user.dir");
	
	String myMaze;
	int myX = -75;
	int myY = 90;
	
	public MazePanel(String theMaze) throws IOException {
		
		myMaze = theMaze;
             
	}
	
	public void move() {
		myX += 150;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(255,222,173));
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
		
		//myHusky.paintIcon(this, g, myX, myY);

		int wallSize = 150;
		int x = 50;
		int y = 0;
		
		for(int i=0; i<myMaze.length(); i++) {
			if(myMaze.charAt(i) == 'W') {
				//g2d.drawImage(myWallH,x,y,wallSize,wallSize, null);
				myWallH.paintIcon(this, g, x, y);
				x+=wallSize;

			} else if(myMaze.charAt(i) == 'V') {
				x-=wallSize/2;
				//g2d.drawImage(myWallV,x,y,wallSize,wallSize, null);
				myWallV.paintIcon(this, g, x, y);
				x += wallSize;
				
			} else if(myMaze.charAt(i) == 'n') {
				x = 50;
				y+=wallSize/2;
				
			} else if(myMaze.charAt(i) == '+') {
				//x += 30;
				
			} else if(myMaze.charAt(i) == '|') {
				//g2d.drawImage(myDoorV,x,y,wallSize,wallSize, null);
				myDoorV.paintIcon(this, g, x, y);
				
				//g2d.drawImage(myBridgeV,x+50,y+50,wallSize/3,wallSize/3, null);
				//g2d.drawImage(myBlokerH,x+50,y+50,wallSize/3,wallSize/3, null);
				//myBlokerH.paintIcon(this, g, x+50, y+50);
				//myBridgeV.paintIcon(this, g, x+50, y+50);
				
				x+=wallSize;
				
			} else if(myMaze.charAt(i) == '-') {
				//g2d.drawImage(myDoorH,x,y,wallSize,wallSize, null);
				myDoorH.paintIcon(this, g, x, y);
				
				//g2d.drawImage(myBridgeH,x+50,y+50,wallSize/3,wallSize/3, null);
				//g2d.drawImage(myBlokerH,x+50,y+50,wallSize/3,wallSize/3, null);
				x+=wallSize;
			} else if(myMaze.charAt(i) == ' ') {
				//x+=wallSize;
			} else if(myMaze.charAt(i) == 'E') {
				//x-=wallSize/2;
				//g2d.drawImage(myWallV,x,y,wallSize,wallSize, null);
				myWallV.paintIcon(this, g, x, y);
				
				
				x += wallSize;
			} else if(myMaze.charAt(i) == 'P') {

				//g2d.drawImage(myHusky, x-30,y+30,wallSize/2,wallSize/2, null);
				//g2d.drawImage(myHusky, x-30,y+30,wallSize/2,wallSize/2, null);
				myHusky.paintIcon(this, g, x-50, y+30);
				
			} else if (myMaze.charAt(i) == 'x') {
				//g2d.drawImage(myDoorH,x,y,wallSize,wallSize, null);
				myDoorH.paintIcon(this, g, x, y);
				
				//g2d.drawImage(myBlokerH,x+50,y+50,wallSize/3,wallSize/3, null);
				myBlokerH.paintIcon(this, g, x+50, y+50);
				
				x+=wallSize;
			}
			
			else if (myMaze.charAt(i) == 'e') {
				//g2d.drawImage(myFruit, x-30,y+30,wallSize/2,wallSize/2, null);
				myFruit.paintIcon(this, g, x-50, y+30);
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
	
	public void setMaze(String theString) {
		myMaze = theString;
		revalidate();
		repaint();
	}
	
	public void reDraw() {
		revalidate();
		repaint();
	}
	

}
