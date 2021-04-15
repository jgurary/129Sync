package InterfaceIntro;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class ElectricCar implements Ignition, Drawable, Moveable {

	Ellipse2D.Double display = new Ellipse2D.Double(0, 0, 100, 50);
	Color color;

	@Override
	public void setX(double x) {
		display.x = x;
	}

	@Override
	public void setY(double y) {
		display.y = y;
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
	public Ellipse2D getDrawableBase() {
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

	@Override
	public Shape getShape() {
		return display;
	}

	@Override
	public void crank(int power) {
		System.out.println("Nothing happens, electric cars don't crank");
	}

	@Override
	public void start() {
		System.out.println("Car's on");
	}

	@Override
	public void stop() {
		System.out.println("Car's off");
	}

}
