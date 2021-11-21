package view;

import javax.swing.*;
import java.awt.*;

public class RoomPanel extends JPanel {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 5752800424701404623L;

	/**
	 * ImageIcon
	 */
	private static ImageIcon redWallNSImg = new ImageIcon("src/image/redWallNS.png");
	private static ImageIcon redWallEWImg = new ImageIcon("src/image/redWallEW.png");
	private static ImageIcon blueNorthWallImg = new ImageIcon("src/image/blueWallNorth.png");
	private static ImageIcon blueSouthWallImg = new ImageIcon("src/image/blueWallSouth.png");
	private static ImageIcon blueEastWallImg = new ImageIcon("src/image/blueWallEast.png");
	private static ImageIcon blueWestWallImg = new ImageIcon("src/image/blueWallWest.png");
	private static ImageIcon myAvatarImg = new ImageIcon("src/image/myAvatar.png");
	private static ImageIcon myDoorNSImg = new ImageIcon("src/image/myDoorH.gif");
	private static ImageIcon myDoorEWImg = new ImageIcon(("src/image/myDoorV.gif"));


	/**
	 *  JPanel for all images
	 */
	private JPanel myRoomDisplay = new JPanel(); // Use to display the room
	private JPanel myCurrentRoom = new JPanel(); // Use to Label my current room
	private JPanel myTextDisplay = new JPanel(); // Use for the text section
	private JPanel myLeftPanel = new JPanel();
	private JPanel myRightPanel = new JPanel();

	private static JButton myNorthWall = new JButton(blueNorthWallImg); // Use to display the north wall
	private static JButton mySouthWall = new JButton(blueSouthWallImg); // Use to display the south wall
	private static JButton myWestWall = new JButton(blueWestWallImg); // Use to display the west wall
	private static JButton myEastWall = new JButton(blueEastWallImg); // Use to display the east wall
	private static JButton myDoorNS = new JButton(myDoorNSImg); // Use to display the east wall
	private static JButton myDoorEW = new JButton(myDoorEWImg); // Use to display the east wall
	private static JButton myAvatar = new JButton(myAvatarImg); // Use to display the Avatar in the room


	public RoomPanel(){
		//add all pictures on JPanel
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		final boolean shouldFill = true;
		final boolean shouldWeightX = true;
		final boolean RIGHT_TO_LEFT = false;

		if (shouldFill) {
			gbc.fill = GridBagConstraints.HORIZONTAL;
		}

		if (shouldWeightX) {
			gbc.weightx = 0.4;
		}

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(myLeftPanel, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.6;
		gbc.gridx = 1;
		gbc.gridy = 0;

		add(myRightPanel, gbc);



		//gbc.fill = GridBagConstraints.VERTICAL;

//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		add(myLeftPanel, gbc);
//		myLeftPanel.setBackground(Color.blue);
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		add(myRightPanel, gbc);
//		myRightPanel.setBackground(Color.GREEN);

//		myLeftPanel.setLayout(new BorderLayout());
//		myLeftPanel.add(myCurrentRoom, BorderLayout.NORTH);
//		myCurrentRoom.setBackground(Color.GREEN);
//		myCurrentRoom.setMinimumSize(new Dimension(100,50));
//		myLeftPanel.add(myRoomDisplay, BorderLayout.CENTER);
//		myRoomDisplay.setBackground(Color.black);
//		add(myCurrentRoom);
//		myCurrentRoom.setBackground(Color.blue);
//		add(myRoomDisplay);
//		myRoomDisplay.setBackground(Color.GRAY);
//		add(myTextDisplay);

//		myRoomDisplay.setLayout(new BorderLayout());
//
//
//
//		myNorthWall.setPreferredSize(new Dimension(100,100));
//		mySouthWall.setPreferredSize(new Dimension(100,100));
//		myEastWall.setPreferredSize(new Dimension(100,100));
//		myWestWall.setPreferredSize(new Dimension(100,100));
//		myAvatar.setPreferredSize(new Dimension(100,100));
//
//		myRoomDisplay.add(myNorthWall, BorderLayout.NORTH);
//		myRoomDisplay.add(myWestWall, BorderLayout.WEST);
//		myRoomDisplay.add(myEastWall, BorderLayout.EAST);
//		myRoomDisplay.add(mySouthWall, BorderLayout.SOUTH);
//		myRoomDisplay.add(myAvatar, BorderLayout.CENTER);




	}


}
