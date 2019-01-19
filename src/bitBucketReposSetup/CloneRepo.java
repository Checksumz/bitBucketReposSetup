package bitBucketReposSetup;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class CloneRepo {

	public void cloneFullRepo(String repoName, String repoUri, String userName, String pwd, String localDirectoryPath) {
		
		
		try {
			Git.cloneRepository().setURI(repoUri).setCredentialsProvider(new UsernamePasswordCredentialsProvider(userName, pwd)).setDirectory(new File(localDirectoryPath))
			.setCloneAllBranches(true).call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//public void 
}
