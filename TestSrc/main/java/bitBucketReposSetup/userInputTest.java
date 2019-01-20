package main.java.bitBucketReposSetup;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class userInputTest {

	private userInput testClass;

	@Before
	public void berfore() {
		testClass = new userInput();
		testClass.getUserInput();
	}
	
	@Test
	public void testRepoRootURL() {
		System.out.println(testClass.getRepoRootURL());
		assertTrue(testClass.getRepoRootURL().matches("^(?:http(s)?:\\/\\/)?[\\w.-]+(?:\\.[\\w\\.-]+)[\\w-\\._~:\\/\\?#\\[\\]@!\\$&'\\(\\)\\*\\+,;=\\.]+$"));
	}
	
	@Test
	public void testLocalRepoDir() {	
		System.out.println(testClass.getLocalRepoDir());
		assertTrue(testClass.getLocalRepoDir().matches("^[a-zA-Z]:[\\s|*\\s]?.*$"));		
	}

}
