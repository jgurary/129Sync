package SandwichShop;

import SandwichShop.Sandwich.Bread;
import SandwichShop.Sandwich.Meat;
import SandwichShop.Sandwich.Sauce;
import SandwichShop.Sandwich.Veggie;

public class Store {

	Sandwich inventory[] = new Sandwich[10];

	/**
	 * Creates a new store with ten random sandwiches in its inventory
	 */
	public Store() {
		for (int i = 0; i < inventory.length; i++) {
			inventory[i] = makeRandomSandwich();
		}
	}

	/**
	 * Makes a sandwich with a random bread selection, random meat, and a random
	 * amount of toppings between 0 and the max number of toppings for sale in a
	 * category, randomly selected.
	 * 
	 * @return
	 */
	public Sandwich makeRandomSandwich() {
		/*
		 * Picks a random index between 0 and the number of items that the Bread enum
		 * supports (which is 3, so the max index is 2 here)
		 */
		int random = (int) (Math.random() * Bread.values().length);
		Bread bread = Bread.values()[random];

		random = (int) (Math.random() * Meat.values().length);
		Meat meat = Meat.values()[random];

		int sauceSize = (int) (Math.random() * Sauce.values().length);
		Sauce[] sauces = new Sauce[sauceSize];
		for (int i = 0; i < sauceSize; i++) {
			random = (int) (Math.random() * Sauce.values().length);
			sauces[i] = Sauce.values()[random];
		}

		int veggieSize = (int) (Math.random() * Veggie.values().length);
		Veggie[] veggies = new Veggie[veggieSize];
		for (int i = 0; i < veggieSize; i++) {
			random = (int) (Math.random() * Veggie.values().length);
			veggies[i] = Veggie.values()[random];
		}

		return new Sandwich(bread, meat, sauces, veggies);
	}

	public String printInventory() {
		String out = "";
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				/*
				 * The newline character: \n, starts a new line. This lets us create a single
				 * String that spans multiple lines when it prints to the console.
				 */
				out += i + " " + inventory[i].toString() + "\n";
			} else {
				out += " sold out!\n";
			}
		}

		return out;
	}

}
