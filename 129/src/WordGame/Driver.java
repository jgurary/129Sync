package WordGame;

public class Driver {

	public static void main(String[] args) {
		Word cat = new Noun("cat");
		System.out.println(cat.length());
		System.out.println(cat.getFirstLetter());
		cat.setText("dog");
		System.out.println(cat.getFirstLetter());

		/*
		 * I got my money CS129 aquarium
		 */
		Word[] sentence = new Word[] { new Noun("I"), new Verb("got"), new Adjective("my"), new Noun("money"),
				new Noun("CS129"), new Noun("aquarium") };

		int lengthTotal = 0;
		for (int i = 0; i < sentence.length; i++) {
			lengthTotal += sentence[i].length();
		}
		System.out.println(lengthTotal);

		char[] firstLetters = new char[sentence.length];

	}

}
