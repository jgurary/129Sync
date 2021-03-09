package JavaReview;

import java.util.Arrays;

public class Driver {

	public static void main(String args[]) {
		int a = 4;
		int b = 5;
		int c = a + b;
		System.out.println(c);
		System.out.println(c + " " + c);

		/*
		 * Wrappers
		 */
		String s1 = Integer.toString(c);
		String s2 = Integer.toString(b);
		String s3 = s1 + s2;
		System.out.println(s3);

		/*
		 * If you do parse on something that's not a number, you'll get an exception
		 */
		int av1 = Integer.parseInt(s3);
		System.out.println(av1);

		long longNumber = Long.MAX_VALUE;

		float f1 = 4.44444444f;
		float f2 = 5f;
		float f3 = f1 + f2;
		System.out.println(f3);
		String floatAsString = Float.toString(f3);
		float f4 = Float.NaN;

		double d1 = 4.4444444;
		double d2 = 5;
		double d3 = d1 + d2;
		System.out.println(d3);

		boolean amIGreat = true;
		boolean amIWise = false;

		if (amIGreat && amIWise) {
			System.out.println("You are great and wise!");
		} else if (amIGreat) {
			System.out.println("You are great!");
		} else if (amIWise) {
			System.out.println("You are wise!");
		} else {
			System.out.println("You are neither great nor wise!");
		}

		if (amIGreat) {
			if (amIWise) {
				System.out.println("You are great and wise!");
			} else {
				System.out.println("You are great!");
			}
		} else {
			if (amIWise) {
				System.out.println("You are wise!");
			} else {
				System.out.println("You are neither great nor wise!");
			}
		}

		amIWise = !amIWise;
		System.out.println(amIWise);

		String someString = "something";
		char someChar = 'a';
		char secondLetter = someString.charAt(someString.length() - 1);
		System.out.println(secondLetter);
		char[] charArray = someString.toCharArray();
		char[] salad = "salad".toCharArray();

		int[] numbers = { 4, 5, 6, 7, 8, 9 };
		int[] otherNumbers = new int[3];
		System.arraycopy(numbers, numbers.length - 3, otherNumbers, 0, 3);
		for (int i = 0; i < otherNumbers.length; i++) {
			System.out.println(otherNumbers[i]);
		}
		String arrayAsString = Arrays.toString(otherNumbers);
		System.out.println(arrayAsString);

		int[] randomNumbers = new int[10];

		for (int i = 0; i < randomNumbers.length; i++) {
			double rand = Math.random();

			int zeroToFifty = (int) (rand * 50);
			int twentyFivetoFifty = (int) (25 + rand * 25);
			randomNumbers[i] = zeroToFifty;
		}
		System.out.println(Arrays.toString(randomNumbers));

		helloWorld();
		helloWorld();

		int x1 = 2;
		int x2 = addTwo(addTwo(addTwo(x1)));
		System.out.println(x2);

		// int x3 = dummy1(x1);

		String aa1 = "aa";
		String aa2 = "aa";
		if (aa1.equals(aa2)) {
			System.out.println("They are the same!");
		}

		float fa = 4.5f;
		float fb = 4.5000001f;
		if (fa == fb) { // don't do this for floats
			System.out.println("They are also the same!");
		}

	}

	static void helloWorld() {
		System.out.println("Hello World!");
	}

	static int addTwo(int x) {
		return x + 2;
	}

	static int dummy1(int x) {
		return dummy2(x);
	}

	static int dummy2(int x) {
		return dummy3(x);
	}

	static int dummy3(int x) {
		return x / 0;
	}

}
