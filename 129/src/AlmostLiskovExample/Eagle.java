package AlmostLiskovExample;

public class Eagle extends Bird {

	public Eagle(int startingAltitude) {
		super(startingAltitude, 20);
	}

	/**
	 * Eats the other bird if this bird is higher up than that one. Can't eat
	 * flightless birds (like penguins)
	 * 
	 * @param other
	 */
	public void eat(Bird other) {
		if (other.altitudePerFly != 0 && this.altitude > other.altitude) {
			other.isEaten = true;
			System.out.println("nom nom");
		}
	}

	@Override
	void birdCall() {
		System.out.println("USA USA");
	}

}
