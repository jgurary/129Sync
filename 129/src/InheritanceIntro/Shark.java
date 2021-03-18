package InheritanceIntro;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Shark extends SeaCreature {

	Rectangle2D.Double base;
	Rectangle2D.Double tail;
	Ellipse2D.Double eye;

	public static final double WIDTH = 100;
	public static final double HEIGHT = 25;

	public static final double MOVEMENT_PER_SWIM = .4;

	Display displayPanel;

	public enum HorizontalSwim {
		LEFT, RIGHT
	};

	public enum VerticalSwim {
		UP, DOWN
	};

	public HorizontalSwim swimDirectionHorizontal = HorizontalSwim.LEFT;
	public VerticalSwim swimDirectionVertical = VerticalSwim.UP;

	public Shark(double x, double y, Display d) {
		super(x, y);
		placeShark(x, y);
		this.displayPanel = d;
	}

	/**
	 * Places the whale's visual components where they belong
	 * 
	 * @param x
	 * @param y
	 */
	public void placeShark(double x, double y) {
		this.x = x;
		this.y = y;
		base = new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
		tail = new Rectangle2D.Double(x + WIDTH, y + HEIGHT / 2 - WIDTH / 6, WIDTH / 3, HEIGHT / 3);
		eye = new Ellipse2D.Double(x + WIDTH / 4, y + HEIGHT / 4, 10, 10);
	}

	/**
	 * Draws this whale to the screen.
	 */
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.fill(base);
		g.fill(tail);
		g.setColor(Color.red);
		g.fill(eye);

		g.setColor(Color.black);
		g.draw(base);
		g.draw(tail);
		g.draw(eye);
	}

	@Override
	public void swim() {
		double x = 0;
		double y = 0;
		switch (swimDirectionHorizontal) {
		case LEFT:
			x = this.x - MOVEMENT_PER_SWIM;
			break;
		case RIGHT:
			x = this.x + MOVEMENT_PER_SWIM;
			break;
		default:
			break;
		}

		switch (this.swimDirectionVertical) {
		case DOWN:
			y = this.y + MOVEMENT_PER_SWIM;
			break;
		case UP:
			y = this.y - MOVEMENT_PER_SWIM;
			break;
		default:
			break;
		}

		if (x < 0) { // hit the left side
			swimDirectionHorizontal = HorizontalSwim.RIGHT;
		} else if (x > this.displayPanel.getWidth()) { // hit the right side
			swimDirectionHorizontal = HorizontalSwim.LEFT;
		}

		if (y < 0) { // hit the top side
			swimDirectionVertical = VerticalSwim.DOWN;
		} else if (y > this.displayPanel.getHeight()) { // hit the right side
			swimDirectionVertical = VerticalSwim.UP;
		}

		placeShark(x, y);

	}

}
