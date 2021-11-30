package view;


import io.Database;
import io.Trivia;
import javax.swing.*;
import java.awt.*;


public class TriviaPanel extends JPanel {

    protected static final Trivia myTrivia = Database.getQuestionList().get(0);
    protected static final String MY_QUESTION = myTrivia.getQuestion();
    protected static final String MY_ANSWER = myTrivia.getAnswer();
    protected static final String[] MY_OPTIONS = myTrivia.getOptions();

    private final JPanel myTriviaDisplayPanel;

//    private final QuestionDisplayPanel myQuestionDisplayPanel;
//    private final OptionDisplayPanel myOptionDisplayPanel;
//    private final SubmitDisplayPanel mySubmitDisplayPanel;

    private static ImageIcon blueNorthWallImg = new ImageIcon("src/image/blueWallNorth.png");
    private static ImageIcon blueSouthWallImg = new ImageIcon("src/image/blueWallSouth.png");
    private static ImageIcon blueEastWallImg = new ImageIcon("src/image/blueWallEast.png");
    private static ImageIcon blueWestWallImg = new ImageIcon("src/image/blueWallWest.png");

    private static JLabel myNorthWall = new JLabel(blueNorthWallImg);
    private static JLabel mySouthWall = new JLabel(blueSouthWallImg);
    private static JLabel myEastWall = new JLabel(blueEastWallImg);
    private static JLabel myWestWall = new JLabel(blueWestWallImg);





    public TriviaPanel(){
        this.setLayout(new BorderLayout());
        this.add(myNorthWall,BorderLayout.NORTH);
        this.add(mySouthWall,BorderLayout.SOUTH);
        this.add(myEastWall,BorderLayout.EAST);
        this.add(myWestWall,BorderLayout.WEST);

        //setTriviaDisplayPanel
        myTriviaDisplayPanel = new JPanel();
        myTriviaDisplayPanel.setBackground(Color.WHITE);
        myTriviaDisplayPanel.setLayout(new BorderLayout());
        myTriviaDisplayPanel.setPreferredSize(new Dimension(100,25));
        this.add(myTriviaDisplayPanel, BorderLayout.CENTER);

//        myQuestionDisplayPanel = new QuestionDisplayPanel();
//        myTriviaDisplayPanel.add(myQuestionDisplayPanel, BorderLayout.CENTER);
//
//        myOptionDisplayPanel = new OptionDisplayPanel();
//        mySubmitDisplayPanel = new SubmitDisplayPanel();
//        myTriviaDisplayPanel.add(mySubmitDisplayPanel);
//
//        myTriviaDisplayPanel.add(myQuestionDisplayPanel,BorderLayout.NORTH);
//        myTriviaDisplayPanel.add(myOptionDisplayPanel,BorderLayout.CENTER);
//        myTriviaDisplayPanel.add(mySubmitDisplayPanel, BorderLayout.SOUTH);

    }

    private void setBorders(){}
    private void setTriviaDisplayPanel(){}


}
