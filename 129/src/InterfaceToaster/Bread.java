package InterfaceToaster;

public class Bread implements Toastable {

	private boolean isToast = false;

	@Override
	public boolean getToasted() {
		return isToast;
	}

	@Override
	public void toast() {
		isToast = true;
	}

	@Override
	public Poptart getPoptart() {
		return null;
	}

}
