package InterfaceIntro;

public class Driver {

	public static void main(String[] args) {
		Car car = new Car();
		Car otherCar = new Car();
		car.crank(10);
		System.out.println(car.checkRunning());
		car.stop();
		System.out.println(car.checkRunning());

	}

}
