package SandwhichShopInheritance;

public class Food {

	public int calories, cost;

	enum FoodName {
		WHEAT, RYE, PLAIN, BRISKET, PORK, CHICKEN, KETCHUP, MUSTARD, BBQ, ONION, LETTUCE, TOMATO, PINEAPPLE
	};

	FoodName name;

	public Food(int calories, int cost, FoodName name) {
		this.calories = calories;
		this.cost = cost;
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public String toString() {
		return this.name.toString();
	}

}
