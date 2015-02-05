package redGateAssessment.wordCount.unitTests;

import java.io.EOFException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redGateAssessment.characterReader.ICharacterReader;
import redGateAssessment.wordCount.WordCounter;

public class TestWordCounter implements ICharacterReader {
	int position = 0;
	String content = "";
	WordCounter word = new WordCounter(this);

	@BeforeTest
	public void beforeTest() {
		position = 0;
		content = "";

	}

	@Test
	public void testEmptyCase() {
		word = new WordCounter(this);
		Assert.assertEquals(word.toString(), "");
	}

	@Test
	public void testWordCount() {
		content = "one one one one one one one one one one";
		word = new WordCounter(this);
		Assert.assertEquals(word.testInt(), 10);
	}

	@Override
	public char GetNextChar() throws EOFException {
		if (position >= content.length()) {
			throw new EOFException();
		}

		return content.charAt(position++);
	}

	@Override
	public void Dispose() {
	}
}
