package view;

import javax.swing.*;
import java.awt.*;

/**
 * This panel displays the available option for the trivia in JRadio format
 * Author: Jessie De Jesus
 */

public class OptionDisplayPanel extends JPanel {

    protected static final ButtonGroup multipleQuestionGroup = new ButtonGroup();
    protected static final ButtonGroup trueFalseQuestionGroup = new ButtonGroup();
    private final JRadioButton optionA = new JRadioButton();
    private final JRadioButton optionB = new JRadioButton();
    private final JRadioButton optionC = new JRadioButton();
    private final JRadioButton optionD = new JRadioButton();
    private final JRadioButton trueOption = new JRadioButton();
    private final JRadioButton falseOption = new JRadioButton();
    private final GridBagConstraints gbc = new GridBagConstraints();

    /**
     * Constructs the Option Display Panel to display in the
     * center position within the trivia panel
     */
    protected OptionDisplayPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(100,75));
        displayOptions();
    }

    /**
     * Determines which option to display based on trivia type
     */
    private void displayOptions(){
        switch (TriviaPanel.myTrivia.getType()) {
            case "MULTIPLE_CHOICE" -> { displayMultipleChoiceOptions();}
            case "TRUE_FALSE" -> {displayTrueFalseOptions();}
        }
    }

    /**
     * Displays multiple choice options
     */
    private void displayMultipleChoiceOptions(){
        gbc.anchor = GridBagConstraints.NORTHWEST;
        optionA.setText(TriviaPanel.MY_OPTIONS[0]);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(optionA,gbc);
        optionB.setText(TriviaPanel.MY_OPTIONS[1]);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(optionB,gbc);
        optionC.setText(TriviaPanel.MY_OPTIONS[2]);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(optionC,gbc);
        optionD.setText(TriviaPanel.MY_OPTIONS[3]);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(optionD,gbc);
        optionA.setActionCommand("D");
        optionB.setActionCommand("C");
        optionC.setActionCommand("B");
        optionD.setActionCommand("A");

        multipleQuestionGroup.add(optionA);
        multipleQuestionGroup.add(optionB);
        multipleQuestionGroup.add(optionC);
        multipleQuestionGroup.add(optionD);
    }

    /**
     * Displays true/false options
     */
    private void displayTrueFalseOptions(){
        gbc.anchor = GridBagConstraints.WEST;
        trueOption.setText(TriviaPanel.MY_OPTIONS[0]);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(trueOption,gbc);
        falseOption.setText(TriviaPanel.MY_OPTIONS[1]);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(falseOption,gbc);
        trueOption.setActionCommand(TriviaPanel.MY_OPTIONS[0]);
        falseOption.setActionCommand(TriviaPanel.MY_OPTIONS[1]);
        trueFalseQuestionGroup.add(trueOption);
        trueFalseQuestionGroup.add(falseOption);
    }

}
