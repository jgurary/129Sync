package InterfaceIntro;

public interface Ignition {

	/**
	 * Attempts to crank the engine by turning the key this hard
	 * 
	 * @param power
	 */
	public void crank(int power);

	public void start();

	/**
	 * Turns the key to stop
	 */
	public void stop();

}
