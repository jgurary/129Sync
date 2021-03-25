package AlmostLiskovExample;

public abstract class FlyingThing {

	int altitude;
	/**
	 * Altitude gained per fly
	 */
	int altitudePerFly;

	public FlyingThing(int startingAltitude, int altitudePerFly) {
		this.altitude = startingAltitude;
		this.altitudePerFly = altitudePerFly;
	}

	/**
	 * Goes higher! Increases {@link #altitude} by {@link #altitudePerFly}
	 */
	void fly() {
		System.out.println("wooooosh");
		altitude += altitudePerFly;
	}

}
