package Word;

public class Driver {

	public static void main(String[] args) {
		Word fish = new Word("fish", Word.WordType.NOUN);
		Word red = new Word("red", Word.WordType.ADJECTIVE);
		Word blue = new Word("blue", Word.WordType.ADJECTIVE);
		Word definitelyAWord = new Word("snappleberry");

		Word combinedColor = Word.combine(red, blue);
		System.out.println(combinedColor.getText() + " " + combinedColor.type);

		Word combinedWord = Word.combine(combinedColor, definitelyAWord);
		System.out.println(combinedWord.getText() + " " + combinedWord.type);

		Word theBigOne = Word.combine(definitelyAWord, Word.combine(fish, Word.combine(red, blue)));
		System.out.println(theBigOne.getText() + " " + theBigOne.type);
	}

}
