package InterfaceToaster;

public interface Toastable {

	public boolean getToasted();

	/**
	 * Toasts this piece of food
	 */
	public void toast();

	/**
	 * Returns the Poptart attached to this toastable, if there is one
	 * 
	 * @return
	 */
	public Poptart getPoptart();

}
