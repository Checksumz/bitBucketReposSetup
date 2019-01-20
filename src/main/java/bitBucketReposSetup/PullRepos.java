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
	
	public void pullLatestRepoVer(String repoName, String repoUri, String userName, String pwd, String localDirectoryPath) {
// pull latest version from origin then pull latest development branch, merge master to current development branch	
		try {
			
			System.out.println("local repo path "+localDirectoryPath);		
		
			FileSystem fileSystem = FileSystems.getDefault();
			Path localRepoPath = fileSystem.getPath(localDirectoryPath);
			//Paths.get(uri)
			if(Files.notExists(localRepoPath)) {	
				System.out.println("Local Repo"+ repoName+" does not exist");
				return;
			}
				
			Repository localRepo= new FileRepository(localDirectoryPath);				
			Git git= new Git(localRepo);
			
			//git pull master
			System.out.println("checkout master branch");
			git.checkout().setName("master").call();
			
			System.out.println("pull master branch");
			git.pull().setCredentialsProvider(new UsernamePasswordCredentialsProvider(userName, pwd)).setRemote("origin").setRemoteBranchName("master").call();
			
			System.out.println("git pull toString result"+
			git.pull().setCredentialsProvider(new UsernamePasswordCredentialsProvider(userName, pwd)).setRemote("origin").setRemoteBranchName("master").call().toString());			

			
			ObjectId mergeBase = localRepo.resolve("HEAD");
			
			System.out.println("ccheckout Development branch ");
			git.checkout().setName("Development").call();
			
			System.out.println("pulling Development branch ");
			git.pull().setCredentialsProvider(new UsernamePasswordCredentialsProvider(userName, pwd)).setRemote("origin").setRemoteBranchName("ADP_Development").call();
			
			System.out.println("git pull toString result"+
			git.pull().setCredentialsProvider(new UsernamePasswordCredentialsProvider(userName, pwd)).setRemote("origin").setRemoteBranchName("ADP_Development").call().toString());
			
			MergeResult  merge = git.merge().include(mergeBase).setMessage("Merge master to branch Development").call();
			
            System.out.println("Merge-Results for id: " + mergeBase + ": " + merge);
			
			
			git.close();
		
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		} catch (WrongRepositoryStateException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		} catch (InvalidRemoteException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		} catch (CanceledException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		} catch (RefNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		} catch (RefNotAdvertisedException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			e.printStackTrace();
		}
	}
}
