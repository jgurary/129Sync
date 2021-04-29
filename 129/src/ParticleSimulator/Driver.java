package ParticleSimulator;

import java.awt.Color;

import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		Display panel = new Display(800, 800, Color.white);
		JFrame frame = new JFrame("Particle Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

		SimulationManager simulation = new SimulationManager(50, panel);
		panel.simulation = simulation;
		panel.registerDrawables();
	}
}
