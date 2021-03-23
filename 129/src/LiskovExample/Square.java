package LiskovExample;

import java.awt.Color;

public class Square extends Rect {

	public Square(double x, double y, double width, double height) {
		super(x, y, width, height);
		super.color = Color.green;
	}

}
