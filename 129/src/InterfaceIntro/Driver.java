package InterfaceIntro;

import java.awt.Color;

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		Car car = new Car();
		Car otherCar = new Car();
		car.crank(10);
		System.out.println(car.checkRunning());
		car.stop();
		System.out.println(car.checkRunning());

		Display panel = new Display(800, 800, Color.white);
		JFrame frame = new JFrame("Interface Intro");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

		car.place(100, 300);
		otherCar.place(300, 300);
		car.setColor(Color.blue);
		otherCar.setColor(Color.green);
		ElectricCar eCar = new ElectricCar();
		eCar.place(100, 300);
		eCar.setColor(Color.pink);
		ElectricCar eCarOther = new ElectricCar();
		eCarOther.place(300, 300);
		eCarOther.setColor(Color.orange);

		panel.addDrawable(car);
		panel.addDrawable(otherCar);
		panel.addDrawable(eCar);
		panel.addDrawable(eCarOther);
		panel.getInputHandler().addMoveable(car);
		panel.getInputHandler().addMoveable(otherCar);
		panel.getInputHandler().addMoveable(eCar);
		panel.getInputHandler().addMoveable(eCarOther);
	}

}
