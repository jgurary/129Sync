package HW2Solution;

public class CustomColor {

	public int red, green, blue;
	public static final float DARKEN_FACTOR = .8f;
	public static final float LIGHTEN_FACTOR = 1.2f;

	/**
	 * Creates a new Color with the specified red, green, and blue values. Prints an
	 * error if the any values are smaller than 0 or larger than 255, but proceeds
	 * anyways
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 */
	public CustomColor(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;

		if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
			System.err.println("Not a valid color! " + this.toString());
		}
	}

	/**
	 * Returns a color that is the average rgb values of this color and the color
	 * specified in the argument
	 * 
	 * @param other
	 * @return
	 */
	public CustomColor blend(CustomColor other) {
		return new CustomColor((other.red + this.red) / 2, (other.green + this.green) / 2,
				(other.blue + this.blue) / 2);
	}

	/**
	 * Returns a color that is the average rgb values of the first color and second
	 * colors specified in the arguments
	 * 
	 * @param other
	 * @return
	 */
	public static CustomColor blend(CustomColor first, CustomColor second) {
		return new CustomColor((second.red + first.red) / 2, (second.green + first.green) / 2,
				(second.blue + first.blue) / 2);
	}

	/**
	 * Returns a darker version of this color <br>
	 * Multiplies this color's r, g, and b values by {@link #DARKEN_FACTOR} and
	 * returns the resulting color
	 * 
	 * @return
	 */
	public CustomColor darken() {
		return new CustomColor((int) (red * DARKEN_FACTOR), (int) (green * DARKEN_FACTOR),
				(int) (blue * DARKEN_FACTOR));
	}

	/**
	 * Returns a lighter version of this color <br>
	 * Multiplies this color's r, g, and b values by {@link #LIGHTEN_FACTOR} and
	 * returns the resulting color
	 * 
	 * @return
	 */
	public CustomColor lighten() {
		int newRed = (int) (red * LIGHTEN_FACTOR);
		if (newRed > 255) {
			newRed = 255;
		}

		int newGreen = (int) (green * LIGHTEN_FACTOR);
		if (newGreen > 255) {
			newGreen = 255;
		}

		int newBlue = (int) (blue * LIGHTEN_FACTOR);
		if (newBlue > 255) {
			newBlue = 255;
		}

		return new CustomColor(newRed, newGreen, newBlue);
	}

	/**
	 * Returns true if this color is lighter than the one given in the argument,
	 * false otherwise
	 * 
	 * @param other
	 * @return
	 */
	public boolean isLighter(CustomColor other) {
		if (this.red + this.green + this.blue > other.red + other.green + other.blue) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Prints this color in the form "Color with R: red G: green B: blue", where
	 * red, green, and blue are the color values respectively
	 */
	public String toString() {
		return "Color with R: " + red + " G: " + green + " B: " + blue;
	}

}
