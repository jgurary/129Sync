package ArrayListIntro;

import java.util.ArrayList;
import java.util.Iterator;

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

	// Be careful with this, you may run into exceptions
	/**
	 * Removes the first record from the start with a matching name
	 * 
	 * @param name
	 */
	public void removeRecord(String name) {
		for (int i = 0; i < records.size(); i++) {
			try {
				if (records.get(i).name.equals(name)) {
					records.remove(i);
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Be careful with this, you may run into exceptions
	public void removeRecordAlt(String name) {
		for (Record r : records) {
			try {
				if (r.name.equals(name)) {
					records.remove(r);
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Don't do this, you'll get an exception.
	public void removeAllRecordsAlt(String name) {
		for (Record r : records) {
			try {
				if (r.name.equals(name)) {
					records.remove(r);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * If you need to remove something from an arraylist while looping through it,
	 * do it this way! This is the safe way to avoid
	 * ConcurrentModificationExceptions!
	 */
	public void removeRecordBest(String name) {
		Iterator<Record> itr = records.iterator();
		while (itr.hasNext()) {
			Record next = itr.next();
			if (next.name.equals(name)) {
				itr.remove(); // remove the last item grabbed by "next"
			}
		}
	}

}
