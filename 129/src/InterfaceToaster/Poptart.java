package InterfaceToaster;

public class Poptart implements Toastable {

	private boolean isToast = false;
	public boolean isStrawberry;

	public Poptart(boolean isStrawberry) {
		this.isStrawberry = isStrawberry;
	}

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
		return this;
	}

}
