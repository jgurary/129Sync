package AlmostLiskovExample;

public class Penguin extends Bird {

	public Penguin() {
		super(0, 0);
	}

	public int walk() {
		waddle();
		return 1;
	}

	public void waddle() {
		System.out.println("waddle waddle");
	}

	@Override
	void birdCall() {
		System.out.println("Sqwak");
	}
}
