package RhythmGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class HitZone implements Drawable {

	Rectangle2D.Double display;

	/*
	 * Idle - > isFlashing = true -> Animate -> isDone = true -> Idle (all false)
	 */
	private boolean isFlashing = false;
	private boolean isDoneAnimation = true;

	private int animationFrames = 0;

	public HitZone(double x, double y) {
		display = new Rectangle2D.Double(x, y, Settings.HITZONE_SIZE, Settings.HITZONE_SIZE);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setStroke(new BasicStroke(10));
		if (isFlashing) {
			g.setColor(new Color((int) (Math.random() * 0xFFFFFF)));
		} else {
			g.setColor(Color.white);
		}
		g.draw(display);
	}

	public boolean contains(Rectangle2D r) {
		if (display.contains(r)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Begins the flashing animation that this hitbox utilizes when it successfully
	 * captures a Note. <br>
	 * <br>
	 * Restarts the animation if already currently animating...
	 */
	public void startHitAnimation() {
		isFlashing = true;
		isDoneAnimation = false;
		animationFrames = 0;
	}

	/**
	 * Advances the animation by one frame
	 */
	public void tickAnimation() {
		// If the hitbox has scored a point, and the animation is not done
		if (isFlashing && !isDoneAnimation) {
			animationFrames++;
		}

		// If the animation is over
		if (animationFrames > Settings.HITBOX_HIT_ANIMATION_DURATION) {
			isDoneAnimation = true;
			isFlashing = false;
		}
	}

}
