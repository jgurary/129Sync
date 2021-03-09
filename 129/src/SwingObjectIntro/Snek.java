package SwingObjectIntro;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Snek {

	Rectangle2D.Double body;
	Ellipse2D.Double eyeball;

	Color baseColor = Color.yellow;
	Color eyeColor;

	/**
	 * Creates a new Snek at the specified x and y position, who is width long and
	 * height fat. This snek will be the default yellow color, with randomly colored
	 * eyes.
	 * 
	 * @param x
	 * @param y
	 * @param width  - length of the Snek
	 * @param height - fatness of the Snek
	 */
	public Snek(int x, int y, int width, int height) {
		body = new Rectangle2D.Double(x, y, width, height);
		eyeball = new Ellipse2D.Double(x + 10, y + 10, height / 4, height / 4);
		randomizeEyeColor();
	}

	/**
	 * Creates a new Snek at the specified x and y position, who is width long and
	 * height fat. This Snek will be the specified color, with randomly colored
	 * eyes.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param snekColor
	 */
	public Snek(int x, int y, int width, int height, Color snekColor) {
		body = new Rectangle2D.Double(x, y, width, height);
		eyeball = new Ellipse2D.Double(x + 10, y + 10, height / 4, height / 4);
		randomizeEyeColor();
		baseColor = snekColor;
	}

	/**
	 * Draws the object to the panel
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g) {
		g.setColor(baseColor);
		g.fill(body);
		g.setColor(eyeColor);
		g.fill(eyeball);
		g.setColor(Color.black);
		g.draw(body);
		g.draw(eyeball);
	}

	/**
	 * Returns true if this Snek's eyeball contains the given point
	 * 
	 * @param p
	 * @return
	 */
	public boolean eyeballContains(Point p) {
		if (eyeball.contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Randomly generate a new eye color for this Snek
	 */
	public void randomizeEyeColor() {
		eyeColor = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}

}
