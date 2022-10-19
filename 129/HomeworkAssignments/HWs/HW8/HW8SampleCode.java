//Snowman (all ellipses)

		base = new Ellipse2D.Double(x, y, baseSize, baseSize);
		center = new Ellipse2D.Double(x + baseSize / 2 / 2, y - baseSize / 2, baseSize / 2, baseSize / 2);
		top = new Ellipse2D.Double(x + baseSize / 4 / 2 + baseSize / 2 / 2, y - baseSize / 2 - baseSize / 4,
				baseSize / 4, baseSize / 4);


//Smiley (all ellipses)

		base = new Ellipse2D.Double(x, y, baseSize, baseSize);
		leftEye = new Ellipse2D.Double(x + baseSize * 3 / 4, y + baseSize / 4, baseSize / 8, baseSize / 8);
		rightEye = new Ellipse2D.Double(x + baseSize / 4, y + baseSize / 4, baseSize / 8, baseSize / 8);


//Fox (base and ears are rectangles, eyes are ellipses)

		base = new Rectangle2D.Double(x, y, baseSize, baseSize);
		leftEar = new Rectangle2D.Double(x + baseSize * 3 / 4, y - baseSize / 4, baseSize / 4, baseSize / 4);
		rightEar = new Rectangle2D.Double(x + baseSize / 4, y - baseSize / 4, baseSize / 4, baseSize / 4);
		leftEye = new Ellipse2D.Double(x + baseSize * 3 / 4, y + baseSize / 4, baseSize / 8, baseSize / 8);
		rightEye = new Ellipse2D.Double(x + baseSize / 4, y + baseSize / 4, baseSize / 8, baseSize / 8);



//Some code you might find useful for the selector:

	Point start;
	Rectangle2D.Double display = new Rectangle2D.Double(0, 0, 0, 0);

	public Selector() {

	}

	/**
	 * Plants one corner of this selector at the given point. Used to start a drag
	 * operation
	 * 
	 * @param p
	 */
	void startDrag(Point p) {
		start = p;
	}

	/**
	 * Adjusts the x, y, width and height of the selector so that the opposite
	 * corner of the selector (relative to {@link #start} is at the given point
	 * 
	 * @param p
	 */
	void dragToPoint(Point p) {
		Point end = p;
		if (p.x > start.x && p.y > start.y) {
			display.x = start.x;
			display.y = start.y;
		} else if (p.x < start.x && p.y < start.y) {
			display.x = end.x;
			display.y = end.y;
		} else if (p.x < start.x && p.y > start.y) {
			display.x = end.x;
			display.y = start.y;
		} else {
			display.x = start.x;
			display.y = end.y;
		}
		display.width = Math.abs(end.x - start.x);
		display.height = Math.abs(end.y - start.y);
	}

	/**
	 * Resets the selector to a size of zero, ending the display
	 */
	void endDrag() {
		display.width = 0;
		display.height = 0;
	}

	/**
	 * Returns true if the selector contains all of the given rectangles
	 * 
	 * @param others
	 * @return
	 */
	public boolean contains(Rectangle2D[] others) {
		for (int i = 0; i < others.length; i++) {
			if (!display.contains(others[i])) {
				return false;
			}
		}
		return true;
	}
