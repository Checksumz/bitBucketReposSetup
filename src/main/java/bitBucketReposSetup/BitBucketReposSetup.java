package main.java.bitBucketReposSetup;

import java.io.BufferedReader;
import java.io.IOException;
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
		
		String reqMthd="GET";
		String jsonRepoList="";		
		HttpURLConnection conn =null;
		ConnectionFactory connFact= new ConnectionFactory();
		conn = connFact.createHttpConnectionBitBucket(input.getUrl(),
				input.getUid(), input.getPwd(), reqMthd);
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
				
				System.out.println("proj.getLimit() "+proj.getLimit());
				System.out.println("proj.getValues().length "+proj.getValues().length);
				System.out.println("proj.getValues().get(1).getName() "+proj.getValues()[1].getName());
				


			for(int i=0;i<proj.getValues().length;i++) {
				
				String repoName = proj.getValues()[i].getName();
				String projName = proj.getValues()[i].getProject().getKey();
				String cloneUrl = proj.getValues()[i].getLinks().getRepoCloneUrl("http");
			
				logger.info(repoName);
//				CloneRepo cR=new CloneRepo();
//				cR.cloneFullRepo(r.getRepoName(), r.getRepoCloneUrl("http"), uid, pwd, LocalRepoDir+bBP.getProjectName()+"\\"+r.getRepoName());
				
				PullRepos pR= new PullRepos();			
				pR.pullLatestRepoVer(repoName, cloneUrl,
						input.getUid(), input.getPwd(), 
						input.getLocalRepoDir()+"\\"+projName+"\\"+repoName+"\\"+".git");
				
				
				//System.out.println(System.getProperty("user.dir"));
				System.out.println("Finished creating local repo: "+repoName);

				
					
				
					
			}
			
		
			connFact.closeConnections(conn);
	
	}

}
