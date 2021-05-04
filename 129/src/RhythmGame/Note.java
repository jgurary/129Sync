package RhythmGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Note implements Drawable {

	Rectangle2D.Double display;
	Color color;
	/**
	 * Speed at which this note falls from the sky
	 */
	double dropSpeed;

	private boolean isMiss = false;
	private boolean isHit = false;
	private boolean isDoneAnimation = false;
	private int animationFrames = 0;

	/**
	 * Creates a new note at the given location (generally the top of the screen),
	 * with the given {@link #dropSpeed}
	 * 
	 * @param x
	 * @param y
	 * @param dropSpeed
	 */
	public Note(double x, double y, double dropSpeed) {
		display = new Rectangle2D.Double(x, y, Settings.NOTE_SIZE, Settings.NOTE_SIZE);
		color = new Color((int) (Math.random() * 0xFFFFFF));
		this.dropSpeed = dropSpeed;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fill(display);
		g.setColor(Color.white);
		g.draw(display);
	}

	/**
	 * Moves the note's display
	 * 
	 * @param x - amount to move on the x-axis
	 * @param y - amount to move on the y-axis
	 */
	public void move(double x, double y) {
		if (isHit) {
			return;
		}
		display.x += x;
		display.y += y;
	}

	/**
	 * Starts this note's death animation and sets it to hit
	 */
	public void hitNote() {
		isHit = true;
	}

	/**
	 * Returns true if this note has been hit successfully, otherwise false
	 * 
	 * @return
	 */
	public boolean isHit() {
		return isHit;
	}

	/**
	 * Returns true if this note has flown off the bottom of the screen, otherwise
	 * false
	 * 
	 * @return
	 */
	public boolean isMiss() {
		return isMiss;
	}

	public void miss() {
		isMiss = true;
	}

	/**
	 * Plays the note's death animation, but only if it's been hit
	 */
	public void tickAnimation() {
		if (!isHit) {
			return;
		}
		if (!isDoneAnimation) {
			animationFrames++;
			display.width = display.width * .8;
			display.height = display.height * .8;
		}
		if (animationFrames > Settings.NOTE_DEATH_ANIMATION_DURATION) {
			isDoneAnimation = true;
			display.width = 0;
			display.height = 0;
		}
	}

}
