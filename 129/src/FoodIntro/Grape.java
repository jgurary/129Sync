package FoodIntro;

/**
 * A Grape object that doesn't use a "isEaten" flag and instead gets set to
 * "null" to indicate it's been eaten
 * 
 * @author Doctor Fish
 *
 */
public class Grape {
	private boolean isDelicous = false;

	private int calories = 2;

	public int eat() {
		return calories;
	}

	public boolean getIsDelicous() {
		return isDelicous;
	}

	public int getCalories() {
		return calories;
	}
}
