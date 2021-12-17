package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import io.Database;
import io.PlaySound;
import io.Trivia;
import model.GameRunner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * The Room Panel.
 * @author Codi Chun, Kannika Armstrong
 *
 */
public class RoomPanel extends JPanel{
//public class RoomPanel extends JPanel implements ActionListener {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 5752800424701404623L;
	
	/**
	 * Background music file.
	 */
	File myMusicFile = new File(System.getProperty("user.dir") + "/src/sound/African_fun_long.wav");
	
	/**
	 * Background musi player.
	 */
	PlaySound myBackgroundMusic = new PlaySound(myMusicFile);

	/**
	 * ImageIcon
	 */
//	private static ImageIcon redWallNSImg = new ImageIcon("src/image/redWallNS.png");
//	private static ImageIcon redWallEWImg = new ImageIcon("src/image/redWallEW.png");
	private static ImageIcon myBlueNorthWallImg = new ImageIcon("src/image/blueWallNorth.png");
	private static ImageIcon myBlueSouthWallImg = new ImageIcon("src/image/blueWallSouth.png");
	private static ImageIcon myBlueEastWallImg = new ImageIcon("src/image/blueWallEast.png");
	private static ImageIcon myBlueWestWallImg = new ImageIcon("src/image/blueWallWest.png");
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

	private static JButton myNorthButton = new JButton(myBlueNorthWallImg); // Use to display the north wall
	private static JButton mySouthButton = new JButton(myBlueSouthWallImg); // Use to display the south wall
	private static JButton myWestButton = new JButton(myBlueWestWallImg); // Use to display the west wall
	private static JButton myEastButton = new JButton(myBlueEastWallImg); // Use to display the east wall
	private static JButton myDoorNS = new JButton(myDoorNSImg); // Use to display the east wall
	private static JButton myDoorEW = new JButton(myDoorEWImg); // Use to display the east wall
	private static JLabel myAvatar = new JLabel(myAvatarImg); // Use to display the Avatar in the room

	private static JLabel myLabel = new JLabel("✵ Current Room ✵" );

	// JOption image
	private static ImageIcon myHuskyCryImg = new ImageIcon("src/image/huskyCry.gif");

	protected static String hint;
	protected static String myPlayerDirection;


	public RoomPanel(){

		//add all pictures on JPanel
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(20,20,50,20));
		setBackground(new Color(255,222,173));
		add(myLeftPanel, BorderLayout.WEST);
//		myNorthButton.addActionListener(this);
//		mySouthButton.addActionListener(this);
//		myEastButton.addActionListener(this);
//		myWestButton.addActionListener(this);
		setNorthButton();
		setSouthButton();
		setWestButton();
		setEastButton();
		myLeftPanel.setPreferredSize(new Dimension(300,100));
		myLeftPanel.setBackground(Color.BLUE);
		myLeftPanel.setBorder(new EmptyBorder(10,10,10,10));
		myLeftPanel.setLayout(new BorderLayout());
		myLeftPanel.add(myCurrentRoom, BorderLayout.NORTH);
		myCurrentRoom.setBackground(Color.WHITE);
		myCurrentRoom.setPreferredSize(new Dimension(100, 30));
		myCurrentRoom.add(myLabel);
		myLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		//myCurrentRoom.setBorder(new EmptyBorder(0,0,10,0));
		myLeftPanel.add(myRoomDisplay);
		myRoomDisplay.setBackground(Color.WHITE);
		myRoomDisplay.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
		myRoomDisplay.setLayout(new BorderLayout());
		myRoomDisplay.add(myNorthButton, BorderLayout.NORTH);
		myRoomDisplay.add(myWestButton, BorderLayout.WEST);
		myRoomDisplay.add(myEastButton, BorderLayout.EAST);
		myRoomDisplay.add(mySouthButton, BorderLayout.SOUTH);
		myAvatar.setIcon(myAvatarImg);
		myRoomDisplay.add(myAvatar, BorderLayout.CENTER);
		playBackgroundMusic();
	}

	private void setNorthButton() {
		myNorthButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playButtonSound();
				if( canTryN() && !NIsWall() && !hasBridgeN()) {
					Boolean moveN = showQA();
					if(moveN) {
						GameRunner.INSTANCE.openN();
						GameRunner.INSTANCE.moveN();
					}else {
						GameRunner.INSTANCE.lockN();
					}

				}else if (NIsWall()) {
					wallSays();
				}
				else if(hasBridgeN()) {
					GameRunner.INSTANCE.moveN();
				}
				else {
					blockerSays();
				}
				try {
					if (isLost()) {
						lostGameText();
					}
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}

		});
	}

	private void setSouthButton() {
		mySouthButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playButtonSound();
				if( canTryS()&& !SIsWall()&&!hasBridgeS()) {
					Boolean moveS = showQA();
					if(moveS) {
						GameRunner.INSTANCE.openS();
						GameRunner.INSTANCE.moveS();
					}else {
						GameRunner.INSTANCE.lockS();
					}
				} else if (SIsWall()) {
					wallSays();
				}
				else if(hasBridgeS()) {
					GameRunner.INSTANCE.moveS();
				}

				else {
					blockerSays();
				}

				try {
					if (isLost()) {
						lostGameText();
					}
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}


			}
		});
	}

	private void setEastButton() {
		myEastButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playButtonSound();

				if( canTryE()&& !EIsWall() &&!hasBridgeE()) {
					Boolean moveE = showQA();
					if(moveE) {
						GameRunner.INSTANCE.openE();
						GameRunner.INSTANCE.moveE();
					} else {
						GameRunner.INSTANCE.lockE();
					}
				}
				else if (EIsWall()) {
					wallSays();
				}
				else if(hasBridgeE()) {
					GameRunner.INSTANCE.moveE();
				}
				else {
					blockerSays();
				}
				try {
					if (isLost()) {
						lostGameText();
					}
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});

	}

	private void setWestButton() {
		myWestButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playButtonSound();
				if( canTryW()&& !WIsWall() && !hasBridgeW()) {
					playButtonSound();
					Boolean moveW = showQA();
					if(moveW) {
						GameRunner.INSTANCE.openW();
						GameRunner.INSTANCE.moveW();
					}else {
						GameRunner.INSTANCE.lockW();
					}
				} else if (WIsWall()) {
					wallSays();
				}
				else if(hasBridgeW()) {
					GameRunner.INSTANCE.moveW();
				}
				else {
					blockerSays();
				}
				try {
					if (isLost()) {
						lostGameText();
					}
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}

		});
	}

//	private Trivia trivia = Database.getQuestionList().get(0);
//	private String question = trivia.getQuestion();
//	private String answerLetter = trivia.getAnswer();
//	private String[] options = trivia.getOptions();

	private Boolean showQA() {

		Trivia trivia = Database.getQuestionList().get(0);
		String question = trivia.getQuestion();
		String answerLetter = trivia.getAnswer();
		String[] options = trivia.getOptions();
		hint = trivia.getHint();

		//Showing answer for developer mode.
		//Order in JOptionPane is from Right to Left. D, C, B, A

		System.out.println("Developer mode message: the answer is : " + printAnswer(answerLetter));

		int x = JOptionPane.showOptionDialog(null, question,
				"Trivia Question", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options);

		String myAnswer = checkAnswer(answerLetter, options);

		if(options[x].equals(myAnswer)) {
			playCorrectSound();
			JOptionPane.showMessageDialog(null, "Correct!");
			return true;
		}
		else {
			playWrongSound();
			JOptionPane.showMessageDialog(null, "Wrong.");
			return false;
		}


	}

//	public String hintAnswer(){
//		return printAnswer(answerLetter);
//	}
	
	private String printAnswer(String theLetter) {
		String Answer;
		if(theLetter.equals("A")) {
			Answer = "D";
		} else if (theLetter.equals("B")) {
			Answer = "C";
		} else if (theLetter.equals("C")){
			Answer = "B";
		} else if(theLetter.equals("D")) {
			Answer = "A";
		} else {
			Answer = theLetter;
		}
		return Answer;
		
	}

	private String checkAnswer(String theLetter, String[] theOptions) {
		String Answer;
		if(theLetter.equals("A")) {
			Answer = theOptions[0];
		} else if (theLetter.equals("B")) {
			Answer = theOptions[1];
		} else if (theLetter.equals("C")){
			Answer = theOptions[2];
		} else if(theLetter.equals("D")) {
			Answer = theOptions[3];
		} else {
			Answer = theLetter;
		}
		return Answer;
	}

	private Boolean canTryE() {
		Boolean result = true;
		result = GameRunner.INSTANCE.EIsLock();
		return result;
	}

	private Boolean canTryW() {
		Boolean result = true;
		result = GameRunner.INSTANCE.WIsLock();
		return result;
	}

	private Boolean canTryN() {
		Boolean result = true;
		result = GameRunner.INSTANCE.NIsLock();
		return result;
	}

	private Boolean canTryS() {
		Boolean result = true;
		result = GameRunner.INSTANCE.SIsLock();
		return result;
	}

	private boolean NIsWall() {
		boolean result = false;
		result = GameRunner.INSTANCE.getCurrentRoom().getNIsWall();
		return result;
	}

	private boolean SIsWall() {
		boolean result = false;
		result = GameRunner.INSTANCE.getCurrentRoom().getSIsWall();
		return result;
	}

	private boolean WIsWall() {
		boolean result = false;
		result = GameRunner.INSTANCE.getCurrentRoom().getWIsWall();
		return result;
	}

	private boolean EIsWall() {
		boolean result = false;
		result = GameRunner.INSTANCE.getCurrentRoom().getEIsWall();
		return result;
	}

	private void blockerSays() {
		playStopSound();
		JOptionPane.showMessageDialog(null, "You are going to be eaten!! Muhahaha");
	}

	private void wallSays() {
		playStopSound();
		JOptionPane.showMessageDialog(null, "You are hitting the wall!!");
	}

	private void lostGameText() throws IOException {
		playLoseSound();
		Object[] options = {"Restart", "Exit"};
		int response = JOptionPane.showOptionDialog(null,
				"You lose!! Let's try it again!!",
				"Husky Lose",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				myHuskyCryImg,
				options,  //the titles of buttons
				options[0]); //default button title
		if (response == JOptionPane.YES_OPTION){
			GameRunner.INSTANCE.setNewGame();
		}
		if (response == JOptionPane.NO_OPTION){
			System.exit(0);
		}

		//JOptionPane.showMessageDialog(null, "You are lost!! Exit and restart to try again!");
	}

	private boolean isLost() {
		boolean s = !GameRunner.INSTANCE.canTraverse() || (!canTryS() || SIsWall());
		boolean w = !GameRunner.INSTANCE.canTraverse() || (!canTryW() || WIsWall());
		boolean n = !GameRunner.INSTANCE.canTraverse() || (!canTryN() || NIsWall());
		boolean e = !GameRunner.INSTANCE.canTraverse() || (!canTryE() || EIsWall());
		return s && w && n && e;
	}

	private boolean hasBridgeN() {
		boolean result = false;
		result = GameRunner.INSTANCE.getCurrentRoom().getMyNorthDoor().isOpen();
		return result;
	}

	private boolean hasBridgeS() {
		boolean result = false;
		result = GameRunner.INSTANCE.getCurrentRoom().getMySouthDoor().isOpen();
		return result;
	}

	private boolean hasBridgeE() {
		boolean result = false;
		result = GameRunner.INSTANCE.getCurrentRoom().getMyEastDoor().isOpen();
		return result;
	}

	private boolean hasBridgeW() {
		boolean result = false;
		result = GameRunner.INSTANCE.getCurrentRoom().getMyWestDoor().isOpen();
		return result;
	}
	
	private void playButtonSound() {
		File soundFile = new File(System.getProperty("user.dir") + "/src/sound/smw_kick.wav");
		PlaySound buttonSound = new PlaySound(soundFile);
	}
	
	
	
	private void playLoseSound() {
		File soundFile = new File(System.getProperty("user.dir") + "/src/sound/smb_mariodie.wav");
		stopBackgroundMusic();
		PlaySound loseSound = new PlaySound(soundFile);
		
	}
	
	public void stopBackgroundMusic() {
		myBackgroundMusic.stop();
	}
	
	public void playBackgroundMusic() {
		myBackgroundMusic.loop();
	}
	
	public boolean isPlayingMusic() {
		return myBackgroundMusic.isPlaying();
	}
	
	public void playWinSound() {
		File soundFile = new File(System.getProperty("user.dir") + "/src/sound/mparty8_hammer_bro_10.wav");
		stopBackgroundMusic();
		PlaySound winSound = new PlaySound(soundFile);
	}
	
	public void playStopSound() {
		File soundFile = new File(System.getProperty("user.dir") + "/src/sound/smb3_bonus_game_no_match.wav");
		PlaySound stopSound = new PlaySound(soundFile);
	}
	
	public void playCorrectSound() {
		File soundFile = new File(System.getProperty("user.dir") + "/src/sound/smb3_coin.wav");
		PlaySound correctSound = new PlaySound(soundFile);
	}
	
	private void playWrongSound() {
		File soundFile = new File(System.getProperty("user.dir") + "/src/sound/smb3_bump.wav");
		PlaySound correctSound = new PlaySound(soundFile);
	}



//	public void showTrivia(){
//		TriviaPanel.showPanel("TRIVIA");
//	}

//	@Override
//	public void actionPerformed(ActionEvent theEvent) {
//		if(theEvent.getSource() == myNorthButton){
//			showTrivia();
//			myPlayerDirection="NORTH";
//
//		}
//		if(theEvent.getSource() == mySouthButton){
//			showTrivia();
//			myPlayerDirection="SOUTH";
//		}
//		if(theEvent.getSource() == myEastButton){
//			showTrivia();
//			System.out.println("EAST");
//			myPlayerDirection= "EAST";
//		}
//		if(theEvent.getSource() == myWestButton){
//			showTrivia();
//			myPlayerDirection= "WEST";
//
//		}
//
//	}


}
