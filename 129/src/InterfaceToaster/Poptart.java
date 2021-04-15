package InterfaceToaster;

public class Poptart implements Toastable {

	public boolean isToast = false;
	public boolean isStrawberry;

	public Poptart(boolean isStrawberry) {
		this.isStrawberry = isStrawberry;
	}

}
