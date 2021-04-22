package Exceptions;

public class Driver {
	/*
	 * 
	 * a few common ones:
	 * 
	 * catch(IndexOutOfBoundsException out) {
	 * 
	 * }catch(ArithmeticException zero) { //div by zero
	 * 
	 * }catch(NullPointerException nully) {
	 * 
	 * }
	 * 
	 */

	public static void main(String[] args) {
		int x = 5;
		int y = 0;

		System.out.println(divideByZero(x, y));

		outOfBounds();

		getNullStringExample(null);

		multipleExceptionsExample();

	}

	public static void multipleExceptionsExample() {
		String s = null;
		int a = 4, b = 0;
		int c;
		char big;
		char[] chars = new char[] { 'b', 'c', 'd', 'e' };
		String small;
		double rand = Math.random();

		if (rand > .25) {
			s = "cake";
		}
		if (rand > .5) {
			b = 2;
		}

		try {
			small = s.substring(3); // fails if and String isn't set
			c = a / b; // fails if b is set to zero
			big = chars[9];
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Out of bounds!");
			e.printStackTrace();
		} catch (ArithmeticException e) { // div by zero
			c = 2;
			System.err.println(c);
		} catch (NullPointerException e) {
			small = "not cake";
			System.err.println(small);
		} catch (Exception e) {
			System.err.println("Something else!");
			e.printStackTrace();
		}
	}

	// TODO combinations of exceptions: eg divide by zero, null, and out of bounds

	public static String getNullStringExample(String s) {
		try {
			return s.substring(3);
		} catch (Exception e) {
			return null;
		}
	}

	public static void outOfBounds() {
		int[] numbers = new int[5];
		for (int i = 0; i < 10; i++) {
			System.out.print("[" + i + "] ");
			try {
				System.out.println(numbers[i]);
			} catch (Exception e) {
				System.out.println("Exception!");
				break;
			}
		}
	}

	public static int divideByZero(int x, int y) {
		int a;

		try {
			a = x / y;
		} catch (Exception e) {
			a = 2;
		}
		return a;
	}

}
