package main.java.bitBucketReposSetup.JsonToJavaObjPojo;

import java.util.HashMap;
import java.util.Map;

public class Values {
	
	private String slug;
	private int id;
	private String name;
	private String scmId;
	private String state;
	private String statusMessage;
	private boolean forkable;
	private Project project; 
	private String publicDescriptor;
	private Links links;
	private String repoName;
	String repoDesc;
//	String repoCloneUrlHttp;
//	String repoCloneUrlSsh;
	String repoPrivacy;
	String repoForkable;
	
//	String repoCloneUrlSsh;
	//String repoName;
	
	public String getRepoName() {
		return repoName;
	}
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
	public String getRepoDesc() {
		return repoDesc;
	}
	public void setRepoDesc(String repoDesc) {
		this.repoDesc = repoDesc;
	}



	public void cloneRepo() {
		
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScmId() {
		return scmId;
	}
	public void setScmId(String scmId) {
		this.scmId = scmId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Project getProjectDetails() {
		return project;
	}
	public void setProjectDetails(Project projectDetails) {
		this.project = projectDetails;
	}
	public String getRepoPrivacy() {
		return repoPrivacy;
	}
	public void setRepoPrivacy(String repoPrivacy) {
		this.repoPrivacy = repoPrivacy;
	}
	public String getRepoForkable() {
		return repoForkable;
	}
	public void setRepoForkable(String repoForkable) {
		this.repoForkable = repoForkable;
	}

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getPublicDescriptor() {
		return publicDescriptor;
	}
	public void setPublicDescriptor(String publicDescriptor) {
		this.publicDescriptor = publicDescriptor;
	}
	public boolean isForkable() {
		return forkable;
	}
	public void setForkable(boolean forkable) {
		this.forkable = forkable;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
}
