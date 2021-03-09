package FoodIntro;

public class WheatNoodle {

	private boolean isEaten = false;
	private boolean isDelicous = true;

	private int calories = 5;

	/*
	 * If you don't specify a constructor, you get one like this, invisibly in the
	 * background
	 */
	public WheatNoodle() {

	}

	public boolean getIsEaten() {
		return isEaten;
	}

	public boolean getIsDelicous() {
		return isDelicous;
	}

	public int getCalories() {
		return calories;
	}

}
