package InheritanceIntro;

import java.awt.Graphics2D;

public abstract class SeaCreature {

	protected double x;
	protected double y;

	/**
	 * Creates a new sea creature at the given position
	 * 
	 * @param x
	 * @param y
	 */
	public SeaCreature(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * All sea creatures should draw themselves to the screen. This default method
	 * does nothing and prints an error!
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g) {
		System.out.println("Draw method does nothing!");
	}

	public abstract void swim();

}
