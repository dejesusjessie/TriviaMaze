package view;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;


/**
 * Question Display Panel displays the question
 */
public class QuestionDisplayPanel extends JPanel {


    private final JTextPane questionPane = new JTextPane();

    /**
     * Constructs the Question Display panel to display in the
     * north position within the trivia panel
     */
    protected QuestionDisplayPanel(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(100,100));
        configureQuestionTextPane();
        this.add(questionPane, BorderLayout.SOUTH);

    }

    /**
     * Configures display of Question
     */
    public void configureQuestionTextPane(){
        questionPane.setText(TriviaPanel.MY_QUESTION);
        questionPane.setBounds(70,30,200,75);
        questionPane.setEditable(false);
        StyledDocument doc = questionPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        //Resource: //https://pretagteam.com/question/centering-text-in-a-jtextarea-or-jtextpane-horizontal-text-alignment
    }


}

