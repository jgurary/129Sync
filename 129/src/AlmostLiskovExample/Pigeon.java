package AlmostLiskovExample;

public class Pigeon extends Bird {

	public Pigeon(int startingAltitude) {
		super(startingAltitude, 5);
	}

	@Override
	void birdCall() {
		System.out.println("Meep");
	}

}
