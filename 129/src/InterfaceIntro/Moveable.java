package InterfaceIntro;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public interface Moveable {

	/**
	 * Returns the base shape whose x and y location this interface track
	 * 
	 * @return
	 */
	public Shape getShape();

	public void setX(double x);

	public void setY(double y);

	public default double getX() {
		Shape hold = getShape();
		// Alternatively: Cast as all the different kinds of shapes we might have?
		Rectangle2D boundingBox = hold.getBounds2D();
		// System.out.println(this.toString() + " I AM THE DEFAULT VERSION");
		return boundingBox.getX();
	}

	public default double getY() {
		Shape hold = getShape();
		// Alternatively: Cast as all the different kinds of shapes we might have?
		Rectangle2D boundingBox = hold.getBounds2D();
		return boundingBox.getY();
	}

	/**
	 * Place this moveable object at the given position
	 * 
	 * @param x
	 * @param y
	 */
	public void place(double x, double y);

	/**
	 * Adjust the x and y position by the values given
	 * 
	 * @param x
	 * @param y
	 */
	public void move(double x, double y);

}
