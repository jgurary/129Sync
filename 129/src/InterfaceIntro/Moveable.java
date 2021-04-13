package InterfaceIntro;

public interface Moveable {

	public void setX(double x);

	public void setY(double y);

	public double getX();

	public double getY();

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
