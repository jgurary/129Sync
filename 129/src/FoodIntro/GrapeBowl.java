package FoodIntro;

public class GrapeBowl {

	private Grape[] grapes;
	private static final int DEFAULT_GRAPE_AMOUNT = 100;
	private static final int GRAPE_PER_BITE = 10;

	/**
	 * Creates a bowl of Grape with the specified number of grapes
	 * 
	 * @param size
	 */
	public GrapeBowl(int size) {
		grapes = new Grape[size];
		refillBowl();
	}

	/**
	 * Creates a bowl of Grape with the default number of grapes
	 * {@link #DEFAULT_GRAPE_AMOUNT}
	 */
	public GrapeBowl() {
		grapes = new Grape[DEFAULT_GRAPE_AMOUNT];
		refillBowl();
	}

	/**
	 * Makes a bowl of Grape out of grapes you provide
	 * 
	 * @param grapes
	 */
	public GrapeBowl(Grape grapes[]) {
		this.grapes = grapes;
	}

	public Grape[] getGrapes() {
		return grapes;
	}

	/**
	 * Populates the Grape bowl with fresh grapes
	 */
	public void refillBowl() {
		for (int i = 0; i < grapes.length; i++) {
			grapes[i] = new Grape();
		}
	}

	/**
	 * Eats up to {@link #GRAPE_PER_BITE} grapes in a single bite, and returns the
	 * number of calories you ate
	 * 
	 * @return
	 */
	public int bite() {
		int calories = 0;
		for (int i = 0; i < GRAPE_PER_BITE; i++) {
			// Pick a random index out of the grape array
			int pick = (int) (Math.random() * grapes.length);
			if (grapes[pick] != null) {
				calories += grapes[pick].eat();
			}
			grapes[pick] = null;
		}
		return calories;
	}

	/**
	 * Returns the number of grapes that are uneaten in this bowl
	 * 
	 * @return
	 */
	public int getUneatenCount() {
		int count = 0;
		for (int i = 0; i < grapes.length; i++) {
			if (grapes[i] != null) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Empties out the two bowls supplied as arguments and puts all their grapes
	 * into a new bowl
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static GrapeBowl combine(GrapeBowl first, GrapeBowl second) {
		int grapesLeft = first.getUneatenCount() + second.getUneatenCount();
		Grape[] grapes = new Grape[grapesLeft];
		int nextIndex = 0;

		for (int i = 0; i < first.getGrapes().length; i++) {
			if (first.getGrapes()[i] != null) {
				grapes[nextIndex] = first.getGrapes()[i];
				first.getGrapes()[i] = null; // attempt to empty the bowl
				nextIndex++;
			}
		}

		Grape[] secondGrapesArray = second.getGrapes();
		for (int i = 0; i < secondGrapesArray.length; i++) {
			if (secondGrapesArray[i] != null) {
				grapes[nextIndex] = secondGrapesArray[i];
				secondGrapesArray[i] = null; // attempt to empty the bowl
				// secondGrapesArray = new Grape[10];
				// secondGrapesArray[0] = new Grape();
				nextIndex++;
			}
		}

		return new GrapeBowl(grapes);
	}
}
