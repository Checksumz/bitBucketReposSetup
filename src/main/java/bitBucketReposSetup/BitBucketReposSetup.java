package main.java.bitBucketReposSetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jsoniter.JsonIterator;

import main.java.bitBucketReposSetup.JsonToJavaObjPojo.Values;
import main.java.bitBucketReposSetup.JsonToJavaObjPojo.bitBucketProject;



public class BitBucketReposSetup {

    private static final Logger logger = LogManager.getLogger(BitBucketReposSetup.class);
    
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
	
//Obtain user input 
		userInput input= new userInput();
		input.getUserInput();
		
		extractBitbucketRepoInfo repoInfo = new extractBitbucketRepoInfo();
		
		
		String reqMthd="GET";			
		HttpURLConnection conn =null;
		conn= new ConnectionFactory().createHttpConnectionBitBucket(input.getUrl(),
				input.getUid(), input.getPwd(), reqMthd);

		bitBucketProject proj = repoInfo.extractBitbucketInfoFromRest(input, conn);
		conn.disconnect();

				
		IntStream.range(0, proj.getValues().length).forEach(
				index-> {
					
					String repoName = proj.getValues()[index].getName();
					String projName = proj.getValues()[index].getProject().getKey();
					String cloneUrl = proj.getValues()[index].getLinks()
										.getRepoCloneUrl("http");
				
					logger.info(repoName);
//							CloneRepo cR=new CloneRepo();
//							cR.cloneFullRepo(r.getRepoName(), r.getRepoCloneUrl("http"), uid, pwd, LocalRepoDir+bBP.getProjectName()+"\\"+r.getRepoName());
					
					PullRepos pR= new PullRepos();			
					pR.pullLatestRepoVer(repoName, cloneUrl,
							input.getUid(), input.getPwd(), 
							input.getLocalRepoDir()+"\\"+projName+"\\"+repoName+"\\"+".git");
					
					
					//System.out.println(System.getProperty("user.dir"));
					System.out.println("Finished creating local repo: "+repoName);
					
					}
				);
		
			
	
	}

}
