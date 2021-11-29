package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SubmitDisplayPanel extends JPanel{

    protected final JButton submitButton = new JButton();


    protected SubmitDisplayPanel(){
        this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(100,50));
        configureSubmitButton();
        this.add(submitButton);

    }

    private void configureSubmitButton(){
        submitButton.setText("Submit");
        submitButton.addActionListener(e -> {
            TriviaPanel myTriviaPanel = new TriviaPanel();
            String currentSelection = null;
            try {
                switch (TriviaPanel.myTrivia.getType()) {
                    case "MULTIPLE_CHOICE" -> currentSelection = OptionDisplayPanel.multipleQuestionGroup.getSelection().getActionCommand();
                    case "TRUE_FALSE" -> currentSelection = OptionDisplayPanel.trueFalseQuestionGroup.getSelection().getActionCommand();
                }
                if(Objects.equals(currentSelection, TriviaPanel.MY_ANSWER)){
                    JOptionPane.showMessageDialog( myTriviaPanel,"CORRECT!");
                } else{
                    JOptionPane.showMessageDialog(myTriviaPanel, "INCORRECT!");
                }
            } catch (NullPointerException ex){
                JOptionPane.showMessageDialog(myTriviaPanel, "Select one of the following!");
            }

        });
    }

}
