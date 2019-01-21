package main.java.bitBucketReposSetup;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class CloneRepo {

    private static final Logger logger = LogManager.getLogger(CloneRepo.class);
    
	public void cloneFullRepo(String repoName, String repoUri, String userName, String pwd, String localDirectoryPath) {
		
// clone repos below
		
		try {
			Git.cloneRepository().setURI(repoUri).setCredentialsProvider(new UsernamePasswordCredentialsProvider(userName, pwd)).setDirectory(new File(localDirectoryPath))
			.setCloneAllBranches(true).call();
		} catch (GitAPIException e) {
			logger.error(e.getStackTrace());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//public void 
}
