package ArrayListIntro;

public class DriverArrayList {

	public static void main(String[] args) {
		RecordManagerArrayList manager = new RecordManagerArrayList();
		manager.insertRecord(new Record("A", 50));
		manager.insertRecord(new Record("B", 50));
		manager.insertRecord(new Record("C", 50));
		manager.insertRecord(new Record("D", 50));
		manager.insertRecord(new Record("E", 50));
		manager.printArray();
		manager.insertRecord(new Record("F", 50));
		manager.printArray();
		manager.insertRecord(new Record("G", 50));
		manager.insertRecord(new Record("H", 50));
		manager.printArray();

		manager.removeRecord("A");

		manager.removeRecord("C");

		manager.printArray();

		manager.insertRecord(new Record("I", 50));
		manager.insertRecord(new Record("J", 50));

		manager.printArray();

	}

}
