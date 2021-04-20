package InterfaceToaster;

public class Toaster implements Slot {

	Toastable[] toastables;

	public Toaster(int numSlots) {
		this.toastables = new Toastable[numSlots];
	}

	/**
	 * Attempts to insert this Toastable item into an available slot. If none exist,
	 * does nothing
	 */
	@Override
	public void insertToastable(Toastable t) {
		for (int i = 0; i < toastables.length; i++) {
			if (toastables[i] == null) {
				toastables[i] = t;
				return;
			}
		}
	}

	@Override
	public void toast() {
		for (Toastable t : toastables) {
			if (t != null) {
				t.toast();
			}

			/*
			 * Works the same as the above in this case!
			 */
//			try {
//				t.toast();
//			}catch(Exception e) {
//				
//			}
		}
	}

	public void printContents() {
		for (Toastable t : toastables) {
			if (t != null) {
				System.out.println(t);
			}
		}
	}

	@Override
	public Toastable remove(int slotNum) {
		Toastable t = toastables[slotNum];
		toastables[slotNum] = null;
		return t;
	}

}
