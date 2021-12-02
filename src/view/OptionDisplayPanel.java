package view;

import io.Trivia;

import javax.swing.*;
import java.awt.*;

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


    protected OptionDisplayPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(100,75));
        displayOptions();
    }

    private void displayOptions(){
        switch (TriviaPanel.myTrivia.getType()) {
            case "MULTIPLE_CHOICE" -> { getMultipleChoiceOptions();}
            case "TRUE_FALSE" -> {getTrueFalseOptions();}
        }
    }
    private void getMultipleChoiceOptions(){
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
//        optionA.setActionCommand("A");
//        optionB.setActionCommand("B");
//        optionC.setActionCommand("C");
//        optionD.setActionCommand("D");
        
        
        
        multipleQuestionGroup.add(optionA);
        multipleQuestionGroup.add(optionB);
        multipleQuestionGroup.add(optionC);
        multipleQuestionGroup.add(optionD);
    }

    private void getTrueFalseOptions(){
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
