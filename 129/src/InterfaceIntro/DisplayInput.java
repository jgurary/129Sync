package InterfaceIntro;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class DisplayInput implements MouseInputListener, KeyListener {

	private Moveable[] moveable = new Moveable[10];
	private int nextMoveable = 0;
	private JPanel panel;

	public DisplayInput(JPanel panel) {

		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);

		panel.addKeyListener(this);
		panel.setFocusable(true);
		panel.setFocusTraversalKeysEnabled(false);
	}

	public void registerPanel(JPanel panel) {
		this.panel = panel;
	}

	public void addMoveable(Moveable m) {
		moveable[nextMoveable] = m;
		nextMoveable++;
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
	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode() == KeyEvent.VK_A) {
			for (Moveable m : moveable) {
				if (m != null) {
					m.move(-5, 0);
				}
			}
		}

		if (k.getKeyCode() == KeyEvent.VK_D) {
			for (Moveable m : moveable) {
				if (m != null) {
					m.move(5, 0);
				}
			}
		}
		panel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
