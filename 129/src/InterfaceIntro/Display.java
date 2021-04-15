package InterfaceIntro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Display extends JPanel {

	/*
	 * valid syntax! creates an object (a car) but stores a reference only to its
	 * Drawable interface!
	 */
	/// Drawable drawable = new Car();

	private Drawable[] drawable = new Drawable[10];
	private int nextDrawable = 0;
	private DisplayInput inputListener;

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

		inputListener = new DisplayInput(this);
		inputListener.registerPanel(this);
	}

	public DisplayInput getInputHandler() {
		return inputListener;
	}

	public void addDrawable(Drawable d) {
		drawable[nextDrawable] = d;
		nextDrawable++;
	}

	protected void paintComponent(Graphics graphicHelper) {
		super.paintComponent(graphicHelper);
		Graphics2D g = (Graphics2D) graphicHelper;

		for (Drawable d : drawable) {
			if (d != null) {
				d.draw(g);
			}
		}
	}

}