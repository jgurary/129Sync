package HW3Solution;

public class Driver {

	public static void main(String[] args) {

		Point origin = new Point(0, 0);
		System.out.println("The origin is at: " + origin.x + " " + origin.y);

		// A 5 by 5 rectangle whose top-left corner is the origin (0, 0)
		Rect alpha = new Rect(0, 0, 5, 5);
		// A 2 by 4 rectangle whose top-left corner is the origin (0, 0)
		Rect beta = new Rect(0, 0, 2, 4);
		System.out.println("beta is a..." + beta.toString());
		System.out.println("The top left corner of beta is at: " + beta.getX() + " " + beta.getY());
		System.out.println("beta is " + beta.getWidth() + " units wide and " + beta.getHeight() + " units tall");
		System.out.println();

		Point oneOne = new Point(1, 1);
		if (alpha.contains(oneOne)) {
			System.out.println("alpha contains oneOne: " + oneOne.toString());
		}
		if (alpha.contains(beta)) {
			System.out.println("alpha contains beta: " + beta.toString());
		}
		System.out.println();

		beta.translate(2, 2);
		System.out.println("beta is a..." + beta.toString());
		System.out.println("The top left corner of beta is at: " + beta.getX() + " " + beta.getY());
		System.out.println("beta is " + beta.getWidth() + " units wide and " + beta.getHeight() + " units tall");
		System.out.println();

		if (alpha.contains(beta)) { // prints nothing, beta is no longer inside alpha...
			System.out.println("alpha still contains: " + beta.toString());
		}

		Rect biggerBeta = beta.scale(2, 4);
		System.out.println("bigger beta is a..." + biggerBeta.toString());
		System.out.println("The top left corner of bigger beta is at: " + biggerBeta.getX() + " " + biggerBeta.getY());
		System.out.println("bigger beta is " + biggerBeta.getWidth() + " units wide and " + biggerBeta.getHeight()
				+ " units tall");
		System.out.println();
//
//		Rect delta = new Rect(3, 3, 6, 3, 3, 5, 6, 5);
//		if (biggerBeta.contains(delta)) {
//			System.out.println("biggerBeta contains delta: " + delta.toString());
//		}
//
//		// (Bonus)
//		Rect notARect = new Rect(3, 3, 4, 5, 3, 5, 6, 5);
//
//		// Watch out for this potential issue....
//		/*
//		 * Note that these rectangles are made using the same points array...
//		 */
//		Point[] somePoints = { new Point(0, 0), new Point(5, 0), new Point(0, 5), new Point(5, 5) };
//		Rect r1 = new Rect(somePoints);
//		Rect r2 = new Rect(somePoints);
//		/*
//		 * 
//		 * 
//		 */
//		r1.translate(2, 2);
//		/*
//		 * Leading to this error here (r2's points got moved as well, because they are
//		 * the same points!)...
//		 */
//		System.out.println(r1.points[Rect.TOP_LEFT].x + " " + r1.points[Rect.TOP_LEFT].y);
//		System.out.println(r2.points[Rect.TOP_LEFT].x + " " + r2.points[Rect.TOP_LEFT].y);
//		System.out.println(r1.getX() + " " + r1.getY());
//		System.out.println(r2.getY() + " " + r2.getX());

	}

}
