package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import io.Database;
import io.Trivia;
import model.GameRunner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * 
 * @author Codi Chun, Kannika Armstrong
 *
 */
public class RoomPanel2 extends JPanel {
	//GameRunner game = GameRunner.getInstance();

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

	private static JButton myNorthButton = new JButton(blueNorthWallImg); // Use to display the north wall
	private static JButton mySouthButton = new JButton(blueSouthWallImg); // Use to display the south wall
	private static JButton myWestButton = new JButton(blueWestWallImg); // Use to display the west wall
	private static JButton myEastButton = new JButton(blueEastWallImg); // Use to display the east wall
	private static JButton myDoorNS = new JButton(myDoorNSImg); // Use to display the east wall
	private static JButton myDoorEW = new JButton(myDoorEWImg); // Use to display the east wall
	private static JLabel myAvatar = new JLabel(myAvatarImg); // Use to display the Avatar in the room

	private static JLabel currentRoom = new JLabel("✵ Current Room ✵" );

 

	public RoomPanel2(){

		//add all pictures on JPanel
		setLayout(new BorderLayout());
		add(myLeftPanel, BorderLayout.WEST);

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
		myCurrentRoom.add(currentRoom);
		currentRoom.setFont(new Font("Serif", Font.PLAIN, 24));
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


		add(myRightPanel);
		myRightPanel.setBackground(new Color(255,222,173));

	}
	
	private void setNorthButton() {	
		myNorthButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if( canTryN() && !NIsWall() && !hasBridgeN()) {
					Boolean moveN = showQA();
					if(moveN) {
						try {
							GameRunner.getInstance().openN();
						GameRunner.getInstance().moveN();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					}else {
						try {
							GameRunner.getInstance().lockN();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}else if (NIsWall()) {
					wallSays();
				}
				else if(hasBridgeN()) {
					try {
						GameRunner.getInstance().moveN();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					blockerSays();
				}
				if (isLost()) {
					lostGameText();
				}
			}

		});
	}
	
	private void setSouthButton() {	
		mySouthButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if( canTryS()&& !SIsWall()&&!hasBridgeS()) {
					Boolean moveS = showQA();
					if(moveS) {
						try {
						GameRunner.getInstance().openS();
						GameRunner.getInstance().moveS();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					}else {
						try {
							GameRunner.getInstance().lockS();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else if (SIsWall()) {
					wallSays();
				}
				else if(hasBridgeS()) {
					try {
						GameRunner.getInstance().moveS();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				else {
					blockerSays();
				}
				
				if (isLost()) {
					lostGameText();
				}


			}
		});
	}
	
	private void setEastButton() {	
		myEastButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if( canTryE()&& !EIsWall() &&!hasBridgeE()) {
					Boolean moveE = showQA();
					if(moveE) {
						try {
						GameRunner.getInstance().openE();
						GameRunner.getInstance().moveE();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					} else {
						try {
							GameRunner.getInstance().lockE();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} 
				else if (EIsWall()) {
					wallSays();
				}
				else if(hasBridgeE()) {
					try {
						GameRunner.getInstance().moveE();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					blockerSays();
				}
				if (isLost()) {
					lostGameText();
				}
			}
		});
		
	}
	
	private void setWestButton() {	
		myWestButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if( canTryW()&& !WIsWall() && !hasBridgeW()) {
					Boolean moveW = showQA();
					if(moveW) {
						try {
							GameRunner.getInstance().openW();
						GameRunner.getInstance().moveW();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					}else {
						try {
							GameRunner.getInstance().lockW();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else if (WIsWall()) {
					wallSays();
				}
				else if(hasBridgeW()) {
					try {
						GameRunner.getInstance().moveW();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
						blockerSays();
					}
				if (isLost()) {
					lostGameText();
				}
				}

		});
	}
	
	private Boolean showQA() {
	    Trivia trivia = Database.getQuestionList().get(0);
	    String question = trivia.getQuestion();
	    String answerLetter = trivia.getAnswer();
	    String[] options = trivia.getOptions();
	    
	    //Showing answer for developer mode. 
	    //TODO Should delete when turn in. 
		System.out.println("Deverloper mode message: the answer is : " + answerLetter);
		
		int x = JOptionPane.showOptionDialog(null, question,
                "Trivia Question", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);

		String myAnswer = checkAnswer(answerLetter, options);

		if(options[x].equals(myAnswer)) {
			JOptionPane.showMessageDialog(null, "Correct!");
			return true;
			
		} else {
			JOptionPane.showMessageDialog(null, "Wrong.");
			return false;
		}
		
	}
	
	private String checkAnswer(String theLetter, String[] theOptions) {
		String Answer;
		if(theLetter.equals("A")) {
			Answer = theOptions[3];
		} else if (theLetter.equals("B")) {
			Answer = theOptions[2];
		} else if (theLetter.equals("C")){
			Answer = theOptions[1];
		} else if(theLetter.equals("D")) {
			Answer = theOptions[0];
		} else {
			Answer = theLetter;
		}
		return Answer;
	}
	
	private Boolean canTryE() {
		Boolean result = true;
		try {
			result = GameRunner.getInstance().EIsLock();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private Boolean canTryW() {
		Boolean result = true;
		try {
			result = GameRunner.getInstance().WIsLock();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private Boolean canTryN() {
		Boolean result = true;
		try {
			result = GameRunner.getInstance().NIsLock();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	
	private Boolean canTryS() {
		Boolean result = true;
		try {
			result = GameRunner.getInstance().SIsLock();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean NIsWall() {
		boolean result = false;
		try {
			result = GameRunner.getInstance().getCurrentRoom().getNIsWall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean SIsWall() {
		boolean result = false;
		try {
			result = GameRunner.getInstance().getCurrentRoom().getSIsWall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean WIsWall() {
		boolean result = false;
		try {
			result = GameRunner.getInstance().getCurrentRoom().getWIsWall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean EIsWall() {
		boolean result = false;
		try {
			result = GameRunner.getInstance().getCurrentRoom().getEIsWall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private void blockerSays() {
		JOptionPane.showMessageDialog(null, "You are going to be eaten!! Muhahaha");
	}
	
	private void wallSays() {
		JOptionPane.showMessageDialog(null, "You are hitting the wall!!");
	}
	
	private void lostGameText() {
		JOptionPane.showMessageDialog(null, "You are lost!! Exit and restart to try again!");
	}
	
	private boolean isLost() {
		boolean s = !canTryS() || SIsWall();
		boolean w = !canTryW() || WIsWall();
		boolean n = !canTryN() || NIsWall();
		boolean e = !canTryE() || EIsWall();

		return s && w && n && e;
	}
	
	private boolean hasBridgeN() {
		boolean result = false;
		try {
			result = GameRunner.getInstance().getCurrentRoom().getNorthDoor().isOpen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean hasBridgeS() {
		boolean result = false;
		try {
			result = GameRunner.getInstance().getCurrentRoom().getSouthDoor().isOpen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean hasBridgeE() {
		boolean result = false;
		try {
			result = GameRunner.getInstance().getCurrentRoom().getEastDoor().isOpen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean hasBridgeW() {
		boolean result = false;
		try {
			result = GameRunner.getInstance().getCurrentRoom().getWestDoor().isOpen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


}

