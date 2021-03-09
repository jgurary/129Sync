package SwingObjectIntro;

import java.awt.Color;

import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		// Creates the panel and renders it to the screen
		Display panel = new Display(800, 800, Color.lightGray);
		JFrame frame = new JFrame("Swing Objects Intro");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
