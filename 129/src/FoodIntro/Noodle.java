package FoodIntro;

public class Noodle {

	private boolean isEaten = false;
	private boolean isDelicous = true;

	private int calories = 5;

	/*
	 * If you don't specify a constructor, you get one like this, invisibly in the
	 * background
	 */
	public Noodle() {

	}

	/**
	 * If this noodle is uneaten, sets the noodle to eaten, and returns how many
	 * calories you just ate. Otherwise does nothing and returns zero
	 * 
	 * @return
	 */
	public int eat() {
		if (!isEaten) {
			this.isEaten = true;
			return this.calories;
		} else {
			return 0;
		}
	}

	public boolean getIsEaten() {
		return this.isEaten;
	}

	public boolean getIsDelicous() {
		return isDelicous;
	}

	public int getCalories() {
		return calories;
	}

	public String toString() {
		return "A Noodle with " + calories + " calories";
	}

}
