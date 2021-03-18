package InheritanceIntro;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Crab extends SeaCreature {

	Rectangle2D.Double base;
	Rectangle2D.Double leftPincher;
	Rectangle2D.Double rightPincher;

	public static final double BASE_SIZE = 50;
	public static final double PINCHER_SIZE = 15;
	public static final double MOVEMENT_PER_SWIM = 1;

	private Color color;

	/**
	 * Creates a new Crab with the given x, y position and color
	 * 
	 * @param x
	 * @param y
	 * @param color
	 */
	public Crab(double x, double y, Color color) {
		/*
		 * Super means "the class that this class extends". In this case, that's sea
		 * creature! So super(something) calls the constructor in the object you extend.
		 * Here's, that's sea creature's constructor
		 */
		super(x, y);
		placeCrab(x, y);
		this.color = color;
	}

	/**
	 * Places the crab's visual components where they belong
	 * 
	 * @param x
	 * @param y
	 */
	public void placeCrab(double x, double y) {
		this.x = x;
		this.y = y;
		base = new Rectangle2D.Double(x, y, BASE_SIZE, BASE_SIZE);
		leftPincher = new Rectangle2D.Double(x - PINCHER_SIZE, y - PINCHER_SIZE, PINCHER_SIZE, PINCHER_SIZE);
		rightPincher = new Rectangle2D.Double(x + BASE_SIZE, y - PINCHER_SIZE, PINCHER_SIZE, PINCHER_SIZE);
	}

	/**
	 * Draws this crab to the screen.
	 */
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fill(base);
		g.fill(leftPincher);
		g.fill(rightPincher);

		g.setColor(Color.black);
		g.draw(base);
		g.draw(leftPincher);
		g.draw(rightPincher);
	}

	/**
	 * Wiggles the crab around. Crabs only wiggle left and right because they can't
	 * actually swim
	 */
	@Override
	public void swim() {
		double move = Math.random() * MOVEMENT_PER_SWIM * 2 - MOVEMENT_PER_SWIM;
		placeCrab(this.x + move, this.y);
	}

}
