package SandwichShop;

import SandwichShop.Sandwich.Bread;
import SandwichShop.Sandwich.Meat;
import SandwichShop.Sandwich.Sauce;
import SandwichShop.Sandwich.Veggie;

public class Driver {

	public static void main(String[] args) {

		//@formatter:off
		Sandwich bbqChicken = new Sandwich(
				Bread.PLAIN, 
				Meat.CHICKEN, 
				new Sauce[] { Sauce.BBQ },
				new Veggie[] { Veggie.ONION, Veggie.PINEAPPLE });
		//@formatter:on

		System.out.println(bbqChicken.toString());

		Store mrSandwich = new Store();
		System.out.println(mrSandwich.printInventory());
		;

	}

}
