package view;


import io.Database;
import io.Trivia;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class TriviaPanel extends JPanel implements ActionListener {

    private Trivia myTrivia;
    private String MY_QUESTION;
    private String MY_ANSWER;
    private String[] MY_OPTIONS;
    private final JTextPane questionPane;
    private final ButtonGroup multipleQuestionGroup, trueFalseQuestionGroup;
    private final JRadioButton optionA, optionB, optionC, optionD, trueOption, falseOption;
    private final JButton submitButton;
   

    public TriviaPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        questionPane = new JTextPane();
        multipleQuestionGroup = new ButtonGroup();
        optionA = new JRadioButton();
        optionB = new JRadioButton();
        optionC = new JRadioButton();
        optionD = new JRadioButton();
        trueFalseQuestionGroup = new ButtonGroup();
        trueOption = new JRadioButton();
        falseOption = new JRadioButton();
        submitButton = new JButton("Submit");
        getNextTrivia();


    }
    public void getNextTrivia(){
        myTrivia = Database.getQuestionList().get(0);
        MY_QUESTION = myTrivia.getQuestion();
        MY_ANSWER = myTrivia.getAnswer();
        MY_OPTIONS = myTrivia.getOptions();
        this.add(questionPane);
        displayQuestion();
        displayOptions();
        submitButton.addActionListener(this);
        this.add(submitButton);
    }
    private void displayQuestion() {
        questionPane.setText(MY_QUESTION);
        //questionPane.setBounds(70,30,230,75);
        questionPane.setEditable(false);
        StyledDocument doc = questionPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        //Resource: //https://pretagteam.com/question/centering-text-in-a-jtextarea-or-jtextpane-horizontal-text-alignment
    }
    private void displayOptions(){

        switch (myTrivia.getType()) {
            case "MULTIPLE_CHOICE" -> {
                optionA.setText(MY_OPTIONS[0]);
                optionB.setText(MY_OPTIONS[1]);
                optionC.setText(MY_OPTIONS[2]);
                optionD.setText(MY_OPTIONS[3]);
                optionA.setActionCommand("A");
                optionB.setActionCommand("B");
                optionC.setActionCommand("C");
                optionD.setActionCommand("D");
                multipleQuestionGroup.add(optionA);
                multipleQuestionGroup.add(optionB);
                multipleQuestionGroup.add(optionC);
                multipleQuestionGroup.add(optionD);
                this.add(optionA);
                this.add(optionB);
                this.add(optionC);
                this.add(optionD);
            }
            case "TRUE_FALSE" -> {
                trueOption.setText(MY_OPTIONS[0]);
                falseOption.setText(MY_OPTIONS[1]);
                trueOption.setActionCommand(MY_OPTIONS[0]);
                falseOption.setActionCommand(MY_OPTIONS[1]);
                trueFalseQuestionGroup.add(trueOption);
                trueFalseQuestionGroup.add(falseOption);
                this.add(trueOption);
                this.add(falseOption);
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submitButton) {
            String currentSelection = null;
        try {
            switch (myTrivia.getType()) {
                case "MULTIPLE_CHOICE" -> currentSelection = multipleQuestionGroup.getSelection().getActionCommand();
                case "TRUE_FALSE" -> currentSelection = trueFalseQuestionGroup.getSelection().getActionCommand();
            }
            if(Objects.equals(currentSelection, MY_ANSWER)){
                JOptionPane.showMessageDialog(this, "CORRECT!");
            } else{
                JOptionPane.showMessageDialog(this, "INCORRECT!");
            }

        } catch (NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Select one of the following!");
        }

        }

    }
}

