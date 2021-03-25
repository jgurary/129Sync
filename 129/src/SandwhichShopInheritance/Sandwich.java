package SandwhichShopInheritance;

public class Sandwich {

	Bread bread;
	Meat meat;
	Sauce[] sauces;
	Veggie[] veggies;

	Food[] ingredients;
	public static int BREAD_INDEX = 0;
	public static int MEAT_INDEX = 1;
	public static int SAUCE_INDEX_ARRAY_START = 2;
	public int VEGGIE_INDEX_ARRAY_START;

	/**
	 * Creates a sandwich with the designated bread, meat, and toppings
	 * 
	 * @param bread
	 * @param meat    - you only get one meat option
	 * @param sauces
	 * @param veggies
	 */
	public Sandwich(Bread bread, Meat meat, Sauce[] sauces, Veggie[] veggies) {
		this.bread = bread;
		this.meat = meat;
		this.sauces = sauces;
		this.veggies = veggies;

		VEGGIE_INDEX_ARRAY_START = sauces.length + 2;
		// Copies all the food stuffs into the ingredients array
		// Length is 1 bread, 1 meat, and however many sauces + veggies
		ingredients = new Food[1 + 1 + sauces.length + veggies.length];
		int nextIngredient = 0;
		ingredients[nextIngredient] = bread;
		nextIngredient++;
		ingredients[nextIngredient] = meat;
		nextIngredient++;
		for (Sauce sauce : sauces) {
			ingredients[nextIngredient] = sauce;
			nextIngredient++;
		}
		for (Veggie veggie : veggies) {
			ingredients[nextIngredient] = veggie;
			nextIngredient++;
		}
	}

	/**
	 * Returns a printable description of this sandwich
	 */
	public String toString() {
		String out = "Sandwich with: ";
		for (Food f : this.ingredients) {
			out += f.toString() + " ";
		}
//		String out = "Sandwich with: " + bread.toString() + " bread, " + meat.toString() + " ";
//		for (int i = 0; i < sauces.length; i++) {
//			out += sauces[i].toString() + " ";
//		}
//		for (int i = 0; i < veggies.length; i++) {
//			out += veggies[i].toString() + " ";
//		}
		return out;
	}

	/**
	 * Returns the total cost of all the ingredients in this sandwich
	 * 
	 * @return
	 */
	public int getTotalCost() {
		int total = 0;
		for (Food f : this.ingredients) {
			total += f.cost;
		}
		return 0;
	}

	public int getSmoothness() {
		int total = 0;
		for (Sauce sauce : sauces) {
			total += sauce.smoothness;
		}
		return total;
	}

	public int getSmoothnessAlt() {
		int total = 0;
		for (int i = SAUCE_INDEX_ARRAY_START; i < VEGGIE_INDEX_ARRAY_START; i++) {
			total += ((Sauce) ingredients[i]).smoothness;
		}
		return total;
	}

}
