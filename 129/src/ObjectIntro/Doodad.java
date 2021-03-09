package ObjectIntro;

public class Doodad {

	/**
	 * The name of this Doodad
	 */
	public String name;

	/**
	 * The value of this Doodad
	 */
	public int value;

	/**
	 * The secret value of this Doodad (different from {@link #value})
	 */
	private int secretValue;

	/**
	 * The initial value of {@link #value} when this Doodad is first created
	 */
	private int initialValue;

	/**
	 * A value shared by all Doodads in the world
	 */
	public static int sharedValue = 2;

	/**
	 * Creates a new Doodad with the specified name, value, and secretValue
	 * 
	 * @param name
	 * @param value
	 * @param secret - a value that only this Doodad can see
	 */
	public Doodad(String name, int value, int secret) {
		this.name = name;
		this.value = value;
		this.setSecretValue(secret);
		this.initialValue = value;
	}

	public int getInitialValue() {
		return initialValue;
	}

	public int getSecretValue() {
		return secretValue;
	}

	public void setSecretValue(int secretValue) {
		if (secretValue > value) {
			this.secretValue = secretValue;
		} else {
			System.out.println("Didn't update secret for " + this.name);
		}
	}

}
