package ArrayListIntro;

public class RecordManager {

	Record[] records;
	int nextItem = 0;

	public RecordManager(int numRecords) {
		records = new Record[numRecords];
	}

	public void insertRecord(Record r) {
		// if the array has room, insert the item in the next spot
		if (nextItem < records.length) {
			records[nextItem] = r;
			nextItem++;
			return;
		} else { // if array doesn't have room, grow it, then insert item
			System.out.println("Growing the array to a larger size!");
			int size = records.length;
			Record[] newRecords = new Record[(int) (size * 1.5)];
			for (int i = 0; i < size; i++) {
				newRecords[i] = records[i];
			}

			records = newRecords;
			/*
			 * inserts the item one spot after the end of the old array, which is always
			 * empty. Also note that in this implementation, that's the same thing as the
			 * nextItem
			 */
			records[size] = r;
			nextItem++;
			System.out.println("Inserted record " + r.name + " at " + size);
		}

	}

	/**
	 * Like the size method in ArrayList, returns the last non-null index in the
	 * array. Can be used in conjunction with a loop to visit all the items in the
	 * list.
	 * 
	 * @return
	 */
	public int size() {
		return nextItem;
	}

	public Record get(int i) {
		return records[i];
	}

	public void printArray() {
		for (int i = 0; i < size(); i++) {
			if (records[i] != null) {
				System.out.println("[" + i + "]: " + records[i].name);
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
		for (int i = 0; i < records.length; i++) {
			try {
				if (records[i].name.equals(name)) {
					// scoot all the records after this item up to fill the gap
					for (int k = i; k < nextItem; k++) {
						records[k] = records[k + 1];
					}
					nextItem--;
					// TODO if it's preferable, set the old last spot to null
					/*
					 * Note that in this approach, the last item is now duplicated: but the
					 * duplicate sits beyond nextItem, so we can't really access it
					 */
					return;
				}
			} catch (Exception e) {

			}
		}
	}

	/**
	 * Removes all records with a matching name
	 * 
	 * @param name
	 */
	public void removeAllRecords(String name) {
		for (int i = 0; i < records.length; i++) {
			try {
				if (records[i].name.equals(name)) {
					// scoot all the records after this item up to fill the gap
					for (int k = i; k < nextItem; k++) {
						records[k] = records[k + 1];
					}
					nextItem--;
				}
			} catch (Exception e) {

			}
		}
	}

	/**
	 * Returns the sum of the salary of all records
	 * 
	 * @return
	 */
	public int getSumOfSalaries() {
		int sum = 0;
		for (int i = 0; i < records.length; i++) {
			if (records[i] != null) {
				sum += records[i].salary;
			}
		}
		return sum;
	}

}
