package view;

import io.Load;
import model.GameRunner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A Prompt Panel  GUI for the game.
 * @author Kannika Armstrong
 * @version Fall 2021
 */

public class PromptPanel extends JPanel implements ActionListener {

    private JFrame promptFrame = new JFrame("Husky Trivia Maze Game");
    private JButton loginBtn = new JButton("Start Game");
    private JButton loadBtn = new JButton("Load Game");
    private JButton exitBtn = new JButton("Exit Game");
    private JPanel promptHeader = new JPanel();
    private JLabel promptHeaderLabel = new JLabel("HUSKY   TRIVIA   MAZE   GAME");
    private JPanel graphicPanel = new JPanel();
    private JPanel btnPanel = new JPanel();

    private ImageIcon graphicImage = new ImageIcon(getClass().getResource( "/image/promptAni.jpg"));

    Font cartoonFont;

    private final JFileChooser myFileChooser = new JFileChooser(System.getProperty("user.dir") + "/savedGame");
    private final FileNameExtensionFilter myFileNameFilter = new FileNameExtensionFilter("Binary Files", "bin");

    public PromptPanel(){

        promptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        promptFrame.setSize(800,600);
        promptFrame.setLayout(null);
        promptFrame.setLocationRelativeTo(null);

        frameDisplay();

        promptFrame.setVisible(true);
        promptFrame.setResizable(false);

    }

    private void frameDisplay() {
        promptFrame.setLayout(new BorderLayout());
        promptFrame.add(promptHeader, BorderLayout.NORTH);
        promptFrame.add(graphicPanel,BorderLayout.CENTER);
        promptFrame.add(btnPanel, BorderLayout.SOUTH);

        //promptHeader.setBackground(Color.WHITE);
        promptHeader.setBackground(new Color(255,222,173));
        graphicPanel.setBackground(Color.WHITE);
        //btnPanel.setBackground(Color.WHITE);
        btnPanel.setBackground(new Color(255,222,173));
        btnPanel.setLayout(new GridLayout(1,3));

        promptHeader.setPreferredSize(new Dimension(100, 80));
        btnPanel.setPreferredSize(new Dimension(100,80));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        headerPanel();
        graphicPanel();


        btnPanel.add(loginBtn);
        btnPanel.add(loadBtn);
        btnPanel.add(exitBtn);
        loginBtn.setPreferredSize(new Dimension(100,20));
        loadBtn.setPreferredSize(new Dimension(100,20));
        exitBtn.setPreferredSize(new Dimension(100,20));
        //loginBtn.setBounds(20,20,200,40);
        loginBtn.setFocusable(false);
        loadBtn.setFocusable(false);
        exitBtn.setFocusable(false);
        loginBtn.setFont(new Font("Serif", Font.PLAIN, 24));
        loadBtn.setFont(new Font("Serif", Font.PLAIN, 24));
        exitBtn.setFont(new Font("Serif", Font.PLAIN, 24));

        loginBtn.addActionListener(this);
        loadGame();

    }

    private void loadGame() {
        //Set only allow to load .bin file
        myFileChooser.addChoosableFileFilter(myFileNameFilter);
        myFileChooser.setAcceptAllFileFilterUsed(false);

        loadBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                promptFrame.dispose();

                final int selection = myFileChooser.showOpenDialog(null);
                if(selection == JFileChooser.APPROVE_OPTION) {
                    try {
                        String fileName = myFileChooser.getSelectedFile().getName();
                        new Load(fileName);
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null,
                                "The selected file did not contain an game record!",
                                "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private void graphicPanel() {
        JLabel graphicLabel = new JLabel();
        Image grpImg = graphicImage.getImage().getScaledInstance
                (promptFrame.getWidth(), promptFrame.getHeight()*2/3, Image.SCALE_SMOOTH);
        graphicLabel.setIcon(new ImageIcon(grpImg));
        //graphicPanel.setBorder(new EmptyBorder(15,15,15,15));
        graphicPanel.add(graphicLabel);
    }

    private void headerPanel() {
        try {
            cartoonFont = Font.createFont(Font.TRUETYPE_FONT,
                    new File("src/Font/Naughty Cartoons.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                    new File("src/Font/Naughty Cartoons.ttf")));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        promptHeader.add(promptHeaderLabel);
        promptHeaderLabel.setFont(cartoonFont);
        promptHeader.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            promptFrame.dispose();

            IniMaze myIniMaze = null;
            try {
                myIniMaze = IniMaze.getInstance();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            GameRunner myGameRunner = GameRunner.INSTANCE;
            myGameRunner.setData(myIniMaze);
        }
    }
}
