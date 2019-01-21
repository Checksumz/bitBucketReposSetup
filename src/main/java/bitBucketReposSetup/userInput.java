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
	private String localRepoDir;
	private String repoRootURL;
	private URL url;
	
	
    private static final Logger logger = LogManager.getLogger(userInput.class);
    
    public URL createBitbucketProjUrl (String repoRootURL, String bitBucketProjName) {
		// TODO Auto-generated method stub
    	try {
			url = new URL(repoRootURL+"/rest/api/1.0/projects/"+bitBucketProjName+"/repos");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return url;
	}
    
	public userInput getUserInput() {
		
		try(Scanner in = new Scanner(System.in)){

			//get user details
					 
			System.out.println("Please enter root url of bitBucket server:");		
			//ReadableByteChannel in= Channels.newChannel(System.in);
			String repoRootURL= in.nextLine();
			this.setRepoRootURL(repoRootURL);
			
			System.out.println("Please enter name of bitBucket Project :");
			String bitBucketProjName= in.nextLine();
			 
			this.createBitbucketProjUrl(repoRootURL, bitBucketProjName);
			 this.setUrl(url);
			 System.out.println("Please enter name of local dir to create/update the local copy(eg:C:\\Users\\reposTest\\):");
			 localRepoDir=in.nextLine();
			 this.setLocalRepoDir(localRepoDir);
			 
			 System.out.println("Please enter your bitBucket username:");
			 uid=in.nextLine();
			 this.setUid(uid);
			 
			 System.out.println("Please enter your bitBucket pwd:");
			 pwd=in.nextLine();
			 this.setPwd(pwd);
			 
			 
			 
		} catch (Exception e) {
			
			logger.debug(e.getStackTrace());
		}
		return this;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getLocalRepoDir() {
		return localRepoDir;
	}

	public void setLocalRepoDir(String localRepoDir) {
		this.localRepoDir = localRepoDir;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getRepoRootURL() {
		return repoRootURL;
	}

	public void setRepoRootURL(String repoRootURL) {
		this.repoRootURL = repoRootURL;
	}


	
	
}
