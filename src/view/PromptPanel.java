package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Prompt Panel  GUI for the game.
 * @author Kannika Armstrong
 * @version Fall 2021
 */

public class PromptPanel implements ActionListener {

    private JFrame promptFrame = new JFrame();
    private JButton loginBtn = new JButton("Start Game");

    PromptPanel(){

        loginBtn.setBounds(100,160,200,40);
        loginBtn.setFocusable(false);
        loginBtn.setFont(new Font("Serif", Font.PLAIN, 24));
        loginBtn.addActionListener(this);


        promptFrame.add(loginBtn);

        promptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        promptFrame.setSize(400,400);
        promptFrame.setLayout(null);
        promptFrame.setLocationRelativeTo(null);
        promptFrame.setVisible(true);
        promptFrame.setResizable(false);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            promptFrame.dispose();
            TriviaMazeGUI triviaMazeGUI = new TriviaMazeGUI();
        }

    }
}
