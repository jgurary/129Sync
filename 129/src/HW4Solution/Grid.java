package HW4Solution;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Grid {

	public static final int NUMBER_OF_CARDS = 25;
	Card[] cards = new Card[NUMBER_OF_CARDS];
	int cyanIndex;
	int guesses = 0;

	/**
	 * Creates a new grid of cards that trys to fit a screen of width and height
	 * dimensions. One of the generated card will be cyan
	 * 
	 * @param width
	 * @param height
	 */
	public Grid(double width, double height) {
		cyanIndex = (int) (Math.random() * NUMBER_OF_CARDS);

		for (int i = 0; i < NUMBER_OF_CARDS; i++) {
			cards[i] = new Card(0, 0);
			if (i < cyanIndex) {
				cards[i].hintType = Card.HINT_RIGHT;
			} else if (i > cyanIndex) {
				cards[i].hintType = Card.HINT_LEFT;
			} else {
				cards[i].hintType = Card.HINT_NONE;
			}
		}
		replaceCards(width, height);
		cards[cyanIndex].color = Color.cyan;
	}

	/**
	 * Recomputes the card positions to the meet a display of the given width and
	 * height
	 */
	public void replaceCards(double width, double height) {
		int x = 0, y = 0;
		for (int i = 0; i < NUMBER_OF_CARDS; i++) {
			cards[i].display.x = x;
			cards[i].display.y = y;
			x += Card.CARD_SIZE + Card.PADDING;
			if (x + Card.CARD_SIZE > width) {
				x = 0;
				y += Card.CARD_SIZE + Card.PADDING;
			}
		}
	}

	/**
	 * Draws all the cards in the grid to the screen
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g) {
		for (int i = 0; i < NUMBER_OF_CARDS; i++) {
			cards[i].draw(g);
		}
	}

	public void handleClick(Point p) {
		for (int i = 0; i < NUMBER_OF_CARDS; i++) {
			if (cards[i].contains(p)) {
				if (!cards[i].isFlipped && !cards[cyanIndex].isFlipped) {
					cards[i].isFlipped = true;
					guesses++;
					if (cyanIndex == i) {
						System.out.println("A winner is you! It took: " + guesses);
					}
				}
			}
		}
	}

}
