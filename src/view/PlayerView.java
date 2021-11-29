package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class PlayerView extends JComponent {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    String myDir = System.getProperty("user.dir");

    BufferedImage myHusky = ImageIO.read(new File(myDir + "/src/image/husky.png"));

    public PlayerView()throws IOException{

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(new Color(255,255,255));
        int wallSize = 150;
        int x = 250;
        int y = 250;

        g2d.drawImage(myHusky, x-30,y+30,wallSize/2,wallSize/2, null);
    }



}