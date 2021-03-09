package FoodIntro;

public class Driver {

	public static void main(String[] args) {

		Ramen bowl = new Ramen(150);
		int caloriesEatenTotal = 0;
		caloriesEatenTotal += bowl.bite();
		System.out.println(caloriesEatenTotal);

		caloriesEatenTotal += bowl.bite();
		System.out.println(caloriesEatenTotal);

		caloriesEatenTotal += bowl.bite();
		System.out.println(caloriesEatenTotal);

		caloriesEatenTotal += bowl.bite();
		System.out.println(caloriesEatenTotal);

		caloriesEatenTotal += bowl.bite();
		System.out.println(caloriesEatenTotal);

		System.out.println("Uneaten: " + bowl.getUneatenCount());

		System.out.println("End of the Ramen part...");

		GrapeBowl grapeBowl = new GrapeBowl(150);
		GrapeBowl anotherGrapeBowl = new GrapeBowl(150);
		int caloriesEatenTotalGrape = 0;
		caloriesEatenTotalGrape += grapeBowl.bite();
		System.out.println(caloriesEatenTotalGrape);

		caloriesEatenTotalGrape += grapeBowl.bite();
		System.out.println(caloriesEatenTotalGrape);

		caloriesEatenTotalGrape += grapeBowl.bite();
		System.out.println(caloriesEatenTotalGrape);

		caloriesEatenTotalGrape += grapeBowl.bite();
		System.out.println(caloriesEatenTotalGrape);

		caloriesEatenTotalGrape += grapeBowl.bite();
		System.out.println(caloriesEatenTotalGrape);

		System.out.println("Uneaten in first bowl: " + grapeBowl.getUneatenCount());
		System.out.println(grapeBowl.getGrapes()[0]); // Look at the reference ID here
		System.out.println("Uneaten in second bowl: " + anotherGrapeBowl.getUneatenCount());

		System.out.println("Attempting to combine bowls...");
		GrapeBowl combined = GrapeBowl.combine(grapeBowl, anotherGrapeBowl);

		System.out.println("Uneaten in first bowl: " + grapeBowl.getUneatenCount());
		System.out.println("Uneaten in second bowl: " + anotherGrapeBowl.getUneatenCount());
		System.out.println("Uneaten in the new combined bowl: " + combined.getUneatenCount());
		System.out.println(combined.getGrapes()[0]); // Note the same ID! It's the same grape!

	}

}
