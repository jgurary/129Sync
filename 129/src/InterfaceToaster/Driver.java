package InterfaceToaster;

public class Driver {

	public static void main(String[] args) {
		Toaster toaster = new Toaster(2);
		Bread bread = new Bread();
		Poptart poptart = new Poptart(true);
		toaster.insertToastable(bread);
		toaster.insertToastable(poptart);
		toaster.printContents();

		System.out.println("is bread toasted: " + bread.getToasted());

		toaster.toast();

		System.out.println("is bread toasted: " + bread.getToasted());

		Poptart t1 = toaster.remove(1).getPoptart();
		if (t1 != null && t1.isStrawberry) {
			System.out.println("Is strawberry");
		}

		for (int i = 0; i < toaster.toastables.length; i++) {
			try {
				Poptart p = (Poptart) toaster.remove(i);
				System.out.println(p.isStrawberry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("here we are!");

	}

}
