package WordGame;

public class Noun extends Word {

	public Noun(String text) {
		super(text);
	}

	public Word getAnotherWordThatStartsWithTheSameLetter() {
		char first = this.getFirstLetter();
		if (first == 'a') {
			return new Noun("apple");
		} else {
			return new Noun("zebra");
		}
	}

}
