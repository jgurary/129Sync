package FoodIntro;

public class Ramen {

	private Noodle[] noodles;
	private static final int DEFAULT_NOODLE_AMOUNT = 100;
	private static final int NOODLES_PER_BITE = 10;

	/**
	 * Creates a bowl of Ramen with the specified number of Noodles
	 * 
	 * @param size
	 */
	public Ramen(int size) {
		noodles = new Noodle[size];
		refillBowl();
	}

	/**
	 * Creates a bowl of Ramen with the default number of Noodles
	 * {@link #DEFAULT_NOODLE_AMOUNT}
	 */
	public Ramen() {
		noodles = new Noodle[DEFAULT_NOODLE_AMOUNT];
		refillBowl();
	}

	/**
	 * Makes a bowl of Ramen out of noodles you provide
	 * 
	 * @param noodles
	 */
	public Ramen(Noodle noodles[]) {
		this.noodles = noodles;
	}

	/**
	 * Populates the Ramen bowl with fresh noodles
	 */
	public void refillBowl() {
		for (int i = 0; i < noodles.length; i++) {
			noodles[i] = new Noodle();
		}
	}

	/**
	 * Eats up to {@link #NOODLES_PER_BITE} noodles in a single bite, and returns
	 * the number of calories you ate
	 * 
	 * @return
	 */
	public int bite() {
		int calories = 0;
		for (int i = 0; i < NOODLES_PER_BITE; i++) {
			// Pick a random index out of the noodle array
			Noodle n = noodles[(int) (Math.random() * noodles.length)];
			calories += n.eat();
		}
		return calories;
	}

	/**
	 * Returns the number of noodles that are uneaten in this bowl
	 * 
	 * @return
	 */
	public int getUneatenCount() {
		int count = 0;
		for (int i = 0; i < noodles.length; i++) {
			if (!noodles[i].getIsEaten()) {
				count++;
			}
		}
		return count;
	}

}
