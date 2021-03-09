package Quiz1Review;

public class Record {

	private String entry;

	private int length;

	private static int numRecords = 0;

	public Record(String entry) {
		this.entry = entry;
		this.length = entry.length();
		numRecords++;
	}

	public void setEntry(String s) {
		entry = s;
		length = s.length();
	}

	public String getEntry() {
		return entry;
	}

	public int length() {
		return length;
	}

	public static int getNumRecords() {
		return numRecords;
	}

}
