package main.java.bitBucketReposSetup;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.TestClass;

public class userInputTest {

	private userInput testClass;

	@Before
	public void berfore() {
		testClass = new userInput();

	}
	
	@Test
	public void testRepoUrl() {		
		assertNotNull(testClass.getRepoRootURL());
	}
	
	@Test
	public void testMalformedUrl() {		
//		testClass.createBitbucketProjUrl()
//		ByteArrayInputStream in = new ByteArrayInputStream("malformedUrl.com".getBytes());
//		System.setIn(in);
//		in = new ByteArrayInputStream("malformedUrl.com".getBytes());
//		System.setIn(in);
//		in = new ByteArrayInputStream("".getBytes());
//		System.setIn(in);
//		createBitbucketProjUrl
//		assertNotNull("malformed url exception", testClass.getRepoRootURL());
//		
		
	}
	


}
