package InterfaceIntro;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Car implements Ignition, Engine, Moveable, Drawable {

	private boolean isRunning = false;
	Rectangle2D.Double display = new Rectangle2D.Double(0, 0, 100, 50);
	Color color;

	@Override
	public void crank(int power) {
		if (power > 5) {
			start();
		}
	}

	@Override
	public void start() {
		System.out.println("vrooom");
		isRunning = true;
	}

	@Override
	public void stop() {
		System.out.println("not vrooom");
		stopEngine();
	}

	@Override
	public boolean checkRunning() {
		return isRunning;
	}

	@Override
	public void stopEngine() {
		isRunning = false;
	}

	@Override
	public void setX(double x) {
		display.x = x;
	}

	@Override
	public void setY(double y) {
		display.y = y;
	}

	@Override
	public double getX() {
		return display.x;
	}

	@Override
	public double getY() {
		return display.y;
	}

	@Override
	public void place(double x, double y) {
		display.x = x;
		display.y = y;
	}

	@Override
	public void move(double x, double y) {
		display.x += x;
		display.y += y;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.draw(display);
		g.setColor(color);
		g.fill(display);
	}

	@Override
	public Rectangle2D getDrawableBase() {
		return display;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color c) {
		color = c;
	}

}
