package Exceptions;

public class Driver {

	public static void main(String[] args) {
		int x = 5;
		int y = 0;

		System.out.println(divideByZero(x, y));

		outOfBounds();

		getNullStringExample(null);

	}

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
