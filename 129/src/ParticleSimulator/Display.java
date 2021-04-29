package ParticleSimulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

//TODO when the panel is resized, inform all particles in the sim
public class Display extends JPanel implements MouseInputListener, KeyListener {

	SimulationManager simulation;
	ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	int frame = 0;
	long frameStart = System.currentTimeMillis();
	public static final int FPS = 60;

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

	/**
	 * Adds everything that should be drawn to the screen to the drawables arrayList
	 * {@link #drawables}
	 */
	public void registerDrawables() {
		if (simulation == null) {
			return;
		}

		for (Particle p : simulation.particles) {
			drawables.add(p);
		}
	}

	protected void paintComponent(Graphics graphicHelper) {
		super.paintComponent(graphicHelper);
		Graphics2D g = (Graphics2D) graphicHelper;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		/*
		 * Start of the frame
		 */
		frame++;

		if (simulation == null) {
			return;
		}
		simulation.tick();

		for (Drawable d : drawables) {
			d.draw(g);
		}

		/*
		 * Stalls until we want to draw the next frame to achieve a constant frame rate
		 */
		long curr = System.currentTimeMillis();
		while (curr - frameStart < 1000 / FPS) {
			curr = System.currentTimeMillis();
		}
		frameStart = System.currentTimeMillis();
		/*
		 * End of the frame
		 */
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
		// increases wind
		if (k.getKeyCode() == KeyEvent.VK_A) {
			simulation.changeWind(.2);
		}
		// decreases wind
		if (k.getKeyCode() == KeyEvent.VK_S) {
			simulation.changeWind(-.2);
		}
		// turns gravity on or off
		if (k.getKeyCode() == KeyEvent.VK_D) {
			simulation.toggleGravity();
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {
	}

	@Override
	public void keyTyped(KeyEvent k) {
	}

}