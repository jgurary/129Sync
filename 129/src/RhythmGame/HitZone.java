package RhythmGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class HitZone implements Drawable {

	Rectangle2D.Double display;
	boolean isFlashing = false;

	public HitZone(double x, double y) {
		display = new Rectangle2D.Double(x, y, Settings.HITZONE_SIZE, Settings.HITZONE_SIZE);
	}

	@Override
	public void draw(Graphics2D g) {
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

}
