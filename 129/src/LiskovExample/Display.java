package LiskovExample;

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

	Rectangle2D.Double[] shapes = new Rectangle2D.Double[20];

	public Display(int width, int height, Color bgColor) {
		Dimension panelSize = new Dimension(width, height);
		this.setPreferredSize(panelSize);
		this.setBackground(bgColor);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);

		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);

		for (int i = 0; i < shapes.length; i++) {
			double rand = Math.random();
			if (rand < .5) {
				shapes[i] = new Rect(Math.random() * width, Math.random() * height, 100, 50);
			} else {
				shapes[i] = new Square(Math.random() * width, Math.random() * height, 50, 50);
			}
		}
	}

	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;

		for (int i = 0; i < shapes.length; i++) {
			/*
			 * Avoid doing this unless you are absolutely sure that the object in question
			 * is a Rect. Casing a parent as a child object like this is a dangerous move
			 * you should avoid whenever possible.
			 * 
			 * Generally, when Eclipse suggests you to do this, don't. Rewrite some part of
			 * your code to avoid having to do this
			 */
			Rect r = (Rect) shapes[i];
			Color c = r.color;
			g.setColor(c);
			g.fill(shapes[i]);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i].contains(e.getPoint())) {
				// Liskov substitution violation!!!
				/*
				 * Squares can't change width! They would no longer be squares. This means a
				 * child of Rect, doesn't support all the features that Rect does!
				 * 
				 * Every child object should support all of the features of its parent!
				 */
				shapes[i].width += 5;
			}
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
