package WordGame;

public abstract class Word {

	private String text;
	private char firstLetter;
	private char lastLetter;

	public Word(String text) {
		setText(text);
	}

	public char getFirstLetter() {
		return firstLetter;
	}

	public char getLastLetter() {
		return lastLetter;
	}

	/**
	 * Updates the text of the word to the given String, updates other values
	 * accordingly
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
		firstLetter = text.charAt(0);
		lastLetter = text.charAt(text.length() - 1);
	}

	/**
	 * Returns the length of this word's underlying text
	 * 
	 * @return
	 */
	public int length() {
		return text.length();
	}

}
