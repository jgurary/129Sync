package LiskovExample;

import java.awt.Color;

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		Display display = new Display(800, 800, Color.PINK);
		JFrame frame = new JFrame("Liskov Violation Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(display);
		frame.pack();
		frame.setVisible(true);

	}

}
