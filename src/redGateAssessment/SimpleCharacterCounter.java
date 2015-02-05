package redGateAssessment;

import redGateAssessment.characterReader.SimpleCharacterReader;
import redGateAssessment.wordCount.WordCounter;

public class SimpleCharacterCounter {
	public static void main(String[] args) {
		SimpleCharacterReader test = new SimpleCharacterReader();

		WordCounter count = new WordCounter(test);

		System.out.println(count);

	}

}