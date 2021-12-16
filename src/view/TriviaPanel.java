package view;


import io.Database;
import io.Trivia;
import javax.swing.*;
import java.awt.*;

/**
 * Trivia Panel is the main panel that displays the Question, Option, Submit display panels
 */
public class TriviaPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7289031515829230033L;
	protected static final Trivia myTrivia = Database.getQuestionList().get(0);
    protected static final String MY_QUESTION = myTrivia.getQuestion();
    protected static final String MY_ANSWER = myTrivia.getAnswer();
    protected static final String[] MY_OPTIONS = myTrivia.getOptions();

    /**
     * Displays image of north, south, east, west blue brick walls
     */
    private static ImageIcon blueNorthWallImg = new ImageIcon("src/image/blueWallNorth.png");
    private static ImageIcon blueSouthWallImg = new ImageIcon("src/image/blueWallSouth.png");
    private static ImageIcon blueEastWallImg = new ImageIcon("src/image/blueWallEast.png");
    private static ImageIcon blueWestWallImg = new ImageIcon("src/image/blueWallWest.png");
    private static JLabel myNorthWall = new JLabel(blueNorthWallImg);
    private static JLabel mySouthWall = new JLabel(blueSouthWallImg);
    private static JLabel myEastWall = new JLabel(blueEastWallImg);
    private static JLabel myWestWall = new JLabel(blueWestWallImg);

    private final JPanel myClosedDoorPanel = new JPanel();
    private final JPanel myOpenDoorPanel = new JPanel();
    private final JPanel myWelcomePanel = new JPanel();
    private static final JPanel myTriviaDisplayPanel = new JPanel();
    private final static CardLayout myCardLayout = new CardLayout();
    private final static JPanel myPanelContainer = new JPanel();

    private static final JPanel myQuestionDisplayPanel = new QuestionDisplayPanel();
    private static final JPanel myOptionDisplayPanel = new OptionDisplayPanel();
    private final JPanel mySubmitDisplayPanel = new SubmitDisplayPanel();


    /**
     * Constructs Trivia Panel
     */
    public TriviaPanel(){
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(1f,0f,0f,.5f ));
        this.add(myNorthWall,BorderLayout.NORTH);
        this.add(mySouthWall,BorderLayout.SOUTH);
        this.add(myEastWall,BorderLayout.EAST);
        this.add(myWestWall,BorderLayout.WEST);
        configureTriviaDisplayPanel();
        configureWelcomePanel();
        configurePanelContainer();
        configureOpenDoorPanel();
        configureClosedDoorPanel();
        this.add(myPanelContainer);

    }

    /**
     * Configures trivia display panel. Contains question, option, submit panel.
     */
    private void configureTriviaDisplayPanel(){
        myTriviaDisplayPanel.setBackground(Color.WHITE);
        myTriviaDisplayPanel.setLayout(new BorderLayout());
        myTriviaDisplayPanel.setPreferredSize(new Dimension(100,25));


        myTriviaDisplayPanel.add(myQuestionDisplayPanel, BorderLayout.CENTER);


        myTriviaDisplayPanel.add(mySubmitDisplayPanel);

        myTriviaDisplayPanel.add(myQuestionDisplayPanel,BorderLayout.NORTH);
        myTriviaDisplayPanel.add(myOptionDisplayPanel,BorderLayout.CENTER);
        myTriviaDisplayPanel.add(mySubmitDisplayPanel, BorderLayout.SOUTH);
    }

    /**
     * Configures open door message panel
     */
    private void configureOpenDoorPanel(){
        myOpenDoorPanel.setLayout(new BorderLayout());
        JLabel openDoorLabel = new JLabel("<html><center>**Bridge is OPEN!**" +
                "<br><br>You may now pass the bridge.</center></html>");
        openDoorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        openDoorLabel.setVerticalAlignment(SwingConstants.CENTER);
        openDoorLabel.setForeground(Color.blue);
        openDoorLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        myOpenDoorPanel.add(openDoorLabel, BorderLayout.CENTER);
    }

    /**
     * Configures closed door message panel
     */
    private void configureClosedDoorPanel(){
        myClosedDoorPanel.setLayout(new BorderLayout());
        JLabel closedDoorLabel = new JLabel("<html><center>**Path is CLOSED** " +
                "<br><br>You are surrounded by Crocodiles!</br>" +
                "<br><br>Find a new path.</center></html>");
        closedDoorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        closedDoorLabel.setVerticalAlignment(SwingConstants.CENTER);
        closedDoorLabel.setForeground(Color.blue);
        closedDoorLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        myClosedDoorPanel.add(closedDoorLabel, BorderLayout.CENTER);
    }

    /**
     * Configures welcome message panel
     */
    private void configureWelcomePanel(){
        myWelcomePanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("<html><center>Let's Go Hunting!!" +
                "<br><br>Click the wall in the current room to select" +
                " your direction.</center></html>");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.blue);
        welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        myWelcomePanel.add(welcomeLabel, BorderLayout.CENTER);
    }


    /**
     * Configures panel container containing all panels using Card Layout
     */
    private void configurePanelContainer(){
        myPanelContainer.setLayout(myCardLayout);
        myPanelContainer.add(myWelcomePanel,"WELCOME");
        myPanelContainer.add(myTriviaDisplayPanel,"TRIVIA");
        myPanelContainer.add(myOpenDoorPanel, "OPEN_DOOR");
        myPanelContainer.add(myClosedDoorPanel, "CLOSED_DOOR");
    }

    /**
     * Displays specified panel
     * @param thePanel the panel to be displayed
     */
    protected static void showPanel(String thePanel){
        myCardLayout.show(myPanelContainer,thePanel);
    }

    /**
     * Method to update to the next question
     */
    protected static void nextTrivia(){}

}









