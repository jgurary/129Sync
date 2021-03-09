package ObjectIntro;

public class Driver {

	public static void main(String[] args) {
//		/*
//		 * Creates a regular Doodad with the name "A", value 5, and secretvalue 10
//		 */
//		Doodad doodA = new Doodad("A", 5, 10);
//		doodA.value += 1;
//		System.out.println(doodA.value);
//
//		Doodad doodB = new Doodad("B", 10, 15);
//		int x = doodA.value + doodB.getInitialValue();
//		System.out.println(x);
//
//		System.out.println("Doodad " + doodA.name + "'s value is " + doodA.value + " and initial value was "
//				+ doodA.getInitialValue());
//		System.out.println("Doodad " + doodB.name + "'s value is " + doodB.value + " and initial value was "
//				+ doodB.getInitialValue());
//
//		Doodad.sharedValue += 1;
//		doodA.sharedValue = doodA.sharedValue * 2;
//		doodB.sharedValue += 1;
//		System.out.println(Doodad.sharedValue);
//		Doodad doodC = new Doodad("C", 7, 14);
//		System.out.println("After C: " + Doodad.sharedValue);
//
//		/*
//		 * Hint: at this point, A's value is 6 B's value is 10 A's secret is 10 B's
//		 * secret is 15
//		 */
//		doodA.setSecretValue(doodB.value);
//		doodB.setSecretValue(doodA.value);
//
//		System.out.println(doodA.getSecretValue());
//		System.out.println(doodB.getSecretValue());

		DoodadProcessor procA = new DoodadProcessor();
		Doodad a = new Doodad("A", 5, 10);
		procA.addDoodad(a);
		procA.addDoodad(new Doodad("A", 10, 10));
		procA.addDoodad(new Doodad("B", 3, 2));
		procA.addDoodad(new Doodad("C", 1, 5));
		procA.removeDoodad("A");
		System.out.println(procA.getSum());

	}

}
