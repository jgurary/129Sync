package Word;

public class Word {

	private String text;
	private char firstLetter;
	private char lastLetter;

	public enum WordType {
		NOUN, VERB, ADJECTIVE, OTHER
	};

	public WordType type;

	/**
	 * Creates a new word with a specified type
	 * 
	 * @param text
	 * @param type
	 */
	public Word(String text, WordType type) {
		this.text = text;
		firstLetter = text.charAt(0);
		lastLetter = text.charAt(text.length() - 1);
		this.type = type;
	}

	/**
	 * Creates a new word with type "other"
	 * 
	 * @param text
	 */
	public Word(String text) {
		this.text = text;
		firstLetter = text.charAt(0);
		lastLetter = text.charAt(text.length() - 1);
		this.type = WordType.OTHER;
	}

	/**
	 * Combines two words into a new Word, If they have the same type, the new
	 * combined word also has that type, Otherwise the type is "other"
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Word combine(Word first, Word second) {
		if (first.type == second.type) {
			return new Word(first.text + second.text, first.type);
		} else {
			return new Word(first.text + second.text);
		}
	}

	public String getText() {
		return text;
	}

	/**
	 * Returns the text of this word
	 */
	public String toString() {
		return text;
	}

	public char getLastLetter() {
		return lastLetter;
	}

	public char getFirstLetter() {
		return firstLetter;
	}

	/**
	 * Sets the Word's text to the given value, updating first/last character and
	 * setting the type to "other"
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
		firstLetter = text.charAt(0);
		lastLetter = text.charAt(text.length() - 1);
		this.type = WordType.OTHER;
	}

	/**
	 * Sets the Word's text to the given value, also updating first/last character
	 * and type.
	 * 
	 * @param text
	 * @param type
	 */
	public void setText(String text, WordType type) {
		this.text = text;
		firstLetter = text.charAt(0);
		lastLetter = text.charAt(text.length() - 1);
		this.type = WordType.OTHER;
	}

}
