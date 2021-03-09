package Pets;

import Pets.Pet.PetType;

public class Driver {

	public static void main(String[] args) {
		Pet elpenguino = new Pet(Pet.PetType.PENGUIN, "Mr. Waddles");
		// If you don't want to have to type "Pet" before every time you use the enum,
		// you need to import it from the Pets class
		Pet elgato = new Pet(PetType.CAT, "Mr. Fluffins");
		Pet elmonke = new Pet(Pet.PetType.MONKE, "Mr. Pib");

		elpenguino.doTrick();
		elgato.doTrick();
		elmonke.doTrick();

		System.out.println(elgato.name);
		elgato.name = "Kitty";
		System.out.println(elgato.name);

	}

}
