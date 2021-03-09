package HW4Solution;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class Card {

	Rectangle2D.Double display;
	Rectangle2D.Double hint;
	Color color;
	boolean isFlipped = false;
	public static final int HINT_NONE = 0;
	public static final int HINT_LEFT = 1;
	public static final int HINT_RIGHT = 2;
	int hintType;

	public static final int CARD_SIZE = 50;
	public static final int PADDING = 10;

	/**
	 * Creates a new card at the specified location, with {@link Card#CARD_SIZE}
	 * width and height
	 * 
	 * @param x
	 * @param y
	 */
	public Card(double x, double y) {
		display = new Rectangle2D.Double(x, y, CARD_SIZE, CARD_SIZE);
		color = new Color((int) (Math.random() * 0xFFFFFF));
	}

	/**
	 * Draws this card to the screen, in its color if flipped, in white otherwise
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g) {
		// Fill in shape in its color, or in white if not flipped
		if (isFlipped) {
			g.setColor(color);
			g.fill(display);
		} else {
			g.setColor(Color.white);
			g.fill(display);
		}

		g.setColor(Color.white);
		if (hintType == HINT_LEFT) {
			g.fillRect((int) display.x, (int) display.y, 10, 10);
		} else if (hintType == HINT_RIGHT) {
			g.fillRect((int) (display.x + display.width - 10), (int) display.y, 10, 10);
		}
		// Draw the outline here
		g.setColor(Color.black);
		g.draw(display);
	}

	/**
	 * Returns true if this card contains the given point
	 * 
	 * @param p
	 * @return
	 */
	public boolean contains(Point p) {
		if (display.contains(p)) {
			return true;
		} else {
			return false;
		}
	}

}
