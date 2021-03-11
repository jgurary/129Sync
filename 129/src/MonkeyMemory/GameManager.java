package MonkeyMemory;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class GameManager {

	public Card[] cards;

	public GameManager(int numCards) {
		if (numCards < 2) { // handles negative, 0, or 1 cards
			numCards = 2;
		}

		if (numCards % 2 != 0) { // if cards is odd, makes it even by adding 1
			numCards++;
		}

		cards = new Card[numCards];

	}

	/**
	 * Draws all the cards in this game to the screen
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g) {
		for (int i = 0; i < cards.length; i++) {
			cards[i].draw(g);
		}
	}

	/**
	 * Create a new set of cards, where each card has one "pair" with an identical
	 * color somewhere in the {@link #cards} array
	 */
	public void startNewGame() {
		for (int i = 0; i < cards.length; i += 2) {
			Color c = new Color((int) (Math.random() * 0xFFFFFF));
			cards[i] = new Card(0, 0, c);
			cards[i + 1] = new Card(0, 0, c);
		}
	}

	/**
	 * Places all the cards to fit inside the given display
	 */
	public void placeCardsOnDisplay(Display d) {
		double x = Card.PADDING, y = Card.PADDING;
		for (int i = 0; i < cards.length; i++) {
			cards[i].placeCard(x, y);
			x += Card.CARD_SIZE + Card.PADDING;
			if (x + Card.CARD_SIZE > d.getWidth()) {
				y += Card.CARD_SIZE + Card.PADDING;
				x = Card.PADDING;
			}
		}
	}

	/**
	 * Shuffle the deck so that all cards are at random indexes
	 */
	public void shuffleCards() {
		int shuffles = cards.length * 2;
		for (int i = 0; i < shuffles; i++) {
			// Swap two cards randomly
			int first = (int) (Math.random() * cards.length);
			int second = (int) (Math.random() * cards.length);
			Card hold = cards[first];
			cards[first] = cards[second];
			cards[second] = hold;
		}
	}

	public void handleClick(Point p) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].contains(p)) {
				/// do something....
				System.out.println(i);
			}
		}
	}

}
