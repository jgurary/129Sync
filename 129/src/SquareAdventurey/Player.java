package SquareAdventurey;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Player {

	private Rectangle2D.Double baseDisplay;
	private Rectangle2D.Double hat;

	private Color baseColor;
	private Color hatColor;

	public boolean isDead = false;

	/**
	 * Creates a new Player with the given x, y, width, and height, the given color
	 * for the base of Player, and the given color for its hat
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param baseColor - base Player color
	 * @param hatColor  - color of the Player's hat
	 */
	public Player(double x, double y, double width, double height, Color baseColor, Color hatColor) {
		this.baseColor = baseColor;
		this.hatColor = hatColor;
		baseDisplay = new Rectangle2D.Double(x, y, width, height);
		hat = new Rectangle2D.Double(x + width / 3, y - height / 3, width / 3, width / 3);
	}

	/**
	 * Multiplies the player's width by x and height by y
	 * 
	 * @param x
	 * @param y
	 */
	public void scale(double x, double y) {
		baseDisplay.width *= x;
		baseDisplay.height *= y;
		hat.x = baseDisplay.x + baseDisplay.width / 2 - hat.width / 2;
	}

	/**
	 * Add to the player's width by x and height by y
	 * 
	 * @param x
	 * @param y
	 */
	public void enlarge(double x, double y) {
		baseDisplay.width += x;
		baseDisplay.height += y;
		hat.x = baseDisplay.x + baseDisplay.width / 2 - hat.width / 2;
	}

	public Rectangle2D.Double[] getRectangles() {
		return new Rectangle2D.Double[] { baseDisplay, hat };
	}

	/**
	 * Draws the player to the screen with a white outline. See {@link #baseColor}
	 * for base color and {@link #hatColor} for hat color
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g) {
		if (isDead) {
			g.setColor(Color.red);
			g.fill(baseDisplay);
			g.setColor(Color.white);
			g.draw(baseDisplay);
		} else {
			g.setColor(baseColor);
			g.fill(baseDisplay);
			g.setColor(hatColor);
			g.fill(hat);
			g.setColor(Color.white);
			g.draw(baseDisplay);
			g.draw(hat);
		}
	}

	/**
	 * Moves the entire Player's display over by x on the x-axis and y on the y-axis
	 * 
	 * @param x
	 * @param y
	 */
	public void translate(double x, double y) {
		baseDisplay.x += x;
		baseDisplay.y += y;
		hat.x += x;
		hat.y += y;
	}

	/**
	 * Handles a character key being pressed on the keyboard
	 * 
	 * @param pressed - the character value of the key that was pressed
	 */
	public void handleKeyPress(char pressed) {
		if (isDead) {
			return;
		}

		switch (pressed) {
		case 'w': // UP
			this.translate(0, -5);
			break;
		case 'a': // LEFT
			this.translate(-5, 0);
			break;
		case 's': // DOWN
			this.translate(0, 5);
			break;
		case 'd': // RIGHT
			this.translate(5, 0);
			break;
		default:
			break;
		}
	}

	/**
	 * Handles a key being pressed on the keyboard
	 * 
	 * @param keyCode - the KeyEvent's keyCode value
	 */
	public void handleKeyPress(int keyCode) {
		if (isDead) {
			return;
		}

		switch (keyCode) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP: // UP
			this.translate(0, -5);
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT: // LEFT
			this.translate(-5, 0);
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN: // DOWN
			this.translate(0, 5);
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT: // RIGHT
			this.translate(5, 0);
			break;
		default:
			break;
		}

		// This block of code is equivalent in function to the block above

//		if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
//			this.translate(0, -5);
//		}else if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT){
//			this.translate(-5, 0);
//		}else if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN){
//			this.translate(0, 5);
//		}else if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT){
//			this.translate(5, 0);
//		}

	}

	/**
	 * Returns the width of the base display (the main shape)
	 * 
	 * @return
	 */
	public double getWidth() {
		return baseDisplay.width;
	}

}
