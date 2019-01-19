package main.java.bitBucketReposSetup;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

class userInputTest {

	private userInput testClass;
	
	@Before
	public void setUp() throws Exception {
		testClass = new userInput();
	}
	
	@Test
	public void testRepoRootURL() {
		assertTrue(testClass.getUserInput().get("repoRootURL").matches("^(?:http(s)?:\\/\\/)?[\\w.-]+(?:\\.[\\w\\.-]+)+[\\w\\-\\._~:/?#[\\]@!\\$&'\\(\\)\\*\\+,;=.]+$"));
		//fail("Not yet implemented");
	}

}
