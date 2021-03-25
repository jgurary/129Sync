package AlmostLiskovExample;

public abstract class Bird extends FlyingThing {

	boolean isEaten = false;

	public Bird(int startingAltitude, int altitudePerFly) {
		super(startingAltitude, altitudePerFly);
	}

	/**
	 * Bird walks
	 * 
	 * @return steps
	 */
	int walk() {
		System.out.println("step step");
		return 2;
	}

	abstract void birdCall();

}
