package SandwichShop;

public class Sandwich {

	enum Bread {
		WHEAT, RYE, PLAIN;

		public String toString() {
			// TODO go back some day and do this using super and toString instead...
			return this.name().toLowerCase();
		}
	}

	enum Meat {
		BRISKET(10, 10), PORK(10, 5), CHICKEN(5, 3);

		/*
		 * Enums are actually a full-fledged class, you can add fields, constructors,
		 * methods, etc to them
		 */
		public int calories, cost;

		private Meat(int calories, int cost) {
			this.calories = calories;
			this.cost = cost;
		}

		public int getCost() {
			return cost;
		}

		public String toString() {
			return this.name().toLowerCase();
		}
	}

	enum Sauce {
		KETCHUP, MUSTARD, BBQ;

		public String toString() {
			return this.name().toLowerCase();
		}
	}

	enum Veggie {
		ONION, LETTUCE, TOMATO, PINEAPPLE;

		public String toString() {
			return this.name().toLowerCase();
		}
	}

	Bread bread;
	Meat meat;
	Sauce[] sauces;
	Veggie[] veggies;

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
	}

	/**
	 * Returns a printable description of this sandwich
	 */
	public String toString() {
		String out = "Sandwich with: " + bread.toString() + " bread, " + meat.toString() + " ";
		for (int i = 0; i < sauces.length; i++) {
			out += sauces[i].toString() + " ";
		}
		for (int i = 0; i < veggies.length; i++) {
			out += veggies[i].toString() + " ";
		}
		return out;
	}

}
