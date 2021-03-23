package LiskovExample;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Rect extends Rectangle2D.Double {

	Color color = Color.blue;

	public Rect(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

}
