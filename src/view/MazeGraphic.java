package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import maze.Maze;
import maze.MazeBuilder;


public class MazeGraphic extends JComponent {
	

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
	
	/**
	 * 
	 */
	BufferedImage myWallH = ImageIO.read(new File(myDir + "/src/image/WallH.png"));
	
	/**
	 * 
	 */
	BufferedImage myWallV = ImageIO.read(new File(myDir + "/src/image/WallV.png"));
	
	/**
	 * 
	 */
	BufferedImage myDoorH = ImageIO.read(new File(myDir + "/src/image/DoorH.png"));
	
	
	BufferedImage myDoorV = ImageIO.read(new File(myDir + "/src/image/DoorV.png"));
	
	BufferedImage myOpenedDoorH = ImageIO.read(new File(myDir + "/src/image/OpenedDoorH.png"));
//	BufferedImage myOpenedDoorE = ImageIO.read(new File(myDir + "/src/image/OpenedDoorE.png"));
//	BufferedImage myOpenedDoorN = ImageIO.read(new File(myDir + "/src/image/OpenedDoorN.png"));
	BufferedImage myOpenedDoorV = ImageIO.read(new File(myDir + "/src/image/OpenedDoorV.png"));
	
	BufferedImage myClosedDoorH = ImageIO.read(new File(myDir + "/src/image/ClosedDoorH.png"));
	BufferedImage myClosedDoorV = ImageIO.read(new File(myDir + "/src/image/ClosedDoorV.png"));
	
	BufferedImage myBlokerH = ImageIO.read(new File(myDir + "/src/image/croH.png"));
	BufferedImage myBridgeH = ImageIO.read(new File(myDir + "/src/image/bridgeH.png"));
	BufferedImage myBridgeV = ImageIO.read(new File(myDir + "/src/image/bridgeV.png"));
	
	BufferedImage myHusky = ImageIO.read(new File(myDir + "/src/image/husky.png"));
	
	//BufferedImage myCharacter = ImageIO.read(new File(myDir + "/image/human.gif"));
	URL myCharacterURL = this.getClass().getClassLoader().getResource("image/running.gif");
	Image myCharacter = new ImageIcon(myCharacterURL).getImage();
	//Icon myCharacter = new ImageIcon(myDir + "/image/human.gif");
	//ImageIcon icon = new ImageIcon(myCharacterURL);
	//JLabel label = new JLabel(icon);
	
	String myMaze;
	int myX;
	int myY;
	
	public MazeGraphic(String theMaze) throws IOException {
		//System.out.println(myCharacterURL);
		//myWidth = theWidth;
		//myHeight = theHeight;
		//painComponent();
		//setBorder(BorderFactory.createEmptyBorder(MY_HEIGHT/2, MY_WIDTH/2, MY_HEIGHT/2, MY_WIDTH/2));
//        MazeBuilder builder = new MazeBuilder();
//        Maze maze = builder.buildRoom();
//        myMaze = maze.toGUI();
       // add(label);
       
		
		myMaze = theMaze;
             
	}
	
//	public MazeGraphic(int x, int y) throws IOException {
//		//System.out.println(myCharacterURL);
//		//myWidth = theWidth;
//		//myHeight = theHeight;
//		//painComponent();
//        MazeBuilder builder = new MazeBuilder();
//        Maze maze = builder.buildRoom();
//        myMaze = maze.toGUI();
//       // add(label);        
//	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(new Color(255,255,255));
		int wallSize = 150;
		int x = 50;
		int y = 0;
		
		//g2d.drawImage(myWallH,x,y,100,100, null);
		
		//drawing the maze.
		//int x = 0;
		for(int i=0; i<myMaze.length(); i++) {
			if(myMaze.charAt(i) == 'W') {
				g2d.drawImage(myWallH,x,y,wallSize,wallSize, null);
				x+=wallSize;

			} else if(myMaze.charAt(i) == 'V') {
				x-=wallSize/2;
				g2d.drawImage(myWallV,x,y,wallSize,wallSize, null);
				x += wallSize;
				
			} else if(myMaze.charAt(i) == 'n') {
				x = 50;
				y+=wallSize/2;
				
			} else if(myMaze.charAt(i) == '+') {
				//x += 30;
				
			} else if(myMaze.charAt(i) == '|') {
				g2d.drawImage(myDoorV,x,y,wallSize,wallSize, null);
				//g2d.drawImage(myBridgeV,x+50,y+50,wallSize/3,wallSize/3, null);
				//g2d.drawImage(myBlokerH,x+50,y+50,wallSize/3,wallSize/3, null);
				x+=wallSize;
				
			} else if(myMaze.charAt(i) == '-') {
				g2d.drawImage(myDoorH,x,y,wallSize,wallSize, null);
				//g2d.drawImage(myBridgeH,x+50,y+50,wallSize/3,wallSize/3, null);
				//g2d.drawImage(myBlokerH,x+50,y+50,wallSize/3,wallSize/3, null);
				x+=wallSize;
			} else if(myMaze.charAt(i) == ' ') {
				//x+=wallSize;
			} else if(myMaze.charAt(i) == 'E') {
				//x-=wallSize/2;
				g2d.drawImage(myWallV,x,y,wallSize,wallSize, null);
				x += wallSize;
			} else if(myMaze.charAt(i) == 'P') {

				//g2d.drawImage(myCharacter,x,y,70,50, null);
				g2d.drawImage(myHusky, x-30,y+30,wallSize/2,wallSize/2, null);
				//System.out.println(x-30+" "+y+30);
				
				//g2d.drawImage(myHusky, myX,myY,wallSize/2,wallSize/2, null);
				
			} else if (myMaze.charAt(i) == 'x') {
				g2d.drawImage(myDoorH,x,y,wallSize,wallSize, null);
				g2d.drawImage(myBlokerH,x+50,y+50,wallSize/3,wallSize/3, null);
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
	
	
	public void drawMaze() {
	}
}