package application;

import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

import view.MazeGraphic;
import view.TriviaMazeGUI;

public class TriviaMaze {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		TriviaMazeGUI game = new TriviaMazeGUI();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					game.basicWindow();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		System.out.println("try");
		Scanner input = new Scanner(System.in);
		String i = input.nextLine();
		if(i == "e") {

		}

		
//		JFrame test = new JFrame();
//		MazeGraphic mg = new MazeGraphic(200,200);
//		test.setSize(1280,1960);
//		test.add(mg);
//		test.setVisible(true);

		
	}

}
