package TheBomb;

public class Driver {

	public static void main(String[] args) {
		Bomb theBomb = new Bomb();
		// Fill in the code to defuse the bomb before it's too late...
		theBomb.readInstructionManual();
		theBomb.cutWire("red");
		theBomb.cutWire("blue");
		theBomb.pushButton();
		theBomb.yeetBomb();
	}

}
