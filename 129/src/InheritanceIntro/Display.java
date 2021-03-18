package InheritanceIntro;

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

//	SeaCreature crabby = new Crab(100, 100, Color.blue);
//	SeaCreature whaley = new Whale(200, 400, 200);

	SeaCreature[] creatures = new SeaCreature[10];

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

		for (int i = 0; i < creatures.length; i++) {
			// make a crab or whale with a 50/50 chance
			double rand = Math.random();
			if (rand < .33) {
				creatures[i] = new Whale(Math.random() * width, Math.random() * height, 200, this);
			} else if (rand > .33 && rand < .66) {
				creatures[i] = new Crab(Math.random() * width, Math.random() * height, Color.blue);
			} else {
				creatures[i] = new Shark(Math.random() * width, Math.random() * height, this);
			}
		}
	}

	protected void paintComponent(Graphics graphicHelper) {
		super.paintComponent(graphicHelper);
		Graphics2D g = (Graphics2D) graphicHelper;
//		crabby.draw(g);
//		whaley.draw(g);

		for (int i = 0; i < creatures.length; i++) {
			creatures[i].swim();
			creatures[i].draw(g);
		}

		repaint();
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
		System.out.println(k.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent k) {
	}

	@Override
	public void keyTyped(KeyEvent k) {
	}

}