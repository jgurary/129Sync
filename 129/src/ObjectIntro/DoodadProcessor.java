package ObjectIntro;

public class DoodadProcessor {

	private Doodad[] doodads = new Doodad[10];
	/**
	 * Tracks the next available index where we can insert a Doodad
	 */
	private int nextDoodad = 0;

	/**
	 * Create a Doodad Processor that has ten Doodads with values and secretValue
	 * between the low and high range, chosen randomly. <br>
	 * <br>
	 * Name is assigned a random capital letter from A to Z.
	 * 
	 * @param low
	 * @param high
	 */
	public DoodadProcessor(int low, int high) {
		String AtoZ = "ABCDEFGHIJKLMNOPQRTUVWXYZ";
		for (int i = 0; i < doodads.length; i++) {
			/*
			 * Picks a random letter from the alphabet we specified above
			 */
			char name = AtoZ.charAt((int) (Math.random() * AtoZ.length()));
			String nameAsString = Character.toString(name);
			/*
			 * For getting a range between low and high, remember: random 0 to 1 * (high -
			 * low) + low
			 */
			int value = (int) (Math.random() * (high - low) + low);
			int secretValue = (int) (Math.random() * (high - low) + low);

			doodads[i] = new Doodad(nameAsString, value, secretValue);
			nextDoodad++;
		}
	}

	/**
	 * Creates a Doodad Processor that has an empty array of Doodads (all null)
	 */
	public DoodadProcessor() {

	}

	/**
	 * Creates a Doodad Processor using the specified array of Doodads. Sets the
	 * next spot to the last index by default (no spots available)
	 * 
	 * @param doods
	 */
	public DoodadProcessor(Doodad[] doods) {
		this.doodads = doods;
		nextDoodad = doods.length - 1;
	}

	/**
	 * Creates a Doodad Processor using the specified array of doodads. Sets the
	 * next spot to the specified value
	 * 
	 * @param doods
	 */
	public DoodadProcessor(Doodad[] doods, int nextDoodad) {
		this.doodads = doods;
		this.nextDoodad = nextDoodad;
	}

	/**
	 * Add a Doodad to the array, if there is room. If there is not room, prints an
	 * error and does nothing
	 * 
	 * @param toAdd
	 */
	public void addDoodad(Doodad toAdd) {
		if (nextDoodad + 1 < doodads.length) {
			doodads[nextDoodad] = toAdd;
			nextDoodad++;
		} else { // there's no room, print an error
			System.err.println("Doodad Processor is full!");
		}
	}

	/**
	 * Removes a Doodad from the array by object reference
	 * 
	 * @param toRemove
	 */
	public void removeDoodad(Doodad toRemove) {
		for (int i = 0; i < doodads.length; i++) {
			if (doodads[i] == toRemove) {
				// Empty out a spot in the array...
				doodads[i] = null;
			}
		}
	}

	/**
	 * Removes all Doodads with a matching name in the array
	 * 
	 * @param nameToRemove
	 */
	public void removeDoodad(String nameToRemove) {
		for (int i = 0; i < doodads.length; i++) {
			if (doodads[i] != null && doodads[i].name.equals(nameToRemove)) {
				// Empty out a spot in the array...
				doodads[i] = null;
			}
		}
	}

	/**
	 * Get the sum of the value of all Doodads in the array
	 * 
	 * @return
	 */
	public int getSum() {
		int sum = 0;
		for (int i = 0; i < doodads.length; i++) {
			if (doodads[i] != null) {
				sum += doodads[i].value;
			}
		}
		return sum;
	}

}
