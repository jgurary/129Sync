package InterfaceIntro;

public class Car implements Ignition, Engine {

	private boolean isRunning = false;

	@Override
	public void crank(int power) {
		if (power > 5) {
			start();
		}
	}

	@Override
	public void start() {
		System.out.println("vrooom");
		isRunning = true;
	}

	@Override
	public void stop() {
		System.out.println("not vrooom");
		stopEngine();
	}

	@Override
	public boolean checkRunning() {
		return isRunning;
	}

	@Override
	public void stopEngine() {
		isRunning = false;
	}

}
