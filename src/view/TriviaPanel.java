package view;


import io.Database;
import io.Trivia;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TriviaPanel extends JPanel implements ActionListener {

    private Trivia myTrivia;
    private String MY_QUESTION;
    private String MY_ANSWER;
    private String[] MY_OPTIONS;


    private final JTextPane questionPane;
    private final JRadioButton optionButtonA;
    private final JRadioButton optionButtonB;
    private final JRadioButton optionButtonC;
    private final JRadioButton optionButtonD;
    private ButtonGroup buttonGroup;

    
    public TriviaPanel(){
        this.setLayout(null);
        this.setBackground(Color.white);

        questionPane = new JTextPane();
        optionButtonA = new JRadioButton();
        optionButtonB = new JRadioButton();
        optionButtonC = new JRadioButton();
        optionButtonD = new JRadioButton();

        getNextTrivia();

        this.add(questionPane);


    }

    public void getNextTrivia(){
        myTrivia = Database.getQuestionList().get(0);
        MY_QUESTION = myTrivia.getQuestion();
        MY_ANSWER = myTrivia.getAnswer();
        MY_OPTIONS = myTrivia.getOptions();
        displayQuestion();
    }

    /**
     * Displays question
     */
    private void displayQuestion() {
        questionPane.setText(MY_QUESTION);
        questionPane.setBounds(70,30,230,75);
        questionPane.setEditable(false);
        StyledDocument doc = questionPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        //Resource: //https://pretagteam.com/question/centering-text-in-a-jtextarea-or-jtextpane-horizontal-text-alignment
    }

    private void displayOptions(){

        switch(myTrivia.getType()){
            case "MULTIPLE_CHOICE":
                buttonGroup = new ButtonGroup();
                optionButtonA.setText(MY_OPTIONS[0]);
                optionButtonB.setText(MY_OPTIONS[1]);
                optionButtonC.setText(MY_OPTIONS[2]);
                optionButtonD.setText(MY_OPTIONS[3]);
                buttonGroup.add(optionButtonA);
                buttonGroup.add(optionButtonB);
                buttonGroup.add(optionButtonC);
                buttonGroup.add(optionButtonD);
                this.add(optionButtonA);
                this.add(optionButtonB);
                this.add(optionButtonC);
                this.add(optionButtonD);
                break;
            case "TRUE_FALSE":
                buttonGroup = new ButtonGroup();
                optionButtonA.setText("True");
                optionButtonB.setText("False");
                buttonGroup.add(optionButtonA);
                buttonGroup.add(optionButtonB);
                this.add(optionButtonA);
                this.add(optionButtonB);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
