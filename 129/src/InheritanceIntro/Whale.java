package InheritanceIntro;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Whale extends SeaCreature {

	public static final double FATNESS_TO_LENGTH_RATIO = 2;
	public static final Color baseColor = Color.white;
	public static final Color eyeColor = Color.blue;
	double fatness;
	public static final double MOVEMENT_PER_SWIM = .2;

	public Display displayPanel;

	Ellipse2D.Double base;
	Rectangle2D.Double tail;
	Ellipse2D.Double eye;

	/**
	 * Creates a whale at the given x, y position with the given fatness as its
	 * width
	 * 
	 * @param x
	 * @param y
	 * @param fatness
	 * @param d
	 */
	public Whale(double x, double y, double fatness, Display d) {
		super(x, y);
		this.fatness = fatness;
		placeWhale(x, y);
		displayPanel = d;
	}

	/**
	 * Places the whale's visual components where they belong
	 * 
	 * @param x
	 * @param y
	 */
	public void placeWhale(double x, double y) {
		this.x = x;
		this.y = y;
		base = new Ellipse2D.Double(x, y, fatness * FATNESS_TO_LENGTH_RATIO, fatness);
		tail = new Rectangle2D.Double(x + fatness * FATNESS_TO_LENGTH_RATIO, y + fatness / 2 - fatness / 6, fatness / 3,
				fatness / 3);
		eye = new Ellipse2D.Double(x + fatness / 4, y + fatness / 4, 10, 10);
	}

	/**
	 * Draws this whale to the screen.
	 */
	public void draw(Graphics2D g) {
		g.setColor(baseColor);
		g.fill(base);
		g.fill(tail);
		g.setColor(eyeColor);
		g.fill(eye);

		g.setColor(Color.black);
		g.draw(base);
		g.draw(tail);
		g.draw(eye);
	}

	@Override
	public void swim() {
		double x = this.x - MOVEMENT_PER_SWIM;
		if (tail.x + tail.width < 0) {
			x = displayPanel.getWidth();
		}

		placeWhale(x, y);
	}

}
