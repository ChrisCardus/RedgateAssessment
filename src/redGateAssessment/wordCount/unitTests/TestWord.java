package redGateAssessment.wordCount.unitTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import redGateAssessment.wordCount.Word;

public class TestWord {

	Word test = new Word("Hello World");

	@Test
	public void testToString() {
		Assert.assertEquals(test.toString(), "Hello World - 1");
	}

	@Test
	public void testGetWord() {
		Assert.assertEquals(test.getWord(), "Hello World");
	}

	@Test
	public void testGetCounter() {
		Assert.assertEquals(test.getCounter(), 1);
	}

	@Test
	public void testAddOne() {
		Word test2 = new Word("The rain in spain falls mainly on the plain");
		test2.addOne();
		Assert.assertEquals(test2.getCounter(), 2);
	}

}
