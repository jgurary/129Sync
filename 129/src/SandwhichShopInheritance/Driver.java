package SandwhichShopInheritance;

public class Driver {

	public static void main(String[] args) {

		//@formatter:off
		Sandwich bbqChicken = new Sandwich(
				new Bread(5, 5, Food.FoodName.PLAIN), 
				new Meat(10, 5, Food.FoodName.CHICKEN), 
				new Sauce[] { new Sauce(2, 5, Food.FoodName.BBQ) },
				new Veggie[] { new Veggie(2, 1, Food.FoodName.ONION), new Veggie(1, 1, Food.FoodName.LETTUCE) });
		//@formatter:on

		System.out.println(bbqChicken.toString());

		Store mrSandwich = new Store();
		System.out.println(mrSandwich.printInventory());
		;

	}

}
