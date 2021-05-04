package RhythmGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Display extends JPanel implements MouseInputListener, KeyListener {

	private ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	GameManager manager;
	long frameStart = System.currentTimeMillis();

	/**
	 * Construct a panel with specified width, height, and background color
	 * 
	 * @param width
	 * @param height
	 * @param bgColor
	 */
	public Display(int width, int height, Color bgColor) {
		setPreferredSize(new Dimension(width, height));
		setBackground(bgColor);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}

	protected void paintComponent(Graphics graphicHelper) {
		super.paintComponent(graphicHelper);
		Graphics2D g = (Graphics2D) graphicHelper;
		// Start of the frame

		if (manager != null) {
			manager.tick();
			g.setColor(Color.cyan);
			g.setFont(new Font("Monospaced", Font.PLAIN, 20));
			g.drawString("Fail Counter: " + manager.misses, 50, 100);
		}

		for (Drawable d : drawables) {
			d.draw(g);
		}

		long currentTime = System.currentTimeMillis();
		while (currentTime - frameStart < 1000 / Settings.FPS) {
			currentTime = System.currentTimeMillis();
		}
		frameStart = System.currentTimeMillis();

		// End of the frame
		repaint();
	}

	/**
	 * Adds an object to the list of objects to be drawn to the screen
	 * 
	 * @param d
	 */
	public void addDrawable(Drawable d) {
		drawables.add(d);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Click");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()) {
		case KeyEvent.VK_A:
			manager.checkHits(0);
			break;
		case KeyEvent.VK_S:
			manager.checkHits(1);
			break;
		case KeyEvent.VK_D:
			manager.checkHits(2);
			break;
		case KeyEvent.VK_F:
			manager.checkHits(3);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {
	}

	@Override
	public void keyTyped(KeyEvent k) {
	}

}