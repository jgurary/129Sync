package InterfaceToaster;

public interface Slot {

	public void insertToastable(Toastable t);

	public Toastable remove(int slotNum);

	/**
	 * Toasts everything inside this object's slots
	 */
	public void toast();

}
