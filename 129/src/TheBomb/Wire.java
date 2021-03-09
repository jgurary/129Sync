package TheBomb;

public class Wire {

	public String type;
	private boolean isCut = false;

	/**
	 * Creates a new wire of the specified type. Wires all start not cut
	 * 
	 * @param type
	 */
	public Wire(String type) {
		this.type = type;
	}

	/**
	 * Cuts the wire.
	 */
	public void cutWire() {
		isCut = true;
	}

	/**
	 * Returns true if this wire is cut
	 * 
	 * @return
	 */
	public boolean checkIsCut() {
		return isCut;
	}

}
