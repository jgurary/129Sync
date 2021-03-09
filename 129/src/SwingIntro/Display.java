package SwingIntro;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Display extends JPanel implements MouseInputListener, KeyListener {

	Rectangle2D.Double rects[] = new Rectangle2D.Double[4];
	public static final int TOP_LEFT = 0;
	public static final int TOP_RIGHT = 1;
	public static final int BOTTOM_LEFT = 2;
	public static final int BOTTOM_RIGHT = 3;

	public Rectangle2D.Double dragged;

	Rectangle2D.Double keyboardMover = new Rectangle2D.Double(100, 100, 75, 75);

	public Display(int width, int height, Color bgColor) {
		Dimension panelSize = new Dimension(width, height);
		this.setPreferredSize(panelSize);
		this.setBackground(bgColor);

		/*
		 * You can set your rectangles up in the panel's constructor to place them in
		 * specific locations. Just remember: the getWidth() and getHeight() methods
		 * inherited from the panels DO NOT work in the constructor, use the local
		 * variables with and height instead!
		 */
		rects[TOP_LEFT] = new Rectangle2D.Double(width / 4 - 25, height / 4 - 25, 50, 50);
		rects[TOP_RIGHT] = new Rectangle2D.Double(3 * width / 4 - 25, height / 4 - 25, 50, 50);
		rects[BOTTOM_LEFT] = new Rectangle2D.Double(width / 4 - 25, 3 * height / 4 - 25, 50, 50);
		rects[BOTTOM_RIGHT] = new Rectangle2D.Double(3 * width / 4 - 25, 3 * height / 4 - 25, 50, 50);

		/*
		 * Add the listeners to this panel
		 */
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);

		// Makes the window able to be "in focus"
		this.setFocusable(true);

		// Disables the shift and tab functions that some windows use
		this.setFocusTraversalKeysEnabled(false);
	}

	protected void paintComponent(Graphics graphics) {
		/*
		 * This line basically erases the screen and redraws the background
		 */
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;

		/*
		 * Changing brush properties...
		 */
		g.setStroke(new BasicStroke(10));
		g.setColor(Color.black);

		/*
		 * Drawing shape objects to the screen...
		 */
		g.setColor(Color.red);
		for (int i = 0; i < rects.length; i++) {
			g.fill(rects[i]);
		}
		g.fill(keyboardMover);

		g.setColor(Color.black);
		for (int i = 0; i < rects.length; i++) {
			g.draw(rects[i]);
		}
		g.draw(keyboardMover);

		/*
		 * Missing around with drawing functions.....
		 */
		g.setColor(Color.cyan);
		g.drawLine(0, 0, this.getWidth() / 2, this.getHeight() / 2);
		g.drawLine(this.getWidth() / 2, this.getHeight() / 2, 0, this.getHeight());

		g.setColor(Color.black);
		int rectWidth = this.getWidth() / 4;
		int rectHeight = this.getHeight() / 4;

		/*
		 * If you want a shape centered around some point (x, y), then you typically do:
		 * shapeX = x - shapeWidth/2 rectY = y - shapeHeight/2
		 */
		g.setColor(Color.blue);
		g.fillRect(this.getWidth() / 2 - rectWidth / 2, this.getHeight() / 2 - rectHeight / 2, rectWidth, rectHeight);
		g.setColor(Color.cyan);
		g.fillOval(this.getWidth() / 2 - rectWidth / 2, this.getHeight() / 2 - rectHeight / 2, rectWidth, rectHeight);
		g.setColor(Color.red);
		g.drawOval(this.getWidth() / 2 - rectWidth / 2, this.getHeight() / 2 - rectHeight / 2, rectWidth, rectHeight);
		g.setColor(Color.green);
		g.drawRect(this.getWidth() / 2 - rectWidth / 2, this.getHeight() / 2 - rectHeight / 2, rectWidth, rectHeight);

		// g.setFont(new Font()); //TODO add a font!
		g.setColor(Color.black);
		g.drawString("This some text", 100, 100);

	}

	/*
	 * Normally, we don't use this one! Happens when the mouse is released, but not
	 * if it moved between press and release.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println("clicked at: " + e.getPoint());
	}

	/*
	 * Triggers when the mouse button is first pushed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < rects.length; i++) {
			if (rects[i].contains(e.getPoint())) {
				dragged = rects[i];
				System.out.println("Clicked the rectangle!");
			}
		}

	}

	/*
	 * Triggers when the mouse is let go, even if it's moved (unlike clicked)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		dragged = null;
	}

	/*
	 * Triggers when the mouse pointer enters the panel
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// System.out.println("entered at: " + e.getPoint());
	}

	/*
	 * Triggers when the mouse pointer exits the panel
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// System.out.println("exited at: " + e.getPoint());
	}

	/*
	 * Triggers when you press down, and stops when you release
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if (dragged != null) {
			dragged.x = e.getX() - dragged.width / 2;
			dragged.y = e.getY() - dragged.height / 2;
		}
		/*
		 * Any time you want the screen to redraw, you must call repaint, or nothing
		 * will happen!
		 */
		repaint();
	}

	/*
	 * Triggers any time the mouse is moved inside the panel
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// System.out.println("moved at: " + e.getPoint());
	}

	/*
	 * Generally, we won't use this one... Types as you would normally expect, you
	 * push the key, it goes off, after some delay, if the key is still held down,
	 * it goes off some more
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println("Pressed: " + e.getKeyChar() + " " + e.getKeyCode());
	}

	/*
	 * Triggers when the key is pressed down, and then repeatedly until it's let go
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'w': // UP
			keyboardMover.y += -5;
			break;
		case 's': // DOWN
			keyboardMover.y += 5;
			break;
		case 'a': // LEFT
			keyboardMover.x += -5;
			break;
		case 'd': // RIGHT
			keyboardMover.x += 5;
			break;
		default:
			break;
		}
		repaint();
	}

	/*
	 * Triggers when the key is released, just once!
	 */
	@Override
	public void keyReleased(KeyEvent e) {

	}

}
