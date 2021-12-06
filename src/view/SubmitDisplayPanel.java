package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static view.OptionDisplayPanel.*;
import static view.TriviaPanel.*;

public class SubmitDisplayPanel extends JPanel implements ActionListener {

    private final JButton submitButton = new JButton();
    private final JButton hintButton = new JButton();



    protected SubmitDisplayPanel(){
        this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(100,50));
        submitButton.setText("Submit");
        hintButton.setText("Hint");
        submitButton.addActionListener(this);
        hintButton.addActionListener(this);
        this.add(submitButton);
        this.add(hintButton);

    }


    @Override
    public void actionPerformed(ActionEvent theEvent) {

        if(theEvent.getSource() == submitButton) {

            String currentSelection = null;
            try {
                switch (myTrivia.getType()) {
                    case "MULTIPLE_CHOICE" -> currentSelection = multipleQuestionGroup.getSelection().getActionCommand();
                    case "TRUE_FALSE" -> currentSelection = trueFalseQuestionGroup.getSelection().getActionCommand();
                }
                if(Objects.equals(currentSelection, MY_ANSWER)){
                    JOptionPane.showMessageDialog(null, "CORRECT!");
                } else{
                    JOptionPane.showMessageDialog(null, "INCORRECT!");
                }
            } catch (NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Select one of the following!");
            }

        }
    }
}

