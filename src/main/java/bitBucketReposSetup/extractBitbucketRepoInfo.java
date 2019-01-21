package main.java.bitBucketReposSetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jsoniter.JsonIterator;

import main.java.bitBucketReposSetup.JsonToJavaObjPojo.bitBucketProject;

public class extractBitbucketRepoInfo {

	private static final Logger logger = LogManager.getLogger(extractBitbucketRepoInfo.class);
	
	public bitBucketProject extractBitbucketInfoFromRest(userInput input, HttpURLConnection conn) {
		
		String jsonRepoList="";	
		String output;
			
				BufferedReader br;
				try {
					br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				while ((output=br.readLine())!=null) {
					jsonRepoList+=output;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e.getStackTrace());
				e.printStackTrace();
			}
			
			logger.info("Bitbucket JSON obj \n"+jsonRepoList);
//	  Deserialize Bitbucket JSON object to Java POJO   
//  	used JSON iterator since it is the fastest JSON parsing library
//			
				bitBucketProject proj = JsonIterator.deserialize(jsonRepoList, bitBucketProject.class);
				
				return proj;
	}
}
