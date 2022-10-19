
public class Driver {

	public static void main(String[] args) {
		int[] numbers = { 4, 5, 6, 7 };
		int[] shortNumbers = { 1, 2 };
		int item = getSecondToLastItem(numbers); // returns 6
		System.out.println("Second to last in numbers: " + item);
		item = getSecondToLastItem(shortNumbers); // returns 1
		System.out.println("Second to last in short: " + item);

		float avg = getAverage(numbers); // returns about 5.5
		System.out.println("avg: " + avg);

		int[] reverse = reverseArray(numbers); // returns {7, 6, 5, 4}
		System.out.println(reverse[0] + " " + reverse[1]); // prints "7 6"

		double flippedA = flipDouble(73.21); // returns 21.73
		double flippedB = flipDouble(123.45); // returns 45.123
		System.out.println("Flipped A: " + flippedA);
		System.out.println("Flipped B: " + flippedB);

		boolean odd = isMostlyOdd(numbers); // returns false
		System.out.println("Is mostly odd: " + odd);
		odd = isMostlyOdd(new int[] { 3, 4, 7, 7, 9 }); // returns true
		System.out.println("Is mostly odd: " + odd);

		String half = firstHalf("Helloworld"); // returns Hello
		System.out.println("first half " + half);
		half = firstHalf("Salad"); // returns Sal
		System.out.println("first half " + half);

		half = secondHalf("Helloworld"); // returns world
		System.out.println("second half " + half);
		half = secondHalf("Salad"); // returns ad
		System.out.println("second half " + half);
	}

	/*
	 * You get to fill in the methods below...
	 */

	private static String secondHalf(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String firstHalf(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean isMostlyOdd(int[] numbers) {
		// TODO Auto-generated method stub
		return false;
	}

	private static double flipDouble(double d) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int[] reverseArray(int[] numbers) {
		// TODO Auto-generated method stub
		return null;
	}

	private static float getAverage(int[] numbers) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int getSecondToLastItem(int[] numbers) {
		// TODO Auto-generated method stub
		return 0;
	}

}
