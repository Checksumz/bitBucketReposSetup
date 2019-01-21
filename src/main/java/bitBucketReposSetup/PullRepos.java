package main.java.bitBucketReposSetup;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.GitCommand;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefNotAdvertisedException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.attributes.AttributesNodeProvider;
import org.eclipse.jgit.diff.Sequence;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.ObjectDatabase;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.lib.ReflogReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.api.MergeResult;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class PullRepos {

	private static final Logger logger = LogManager.getLogger(PullRepos.class);

	
	public Boolean localRepoCopyExists(String repoName,String localDirectoryPath) {
		
		FileSystem fileSystem = FileSystems.getDefault();
		Path localRepoPath = fileSystem.getPath(localDirectoryPath);
		
		if(Files.notExists(localRepoPath)) {	
			System.out.println("Local Repo "+ repoName+" does not exist");
			logger.error("Local Repo"+ repoName+" does not exist");
			return false;
		}
		return true;
	}
	
		
	public ObjectId pullLatestRepo(String repoName, String repoUri, String userName,
			String pwd, String localDirectoryPath, String remoteName, String branchName) {
		
		ObjectId mergeBase = null;
		Repository localRepo = null;
		
		

		
		try {
			localRepo = new FileRepository(localDirectoryPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		}				
		
		

		
		
		try(Git git= new Git(localRepo)){
			
	//		System.out.println("git.branchList() "+git.getRepository()branchList().call().toString());
			
			try {
				System.out.println("git.branchList().getRepository()" + 
						".getBranch() "+git.branchList().getRepository()
						.getBranch());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			.setContains("ADP_Development"));				
			
			git.checkout().setName(branchName).call();

			git.pull().setCredentialsProvider(new UsernamePasswordCredentialsProvider
					(userName, pwd)).setRemote(remoteName).setRemoteBranchName(branchName)
					.call();
		
//			try {
				 try {
					mergeBase = localRepo.resolve("HEAD");
				} catch (RevisionSyntaxException | IOException e) {
					// TODO Auto-generated catch block
					logger.error(e.getStackTrace());
					e.printStackTrace();
				}
//			} catch (RevisionSyntaxException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			logger.info("git pull toString result"+
					git.pull().setCredentialsProvider(new UsernamePasswordCredentialsProvider
							(userName, pwd)).setRemote(remoteName).setRemoteBranchName(branchName)
					.call().toString());
			
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		}
					
		return mergeBase;
	}
	
	public void mergeRepos(String repoName, String repoUri, String userName, 
			String pwd, String localDirectoryPath, String branchName, 
			ObjectId mergeBase) {
		
		Repository localRepo = null;
		

		
		
		try {
			localRepo = new FileRepository(localDirectoryPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		}
		
		try(Git git= new Git(localRepo)){
		
		MergeResult  merge = git.merge().include(mergeBase).setMessage
				("Merge master to branch "+branchName).call();
				
		logger.info("Merge-Results for id: " + mergeBase + ": " + merge);
		}
		 catch (GitAPIException e) {
				// TODO Auto-generated catch block
				logger.error(e.getStackTrace());
				e.printStackTrace();
			}
	}
	
	public void pullLatestRepoVer(String repoName, String repoUri, String userName,
			String pwd, String localDirectoryPath) {
// pull latest version from origin then pull latest development branch, merge master to current development branch	
		
		String remote="origin";
		String branchName="master";
		
		if (this.localRepoCopyExists(repoName, localDirectoryPath)==false) {
			return;
		}
		
		ObjectId mergeBaseMaster = this.pullLatestRepo(repoName, repoUri, userName, 
				pwd, localDirectoryPath, remote, branchName);
		
		 remote="origin";
		 branchName="ADP_Development";
		
		ObjectId mergeBaseBranch = this.pullLatestRepo(repoName, repoUri, userName, 
				pwd, localDirectoryPath, remote, branchName);
		
		this.mergeRepos( repoName,  repoUri,  userName, pwd,  localDirectoryPath,
				branchName, mergeBaseMaster);
	
		
	}
}
