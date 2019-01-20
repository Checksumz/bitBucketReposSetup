package main.java.bitBucketReposSetup.JsonToJavaObjPojo;

import java.util.HashMap;
import java.util.Map;

 public class Links {	
	

	private Self[] self;
	private Clone[] clone;
	Map<String, String> RepoCloneUrl= new HashMap<>();
	
	
	public Links() {
		// TODO Auto-generated constructor stub
		if (this.clone!=null) {
			for (Clone repoCloneUrl : clone) {
				this.setRepoCloneUrl(repoCloneUrl.getName(),
						repoCloneUrl.getHref());
			}
			
		}
	}
	
	public String getRepoCloneUrl(String connString) {		
		return RepoCloneUrl.get(connString);
	}
	public void setRepoCloneUrl(String connType,String repoCloneUrl) {
		this.RepoCloneUrl.put(connType, repoCloneUrl);		
	}
	
	public Self[] getSelf() {
		return self;
	}
	public void setSelf(Self[] self) {
		this.self = self;
	}
	public Clone[] getClone() {
		return clone;
	}
	public void setClone(Clone[] clone) {
		this.clone = clone;
	}

	@Override
	public void finalize() {
		
	}
}
