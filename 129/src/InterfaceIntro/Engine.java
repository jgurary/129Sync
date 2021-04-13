package InterfaceIntro;

public interface Engine {
	/*
	 * We can't do this because all fields on an interface are automatically static
	 * and final! Interface fields are shared by all objects that implement them.
	 */
//	public static final boolean isRunning = false;

	/**
	 * Returns true if the engine has been started
	 * 
	 * @return
	 */
	public boolean checkRunning();

	/**
	 * Stops the engine
	 */
	public void stopEngine();

}
