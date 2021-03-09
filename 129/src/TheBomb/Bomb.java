package TheBomb;

public class Bomb {

	public Wire[] wires = { new Wire("red striped"), new Wire("blue solid"), new Wire("pink striped"),
			new Wire("orange and red"), new Wire("ground") };

	private final int RED_STRIPED = 0;
	private final int BLUE_SOLID = 1;
	private final int PINK_STRIPED = 2;
	private final int ORANGE_AND_RED = 3;
	private final int GROUND = 4;

	private boolean isDefused = false;

	/**
	 * Creates a new bomb with red striped, blue solid, pink striped, orange and
	 * red, and ground wires, in that order
	 */
	public Bomb() {

	}

	/**
	 * Prints the Bomb's instruction manual to the console
	 */
	public void readInstructionManual() {
		System.out.println("To defuse, cut all wires containing the color red first. "
				+ "Then cut the blue wire. After those wires are cut, attempt to push the button.");
	}

	/**
	 * Cuts all wires containing the given text in their type
	 * 
	 * @param description
	 */
	public void cutWire(String description) {
		for (int i = 0; i < wires.length; i++) {
			if (wires[i].type.contains(description)) {
				wires[i].cutWire();
			}
		}
		checkBoom();
	}

	/**
	 * Pushes the big shiny button on the bomb. Might be a good idea, might not.
	 */
	public void pushButton() {
		if (wires[RED_STRIPED].checkIsCut() && wires[BLUE_SOLID].checkIsCut() && wires[ORANGE_AND_RED].checkIsCut()) {
			isDefused = true;
			System.out.println("Bomb defused");
		} else {
			boom();
		}
	}

	/**
	 * Yeets the bomb. Explodes if not defused.
	 */
	public void yeetBomb() {
		if (!this.isDefused) {
			boom();
		}
		// no boom...
	}

	/**
	 * Checks if a cut wire has led to everyone exploding
	 */
	private void checkBoom() {
		if (wires[PINK_STRIPED].checkIsCut() || wires[GROUND].checkIsCut()) {
			boom();
		}
		if (wires[BLUE_SOLID].checkIsCut()
				&& (!wires[RED_STRIPED].checkIsCut() || !wires[ORANGE_AND_RED].checkIsCut())) {
			boom();
		}
		// no boom...
	}

	/**
	 * Explodes
	 */
	public void boom() {
		System.out.println("Boom you died.");
	}

}
