package redGateAssessment.wordCount;

/**
 * Stores both a string and a integer denoting the number of times that string
 * appears.
 * 
 * @author Chris Cardus
 *
 */
public class Word {

	private String word;
	private int counter;

	/**
	 * Construct an object with a string and sets the counter to 1.
	 * 
	 * @param word
	 *            The string object.
	 */
	public Word(String word) {
		this.word = word;
		this.counter = 1;

	}

	/**
	 * Returns both the word and counter as a string object.
	 * 
	 * @return The string object.
	 */
	public String toString() {
		return word + " - " + counter;

	}

	/**
	 * Returns the string attribute of the object.
	 * 
	 * @return The string attribute.
	 */
	public String getWord() {
		return word;

	}

	/**
	 * Returns the integer attribute of the object.
	 * 
	 * @return The integer attribute.
	 */
	public int getCounter() {
		return counter;

	}

	/**
	 * Adds one to the integer attribute of the object.
	 */
	public void addOne() {
		counter += 1;

	}
}
