package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private static ImageIcon myAvatarImg = new ImageIcon("src/image/huskyAvatar1.gif");
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
	private static JLabel myAvatar = new JLabel(myAvatarImg); // Use to display the Avatar in the room

	private static JLabel myNorthWallLabel = new JLabel(blueNorthWallImg); // Use to display the north wall
	private static JLabel mySouthWallLabel = new JLabel(blueSouthWallImg); // Use to display the south wall
	private static JLabel myWestWallLabel = new JLabel(blueWestWallImg); // Use to display the west wall
	private static JLabel myEastWallLabel = new JLabel(blueEastWallImg); // Use to display the east wall

	private static JLabel currentRoom = new JLabel("✵ Current Room ✵" );

	// Panels to show in text panel






	public RoomPanel(){
		//add all pictures on JPanel
		setLayout(new BorderLayout());
		add(myLeftPanel, BorderLayout.WEST);

		// Setting the graphic in the left panel of room panel
		myLeftPanel.setPreferredSize(new Dimension(300,100));
		myLeftPanel.setBackground(new Color(255,222,173));
		myLeftPanel.setBorder(new EmptyBorder(10,10,10,10));
		myLeftPanel.setLayout(new BorderLayout());
		myLeftPanel.add(myCurrentRoom, BorderLayout.NORTH);
		myCurrentRoom.setBackground(Color.WHITE);
		myCurrentRoom.setPreferredSize(new Dimension(100, 30));
		myCurrentRoom.add(currentRoom);
		currentRoom.setFont(new Font("Serif", Font.PLAIN, 24));
		//myCurrentRoom.setBorder(new EmptyBorder(0,0,10,0));
		myLeftPanel.add(myRoomDisplay);
		myRoomDisplay.setBackground(Color.WHITE);
		myRoomDisplay.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
		myRoomDisplay.setLayout(new BorderLayout());
		myRoomDisplay.add(myNorthWall, BorderLayout.NORTH);
		myRoomDisplay.add(myWestWall, BorderLayout.WEST);
		myRoomDisplay.add(myEastWall, BorderLayout.EAST);
		myRoomDisplay.add(mySouthWall, BorderLayout.SOUTH);
		//myAvatar.setIcon(myAvatarImg);
		myRoomDisplay.add(myAvatar, BorderLayout.CENTER);

		// add listener to the current room button
		myNorthWall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		mySouthWall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		myWestWall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		myEastWall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});



		// Setting the graphic in the right panel
		add(myRightPanel);
		myRightPanel.setPreferredSize(new Dimension(300,100));
		myRightPanel.setBackground(new Color(255,222,173));
		myRightPanel.setBorder(new EmptyBorder(10,10,10,10));
		myRightPanel.setLayout(new BorderLayout());
		myRightPanel.add(myNorthWallLabel,BorderLayout.NORTH);
		myRightPanel.add(mySouthWallLabel,BorderLayout.SOUTH);
		myRightPanel.add(myEastWallLabel,BorderLayout.EAST);
		myRightPanel.add(myWestWallLabel,BorderLayout.WEST);
		myRightPanel.add(myTextDisplay, BorderLayout.CENTER);
		myTextDisplay.setBackground(Color.WHITE);

		// the first welcome panel
		JLabel welcomeLabel = new JLabel("<html><center>Let's Go Hunting!!" +
				"<br><br>Click the wall in the current room" +
				"<br><br>to select your direction.</center></html>");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
		myTextDisplay.add(welcomeLabel, SwingConstants.CENTER);
		myTextDisplay.setLayout(new GridLayout());
		welcomeLabel.setForeground(Color.blue);
		welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 20));




		//add(myRightPanel); add the trivia panel on the right panel
//		TriviaPanel triviaPanel = new TriviaPanel();
//		add(triviaPanel);
//		triviaPanel.setBackground(new Color(255,222,173));
//		triviaPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


		

	}
}
