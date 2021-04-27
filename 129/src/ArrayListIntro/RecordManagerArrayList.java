package ArrayListIntro;

import java.util.ArrayList;

public class RecordManagerArrayList {

	ArrayList<Record> records = new ArrayList<Record>();

	public RecordManagerArrayList() {

	}

	public void insertRecord(Record r) {
		records.add(r);
	}

	public void printArray() {
		for (int i = 0; i < records.size(); i++) {
			if (records.get(i) != null) {
				System.out.println("[" + i + "]: " + records.get(i).name);
			} else {
				System.out.println("[" + i + "]: null");
			}
		}
		System.out.println();
	}

	/**
	 * Removes the first record from the start with a matching name
	 * 
	 * @param name
	 */
	public void removeRecord(String name) {
		for (int i = 0; i < records.size(); i++) {
			try {
				if (records.get(i).name.equals(name)) {
					records.set(i, null);
					return;
				}
			} catch (Exception e) {

			}
		}
	}

}
