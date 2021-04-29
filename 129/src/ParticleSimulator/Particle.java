package ParticleSimulator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Particle implements Drawable {

	Ellipse2D.Double display;
	double x, y;
	double velocityX, velocityY;
	Color color;
	double maxX, maxY;
	boolean fused = false;

	final static double DAMPENING_FACTOR = .95;
	final static double STARTING_SPEED_MAX = 2;
	final static double STARTING_SIZE = 20;

	/**
	 * Creates a new particle at the given x and y position with random starting
	 * speed and a size of {@link #STARTING_SIZE}
	 * 
	 * @param x
	 * @param y
	 */
	public Particle(double x, double y, double maxX, double maxY) {
		this.x = x;
		this.y = y;
		velocityX = Math.random() * STARTING_SPEED_MAX * 2 - STARTING_SPEED_MAX;
		velocityY = Math.random() * STARTING_SPEED_MAX * 2 - STARTING_SPEED_MAX;
		display = new Ellipse2D.Double(x, y, STARTING_SIZE, STARTING_SIZE);
		color = new Color((int) (Math.random() * 0xFFFFFF));

		updateMaxValues(maxX, maxY);
	}

	/**
	 * Updates the position of the particle relative to its velocity:
	 * {@link #velocityX} {@link #velocityY}
	 */
	public void move() {
		if (x < 0 && velocityX < 0 || x > maxX && velocityX > 0) {
			velocityX = -velocityX * DAMPENING_FACTOR;
		}

		if (y < 0 && velocityY < 0 || y > maxY && velocityY > 0) {
			velocityY = -velocityY * DAMPENING_FACTOR;
		}
		x += velocityX;
		y += velocityY;
		updateDisplay();
	}

	/**
	 * Updates the bottom and right boundaries that the particle has to stay inside
	 * Note that the left and top boundary is always 0
	 * 
	 * @param maxX
	 * @param maxY
	 */
	public void updateMaxValues(double maxX, double maxY) {
		// Subtract the particle's size so they don't clip offscreen
		this.maxX = maxX - display.width;
		this.maxY = maxY - display.height;
	}

	public void accelerate(double aX, double aY) {
		velocityX += aX;
		velocityY += aY;
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fill(display);
		g.setColor(Color.black);
		g.draw(display);
	}

	public void updateDisplay() {
		display.x = x;
		display.y = y;
	}

	/**
	 * Returns true if this particle is touching the other one. Note that this is
	 * true if the distance between two particles is less than the sum of their
	 * radiuses
	 * 
	 * @param other
	 * @return
	 */
	public boolean collide(Particle other) {
		Ellipse2D.Double ellipseOther = other.display;
		double x1 = ellipseOther.getCenterX();
		double x2 = display.getCenterX();
		double y1 = ellipseOther.getCenterY();
		double y2 = display.getCenterY();
		double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		if (distance < display.width / 2 + other.display.width / 2) {
			return true;
		}

		return false;
	}

	public void fuse(Particle other) {
		// Particles that have fused once can't fuse again
		if (fused) {
			return;
		}
		display.width += other.display.width / 2;
		display.height += other.display.height / 2;
		color = new Color((int) (Math.random() * 0xFFFFFF));
		fused = true;

		other.display.width = other.display.width / 2;
		other.display.height = other.display.height / 2;
		other.color = new Color((int) (Math.random() * 0xFFFFFF));
		other.fused = true;

	}

}
