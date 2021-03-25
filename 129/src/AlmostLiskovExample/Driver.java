package AlmostLiskovExample;

public class Driver {

	public static void main(String[] args) {
		Eagle eagle = new Eagle(50);

		Bird[] birds = new Bird[10];
		for (int i = 0; i < birds.length; i++) {
			double rand = Math.random();
			if (rand < .5) {
				birds[i] = new Penguin();
			} else {
				birds[i] = new Pigeon((int) (Math.random() * 100));
			}
		}

		for (int i = 0; i < birds.length; i++) {
			birds[i].fly();
		}

		for (int i = 0; i < birds.length; i++) {
			if (birds[i].walk() < 2) {
				System.out.println("This was a penguin");
			}
		}

		eagle.eat(birds[0]);

		for (int i = 0; i < birds.length; i++) {
			birds[i].birdCall();
		}

		eagle.birdCall();

	}

}
