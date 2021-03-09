package HW2Solution;

public class Palette {

	CustomColor[] colors = new CustomColor[5];

	/**
	 * Creates a new Palette that's all white (255, 255, 255)
	 */
	public Palette() {
		for (int i = 0; i < colors.length; i++) {
			colors[i] = new CustomColor(255, 255, 255);
		}
	}

	/**
	 * Creates a new Palette using a given array of colors (should be length 5
	 * exactly)
	 * 
	 * @param colors - a length 5 array of colors
	 */
	public Palette(CustomColor[] colors) {
		this.colors = colors;
	}

	public Palette(CustomColor first, CustomColor last) {
		/*
		 * first first blended with the one below first blended with last last blended
		 * with that ^ last
		 */
		colors[0] = first;
		colors[4] = last;
		colors[2] = first.blend(last);
		colors[1] = first.blend(colors[2]);
		colors[3] = last.blend(colors[2]);
	}

	public void printPalette() {
		for (int i = 0; i < colors.length; i++) {
			System.out.println(colors[i].toString());
		}
		System.out.println();
	}

}
