package redGateAssessment.wordCount;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import redGateAssessment.characterReader.ICharacterReader;

/**
 * This class takes an input from a class that implements the ICharacterReader
 * interface and produces an array with both each word that comes from the input
 * characters and the number of times it appears.
 * 
 * @author Chris Cardus
 */
public class WordCounter {
	private ArrayList<Word> wordCount;
	private String wordBuilder;
	private Comparator<Word> sortAssistAlpha;
	private Comparator<Word> sortAssistNum;

	/**
	 * Constructs a word counter object with an array to store the number of
	 * times each word appears.
	 * 
	 * @param iChar
	 *            The ICharacterReader object which supplies this class with the
	 *            character inputs.
	 */
	public WordCounter(ICharacterReader iChar) {
		wordCount = new ArrayList<Word>();
		wordBuilder = "";

		// This comparator is to sort alphabetically.
		// This was a vital influence to my solution as it allowed me to use
		// binary search.
		// This improved the time complexity of my algorithm a lot.
		sortAssistAlpha = new Comparator<Word>() {

			@Override
			public int compare(Word w1, Word w2) {
				String o1 = w1.getWord();
				String o2 = w2.getWord();

				if (o1.compareToIgnoreCase(o2) == 0) {
					return 0;

				} else if (o1.compareToIgnoreCase(o2) > 0) {
					return 1;

				} else {
					return -1;

				}
			}
		};

		// I initially implemented the comparable interface on the Word class in
		// order to sort each Word object alphabetically.
		// Using two comparators however allowed me to sort them numerically so
		// that the output matched the task.
		sortAssistNum = new Comparator<Word>() {

			@Override
			public int compare(Word w1, Word w2) {
				int o1 = w1.getCounter();
				int o2 = w2.getCounter();

				if (o1 == o2) {
					return 0;

				} else if (o1 > o2) {
					return -1;

				} else {
					return 1;

				}
			}
		};

		try {
			while (true) {
				char i = iChar.GetNextChar();
				if (Character.isLetter(i)) {
					wordBuilder += i;

				} else {
					checkWord();

				}

			}
		} catch (EOFException e) {
			checkWord();
			iChar.Dispose();

		}
	}

	/**
	 * Checks whether or not a given word is already in an array. If the word
	 * already appears, it will add one to the word count for that word. If the
	 * word does not appear, it will add that word to the array.
	 */
	private void checkWord() {
		if (wordBuilder != "") {
			Word newWord = new Word(wordBuilder.toLowerCase());

			// The main decision I had to make was how to store the words.
			// I chose to do this with an array and sort it every time new data
			// is to be entered in order to try and keep the time complexity
			// down.
			// It would have most likely been more efficient to achieve this
			// using a Binary Search Tree (BST)
			// however I have not finished learning about how to implement a
			// BST.
			Collections.sort(wordCount, sortAssistAlpha);
			int searchResult = Collections.binarySearch(wordCount, newWord, sortAssistAlpha);

			if (searchResult >= 0) {
				wordCount.get(searchResult).addOne();
				wordBuilder = "";

			} else {
				wordCount.add(newWord);
				wordBuilder = "";

			}
		}
	}

	/**
	 * Returns a string object which stores the information from the wordCount
	 * array in a structured manor.
	 * 
	 * @return The string object.
	 */
	public String toString() {
		Collections.sort(wordCount, sortAssistNum);
		String toString = "";

		for (int i = 0; i < wordCount.size(); i++) {
			toString += wordCount.get(i) + "\n";

		}
		return toString;

	}

	public int testInt() {
		return wordCount.get(0).getCounter();
	}

	public ArrayList<Word> testArray() {
		return wordCount;
	}
}
