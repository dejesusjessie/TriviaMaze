package view;

import model.GameRunner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import static view.OptionDisplayPanel.*;
import static view.RoomPanel.myPlayerDirection;
import static view.TriviaPanel.*;

/**
 * Submit Display Panel displays the submit and hint button
 * Author: Jessie De Jesus
 */


public class SubmitDisplayPanel extends JPanel implements ActionListener {

    private final JButton submitButton = new JButton();
    private final JButton hintButton = new JButton();

    // JOption image
    private static ImageIcon huskyCryImg = new ImageIcon("src/image/huskyCry.gif");

    /**
     * Constructs the Submit Display Panel to display in
     * the south position within the trivia panel
     */
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



//    private Boolean canTryE() {
//        Boolean result = true;
//        result = GameRunner.INSTANCE.EIsLock();
//        return result;
//    }
//
//    private Boolean canTryW() {
//        Boolean result = true;
//        result = GameRunner.INSTANCE.WIsLock();
//        return result;
//    }
//
//    private Boolean canTryN() {
//        Boolean result = true;
//        result = GameRunner.INSTANCE.NIsLock();
//        return result;
//    }
//
//    private Boolean canTryS() {
//        Boolean result = true;
//        result = GameRunner.INSTANCE.SIsLock();
//        return result;
//    }
//
//    private boolean NIsWall() {
//        boolean result = false;
//        result = GameRunner.INSTANCE.getCurrentRoom().getNIsWall();
//        return result;
//    }
//
//    private boolean SIsWall() {
//        boolean result = false;
//        result = GameRunner.INSTANCE.getCurrentRoom().getSIsWall();
//        return result;
//    }
//
//    private boolean WIsWall() {
//        boolean result = false;
//        result = GameRunner.INSTANCE.getCurrentRoom().getWIsWall();
//        return result;
//    }
//
//    private boolean EIsWall() {
//        boolean result = false;
//        result = GameRunner.INSTANCE.getCurrentRoom().getEIsWall();
//        return result;
//    }
//
//    private void blockerSays() {
//        JOptionPane.showMessageDialog(null, "You are going to be eaten!! Muhahaha");
//    }
//
//    private void wallSays() {
//        JOptionPane.showMessageDialog(null, "You are hitting the wall!!");
//    }
//
//    private void lostGameText() throws IOException {
//
//        Object[] options = {"Restart", "Exit"};
//        int response = JOptionPane.showOptionDialog(null,
//                "You lose!! Let's try it again!!",
//                "Husky Lose",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                huskyCryImg,
//                options,  //the titles of buttons
//                options[0]); //default button title
//        if (response == JOptionPane.YES_OPTION) {
//            IniMaze.getInstance();
//            GameRunner.INSTANCE.setNewGame();
//            ;
//        }
//        if (response == JOptionPane.NO_OPTION) {
//            System.exit(0);
//        }
//
//        //JOptionPane.showMessageDialog(null, "You are lost!! Exit and restart to try again!");
//    }
//
//    private boolean isLost() {
//        boolean s = !GameRunner.INSTANCE.canTraverse() || (!canTryS() || SIsWall());
//        boolean w = !GameRunner.INSTANCE.canTraverse() || (!canTryW() || WIsWall());
//        boolean n = !GameRunner.INSTANCE.canTraverse() || (!canTryN() || NIsWall());
//        boolean e = !GameRunner.INSTANCE.canTraverse() || (!canTryE() || EIsWall());
//        return s && w && n && e;
//    }
//
//    private boolean hasBridgeN() {
//        boolean result = false;
//        result = GameRunner.INSTANCE.getCurrentRoom().getMyNorthDoor().isOpen();
//        return result;
//    }
//
//    private boolean hasBridgeS() {
//        boolean result = false;
//        result = GameRunner.INSTANCE.getCurrentRoom().getMySouthDoor().isOpen();
//        return result;
//    }
//
//    private boolean hasBridgeE() {
//        boolean result = false;
//        result = GameRunner.INSTANCE.getCurrentRoom().getMyEastDoor().isOpen();
//        return result;
//    }
//
//    private boolean hasBridgeW() {
//        boolean result = false;
//        result = GameRunner.INSTANCE.getCurrentRoom().getMyWestDoor().isOpen();
//        return result;
//    }
//
//    public void showDoorClosedPanel(){
//        TriviaPanel.showPanel("CLOSED_DOOR");
//    }
//
//    public void showDoorOpenPanel(){
//        TriviaPanel.showPanel("OPEN_DOOR");
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent theEvent) {
//        String direction = myPlayerDirection;
//        boolean isCorrect = false;
//
//
//        if (theEvent.getSource() == submitButton) {
//
//            String currentSelection = null;
//            try {
//                switch (myTrivia.getType()) {
//                    case "MULTIPLE_CHOICE" -> currentSelection = multipleQuestionGroup.getSelection().getActionCommand();
//                    case "TRUE_FALSE" -> currentSelection = trueFalseQuestionGroup.getSelection().getActionCommand();
//                }
//                System.out.println("The answer: " + MY_ANSWER);
//                System.out.println("The user input: " + currentSelection);
//
//                if (Objects.equals(currentSelection, MY_ANSWER)) {
//                    JOptionPane.showMessageDialog(null, "CORRECT!");
//                    isCorrect = true;
//                } else {
//                    JOptionPane.showMessageDialog(null, "INCORRECT!");
//                    isCorrect = false;
//                }
//            } catch (NullPointerException ex) {
//                JOptionPane.showMessageDialog(null, "Select one of the following!");
//            }
//
//            switch (direction) {
//                case "NORTH" -> {
//                    if (canTryN() && !NIsWall() && !hasBridgeN()) {
//                        if (isCorrect) {
//                            GameRunner.INSTANCE.openN();
//                            GameRunner.INSTANCE.moveN();
//                            showDoorOpenPanel();
//                        } else {
//                            GameRunner.INSTANCE.lockN();
//                            showDoorClosedPanel();
//                        }
//
//                    } else if (NIsWall()) {
//                        wallSays();
//                    } else if (hasBridgeN()) {
//                        GameRunner.INSTANCE.moveN();
//                    } else {
//                        blockerSays();
//                    }
//                    try {
//                        if (isLost()) {
//                            lostGameText();
//                        }
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//
//                }
//
//                case "SOUTH" -> {
//                    if (canTryS() && !SIsWall() && !hasBridgeS()) {
//                        if (isCorrect) {
//                            GameRunner.INSTANCE.openS();
//                            GameRunner.INSTANCE.moveS();
//                            showDoorOpenPanel();
//                        } else {
//                            GameRunner.INSTANCE.lockS();
//                            showDoorClosedPanel();
//                        }
//                    } else if (SIsWall()) {
//                        wallSays();
//                    } else if (hasBridgeS()) {
//                        GameRunner.INSTANCE.moveS();
//                    } else {
//                        blockerSays();
//                    }
//                    try {
//                        if (isLost()) {
//                            lostGameText();
//                        }
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//
//
//
//                }
//
//                case "EAST" -> {
//                    if (canTryE() && !EIsWall() && !hasBridgeE()) {
//                        if (isCorrect) {
//                            GameRunner.INSTANCE.openE();
//                            GameRunner.INSTANCE.moveE();
//                            showDoorOpenPanel();
//                        } else {
//                            GameRunner.INSTANCE.lockE();
//                            showDoorClosedPanel();
//                        }
//                    } else if (EIsWall()) {
//                        wallSays();
//                    } else if (hasBridgeE()) {
//                        GameRunner.INSTANCE.moveE();
//                    } else {
//                        blockerSays();
//                    }
//                    try {
//                        if (isLost()) {
//                            lostGameText();
//                        }
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//                    TriviaPanel.nextTrivia();
//                }
//
//                case "WEST" -> {
//                    if (canTryW() && !WIsWall() && !hasBridgeW()) {
//                        if (isCorrect) {
//                            GameRunner.INSTANCE.openW();
//                            GameRunner.INSTANCE.moveW();
//                            showDoorOpenPanel();
//                        } else {
//                            GameRunner.INSTANCE.lockW();
//                            showDoorClosedPanel();
//                        }
//                    } else if (WIsWall()) {
//                        wallSays();
//                    } else if (hasBridgeW()) {
//                        GameRunner.INSTANCE.moveW();
//                    } else {
//                        blockerSays();
//                    }
//                    try {
//                        if (isLost()) {
//                            lostGameText();
//                        }
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//
//                }
//
//            }
//
//
//        }
//    }

    /**
     * Performed action of selected button even
     * @param theEvent the button event
     */
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