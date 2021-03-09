package SquareAdventurey;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Food {

	Ellipse2D.Double baseDisplay;
	public Color baseColor;
	public static final double LOWER_SIZE_BOUND = 10;
	public static final double SIZE_RANGE = 30;

	public boolean isEaten = false;

	/**
	 * Creates a piece of a Food at the given x, y location with a random size
	 * between {@link #LOWER_SIZE_BOUND} and {@link #LOWER_SIZE_BOUND} +
	 * {@link #SIZE_RANGE} and with a random color
	 * 
	 * @param x
	 * @param y
	 */
	public Food(double x, double y) {
		double size = LOWER_SIZE_BOUND + Math.random() * SIZE_RANGE;
		baseDisplay = new Ellipse2D.Double(x, y, size, size);
		baseColor = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
	}

	/**
	 * Returns true if the ellipse at least partially contains ANY of the rectangles
	 * in the given array, false otherwise
	 * 
	 * @param rects
	 * @return
	 */
	public boolean intersects(Rectangle2D[] rects) {
		for (int i = 0; i < rects.length; i++) {
			if (this.intersects(rects[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if the ellipse at least partially contains the rectangle, false
	 * otherwise
	 * 
	 * @param r
	 * @return
	 */
	public boolean intersects(Rectangle2D r) {
		if (isEaten) {
			return false;
		}

		if (baseDisplay.intersects(r)) {
			System.out.println("Found an intersection!");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Draws the Food to the screen with a white outline
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g) {
		if (!isEaten) {
			g.setColor(baseColor);
			g.fill(baseDisplay);
			g.setColor(Color.white);
			g.draw(baseDisplay);
		}
	}

	public double getWidth() {
		return baseDisplay.width;
	}

}
