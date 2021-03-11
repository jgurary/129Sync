package MonkeyMemory;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class Card {

	public Rectangle2D.Double display;
	public static final double CARD_SIZE = 50;
	public static final double PADDING = 10;
	private Color color;
	boolean isFlipped = false;

	public Card(double x, double y, Color color) {
		display = new Rectangle2D.Double(x, y, CARD_SIZE, CARD_SIZE);
		this.color = color;
	}

	public void draw(Graphics2D g) {
		if (isFlipped) {
			g.setColor(color);
			g.fill(display);
		} else {
			g.setColor(Color.black);
			g.fill(display);
		}
		g.setColor(Color.white);
		g.draw(display);
	}

	public void placeCard(double x, double y) {
		display.x = x;
		display.y = y;
	}

	public boolean contains(Point p) {
		if (display.contains(p)) {
			return true;
		} else {
			return false;
		}
	}

}
