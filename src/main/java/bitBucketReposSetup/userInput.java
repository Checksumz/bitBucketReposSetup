package main.java.bitBucketReposSetup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class userInput {

	private String uid;
	private String pwd;
	private String LocalRepoDir;
	private String url;
	HashMap<String, String> userInput;
	
    private static final Logger logger = LogManager.getLogger(userInput.class);
    
	public Map<String, String> getUserInput() {
		
		try(Scanner in = new Scanner(System.in)){
			System.out.println("Please enter root url of bitBucket server:");		
			//ReadableByteChannel in= Channels.newChannel(System.in);
			String repoRootURL=in.next();
			userInput.put("repoRootURL", repoRootURL);
			System.out.println("Please enter name of bitBucket Project :");
			//String bitBucketProjName= Channels.newChannel(System.in).toString();
			String bitBucketProjName= in.next();
			 //url = new URL(repoRootURL+"/rest/api/1.0/projects/"+bitBucketProjName+"/repos");
			 userInput.put("url", url);
			 System.out.println("Please enter name of local dir to create/update the local copy(eg:C:\\Users\\reposTest\\):");
			 LocalRepoDir=in.next();
			 userInput.put("LocalRepoDir", LocalRepoDir);
			 System.out.println("Please enter your bitBucket username:");
			 uid=in.next();
			 userInput.put("uid", uid);
			 System.out.println("Please enter your bitBucket pwd:");
			 pwd=in.next();
			 userInput.put("pwd", pwd);
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
		}
		return userInput;
	}
	
	
	
}
