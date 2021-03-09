package SquareAdventurey;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Display extends JPanel implements MouseInputListener, KeyListener {

	Player player = new Player(100, 100, 20, 20, Color.pink, Color.cyan);
	Food food[] = new Food[50];

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

		for (int i = 0; i < food.length; i++) {
			food[i] = new Food(Math.random() * width, Math.random() * height);
		}
	}

	protected void paintComponent(Graphics graphicHelper) {
		super.paintComponent(graphicHelper);
		Graphics2D g = (Graphics2D) graphicHelper;
		for (int i = 0; i < food.length; i++) {
			food[i].draw(g);
		}
		player.draw(g);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent k) {
		player.handleKeyPress(k.getKeyCode());

		for (int i = 0; i < food.length; i++) {
			Food f = food[i];

			if (f.intersects(player.getRectangles())) {
				if (player.getWidth() < f.getWidth()) {
					player.isDead = true;
				} else {
					f.isEaten = true;
					player.enlarge(f.getWidth() / 2, f.getWidth() / 2);
				}
			}
		}

		// Fancy for loop syntax, does the same thing as the statement above!
//		for (Food f : food) {
//			if (f.intersects(player.getRectangles())) {
//				if (player.getWidth() < f.getWidth()) {
//					player.isDead = true;
//				} else {
//					f.isEaten = true;
//					player.enlarge(f.getWidth() / 2, f.getWidth() / 2);
//				}
//			}
//		}

		// reset the game
		if (k.getKeyCode() == KeyEvent.VK_Z) {
			player = new Player(100, 100, 20, 20, Color.pink, Color.cyan);

			for (int i = 0; i < food.length; i++) {
				food[i] = new Food(Math.random() * getWidth(), Math.random() * getHeight());
			}
		}

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}