package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;



/**
 * The information panel.
 * @author Codi Chun
 * @version Fall 2021
 */
public class InfoPanel extends JPanel implements ActionListener{

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -7574118521223544552L;


//	/**
//	 * The START/STOP button.
//	 * For starting and stopping the game and the stopwatch.
//	 */
//	private static JButton myStartButton  = new JButton("START");
//	
//	/**
//	 * The RESET button.
//	 * For reseting the game and the stopwatch. 
//	 */
//	private static final JButton myResetButton = new JButton("RESET");
//	
//	/**
//	 * The Hint button.
//	 * For using the tool "hint".
//	 */
//	private static JButton myHintButton  = new JButton("Hints");
//	
//	/**
//	 * The Key button.
//	 * For using the tool "key".
//	 */
//	private static JButton myKeyButton  = new JButton("Keys");
    

	/**
	 * The stopwatch label.
	 * Showing how much time the game has taken.
	 */
	private static JLabel myStopwatchLabel;

	/**
	 * The stopwatch.
	 * For calculating the time that the game has taken.
	 */
	private static Timer myStopwatch;

	/**
	 * The status of the game.
	 * Show the game is staring or stopping.
	 */
	private static Boolean myStarted;

	/**
	 * Total game time that has taken.
	 */
	private static int myTime;

	/**
	 * Seconds that has taken.
	 */
	private static int mySeconds;

	/**
	 * Minutes that has taken.
	 */
	private static int myMinutes;

	/**
	 * Hours that has taken.
	 */
	private static int myHours;

	/**
	 * The string shows seconds.
	 */
	private String mySecondString;

	/**
	 * The string shows minutes.
	 */
	private String myMinuteString;

	/**
	 * Ths string shows hours.
	 */
	private String myHourString;

	/**
	 * The string that shows total game time.
	 */
	private static String myGameTime;

	/**
	 * Preset the button size.
	 */

	private final Dimension myButtonSize = new Dimension(100, 50); 

	private JTextArea myWelcomeText;

	/**
	 * The constructor.
	 */
	public InfoPanel() {
		setLayout(new BorderLayout(0, 0));
		myStarted = false;

		setStopwatchLabel();
		layoutStopwatch();

		
//		setStartButton();
//		layoutStartButton(); 
//		
//		setResetButton();
//		layoutResetButton();

		
		setWelcomeText();

		//setup the top panel
		JPanel topPanel = new JPanel();
		//topPanel.add(myStartButton);
		//topPanel.add(myResetButton);
		topPanel.add(myStopwatchLabel);
		//myStopwatchLabel.setVisible(true);
		topPanel.setBackground(new Color(255,222,173));


		//setup the bottom panel
//		JPanel bottomPanel = new JPanel();
//		bottomPanel.add(myHintButton);
//		bottomPanel.add(myKeyButton);
//		bottomPanel.setBackground(new Color(255,222,173));

		//add the sub panels to info panel.
		add(topPanel, BorderLayout.NORTH);
		//add(bottomPanel, BorderLayout.SOUTH);
		myWelcomeText.setAlignmentX(100);
		add(myWelcomeText, BorderLayout.CENTER);

	}
	
	private void setWelcomeText() {
		//setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		myWelcomeText = new JTextArea("\nHowooooody! \n\n"
				+"You are a starving husky looking for num-num in the jungle. "
				+"There are many rivers blocking your way from those paw-licking-good delisiouses. "
				+"Luckly, you have a magic skill learnt from the Woof God, that when you point your paw on a river, the Woof God will ask you a trivia question. "
				+ "If you answer it right, the Woof God will give you a bridge to cross the river. "
				+ "However, if you provide a wrong answer... Muhahahaha...!! ", 10,20);
		myWelcomeText.setForeground(new Color(204,153,255));
		myWelcomeText.setWrapStyleWord(true);
		myWelcomeText.setLineWrap(true);
		myWelcomeText.setBackground(new Color(255,222,173));
		myWelcomeText.setFont(new Font("Wawati SC", Font.BOLD, 21));
		myWelcomeText.setEnabled(false);
		myWelcomeText.setDisabledTextColor(new Color(106,90,205));
		myWelcomeText.setBorder(new EmptyBorder(20,20,20,20));
		add(myWelcomeText, BorderLayout.CENTER);

	}

	
//	/**
//	 * Setting the START button.
//	 */
//	private void setStartButton() {	
//		myStartButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(myStarted == false) {
//					myStarted = true;
//					myStartButton.setText("STOP");
//					myStopwatch.start();
////					try {
////
////						GameRunner.getInstance();
////					} catch (IOException e1) {
////						// TODO Auto-generated catch block
////						e1.printStackTrace();
////					}
//				} else {
//					myStarted = false;
//					myStartButton.setText("START");
//					myStopwatch.stop();
//				}
//			}
//		});
//	}
//	
//	/**
//	 * Setting the Reset button.
//	 */
//	private void setResetButton() {
//		myResetButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			myStarted = false;
//			myStopwatch.stop();
//			myTime = 0;
//			mySeconds = 0;
//			myMinutes = 0;
//			myHours = 0;
//			mySecondString = String.format("%02d", mySeconds);
//			myMinuteString = String.format("%02d", myMinutes);
//			myHourString = String.format("%02d", myHours); 
//			myGameTime = myHourString + ":" + myMinuteString + ":" + mySecondString;
//			myStopwatchLabel.setText(myGameTime);
//			}
//		});		
//	}
	

	/**
	 * Setting the hint button.
	 */
	private void setHintButton() {

	}

	/**
	 * Setting the key button.
	 */
	private void setKeyButton() {

	}

	/**
	 * Setting the Stopwatch Label.
	 */
	private void setStopwatchLabel() {
		// Setting the action listener.
		//myStopwatchLabel.setVisible(true);

		myStopwatch = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				myTime += 1000;
				myHours = (myTime / 3600000);
				myMinutes = (myTime / 60000) % 60;
				mySeconds = (myTime / 1000) % 60;
				mySecondString = String.format("%02d", mySeconds);
				myMinuteString = String.format("%02d", myMinutes);
				myHourString = String.format("%02d", myHours);
				myGameTime = myHourString + ":" + myMinuteString + ":" + mySecondString;
				myStopwatchLabel.setText(myGameTime);
			}
		});
	}

	
//	/**
//	 * The design of the START button.
//	 */
//	private void layoutStartButton() {
//		myStartButton.setPreferredSize(myButtonSize);
//
//	}
//	
//	/**
//	 * The design of the RESET button.
//	 */
//	private void layoutResetButton() {
//		myResetButton.setPreferredSize(myButtonSize);
//	}
	

	/**
	 * The design of the Stopwatch label.
	 */
	private void layoutStopwatch() {
		myStopwatchLabel = new JLabel();
		myStopwatchLabel.setBackground(new Color(255,222,173));
		myStopwatchLabel.setVisible(true);
	}

	/**
	 * Getter of the time calculated by the system.
	 * @return The total time.
	 */
	public static int getSystemTime() {
		return myTime;
	}

	/**
	 * Getter of the game time that show on the GUI.
	 * @return The total game time.
	 */
	public static String getGameTime() {
		return myGameTime;
	}

	public void setSystemTime(int theSystemTime) {
		myTime = theSystemTime;
	}

	public void setGameTime(String theGameTime) {
		myGameTime = theGameTime;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}