package Pets;

public class Pet {

	public enum PetType {
		CAT, MONKE, PENGUIN
	}

	private PetType type;
	public String name;

	/**
	 * Creates a Pet with the designated type and name
	 * 
	 * @param type
	 * @param name
	 */
	public Pet(PetType type, String name) {
		this.type = type;
		this.name = name;
	}

	/**
	 * Prints a message to the console depending on the animal's type. Supported
	 * types: {@link #type}
	 */
	public void doTrick() {
		switch (type) {
		case CAT:
			System.out.println("*Knocks something over*");
			break;
		case MONKE:
			System.out.println("*Invents society*");
			break;
		case PENGUIN:
			System.out.println("*Does a sick belly flop*");
			break;
		default:
			break;
		}
	}

	/**
	 * Returns the pet type, {@link Pet#type}
	 * 
	 * @return
	 */
	public PetType getType() {
		return type;
	}

}
