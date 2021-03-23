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
			g.setColor(Color.blue);
			g.fill(shapes[i]);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

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
