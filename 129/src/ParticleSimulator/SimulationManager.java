package ParticleSimulator;

import java.util.ArrayList;

import javax.swing.JPanel;

public class SimulationManager {

	ArrayList<Particle> particles = new ArrayList<Particle>();
	JPanel displayPanel;
	boolean gravityOn = true;
	double gravity = .3;
	double wind = 0;

	/**
	 * Starts a simulation with the given number of particles. <br>
	 * <br>
	 * Make sure the panel is instantiated and the width and height are accessible
	 * 
	 * @param numParticles
	 */
	public SimulationManager(int numParticles, JPanel displayPanel) {
		this.displayPanel = displayPanel;
		for (int i = 0; i < numParticles; i++) {
			particles.add(new Particle(Math.random() * (displayPanel.getWidth() - Particle.STARTING_SIZE),
					Math.random() * (displayPanel.getHeight() - Particle.STARTING_SIZE), displayPanel.getWidth(),
					displayPanel.getHeight()));
		}
	}

	/**
	 * Advances the simulation by one frame
	 */
	public void tick() {
		for (Particle p : particles) {
			// add gravity and wind
			if (gravityOn) {
				p.accelerate(wind, gravity);
			} else {
				p.accelerate(wind, 0);
			}
			// check all collisions
			for (Particle other : particles) {
				if (other != p && p.collide(other)) {
					p.fuse(other);
					p.updateMaxValues(displayPanel.getWidth(), displayPanel.getHeight());

				}
			}
			// update positions
			p.move();
		}
	}

	/**
	 * Adds the given value to the wind's strength
	 * 
	 * @param delta
	 */
	public void changeWind(double delta) {
		wind += delta;
		System.out.println("The wind is blowing: " + wind);
	}

	public void toggleGravity() {
		gravityOn = !gravityOn;
	}

}
