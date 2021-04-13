package InterfaceIntro;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public interface Drawable {

	/**
	 * Draws this object to the screen
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g);

	/**
	 * Returns the base shape that this object uses to draw itself
	 * 
	 * @return
	 */
	public Shape getDrawableBase();

	public Color getColor();

	public void setColor(Color c);

}
