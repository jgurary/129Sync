package HW3Solution;

public class Rect {

	Point points[] = new Point[4];
	public static final int TOP_LEFT = 0;
	public static final int TOP_RIGHT = 1;
	public static final int BOTTOM_LEFT = 2;
	public static final int BOTTOM_RIGHT = 3;
	private int width, height;

	public Rect(int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		/*
		 * TOP LEFT TOP RIGHT
		 * 
		 * BOTTOM LEFT BOTTOM RIGHT
		 */
		points[TOP_LEFT] = new Point(x, y);
		points[TOP_RIGHT] = new Point(x + width, y);
		points[BOTTOM_LEFT] = new Point(x, y + height);
		points[BOTTOM_RIGHT] = new Point(x + width, y + height);
	}

	public Rect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		points[TOP_LEFT] = new Point(x1, y1);
		points[TOP_RIGHT] = new Point(x2, y2);
		points[BOTTOM_LEFT] = new Point(x3, y3);
		points[BOTTOM_RIGHT] = new Point(x4, y4);
		width = points[TOP_RIGHT].x - points[TOP_LEFT].x;
		height = points[BOTTOM_RIGHT].y - points[TOP_RIGHT].y;
	}

	public boolean contains(Point p) {
		if (p.x >= points[TOP_LEFT].x && p.x <= points[TOP_RIGHT].x && p.y >= points[TOP_LEFT].y
				&& p.y <= points[BOTTOM_RIGHT].y) {
			return true;
		} else {
			return false;
		}
	}

	public boolean contains(Rect other) {
		for (int i = 0; i < other.points.length; i++) {
			if (!this.contains(other.points[i])) {
				return false;
			}
		}
		return true;
	}

	public void translate(int xMove, int yMove) {
		for (int i = 0; i < points.length; i++) {
			points[i].x += xMove;
			points[i].y += yMove;
		}
	}

	public Rect scale(float xScale, float yScale) {
		return new Rect(this.getX(), this.getY(), (int) (width * xScale), (int) (height * yScale));
	}

	public String toString() {
		String out = "Rect with: ";
		for (int i = 0; i < points.length; i++) {
			out += points[i].toString() + " ";
		}
		return out;
	}

	public int getX() {
		return points[TOP_LEFT].x;
	}

	public int getY() {
		return points[TOP_LEFT].y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
