package main.java.bitBucketReposSetup.JsonToJavaObjPojo;

import java.io.IOException;
import java.util.List;

import com.jsoniter.annotation.JsonUnwrapper;
import com.jsoniter.output.JsonStream;

public class bitBucketProject {
	
	private String projectName;
	private String projectDesc;
	private String projectKey;
	
	private int size;
	private int limit;
	boolean isLastPage;
	private Values[] values;
	private int start;
	private int nextPageStart;
	
//	@JsonUnwrapper
//    public void writeName(JsonStream stream) throws IOException {
//        stream.writeObjectField("firstName");
//        stream.writeVal(name.getFirstName());
//        stream.writeMore();
//        stream.writeObjectField("lastName");
//        stream.writeVal(name.getLastName());
//    }
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public String getProjectName() {
		return projectName;
	}
	protected void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	
	public String getProjectKey() {
		return projectKey;
	}
	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getNextPageStart() {
		return nextPageStart;
	}
	public void setNextPageStart(int nextPageStart) {
		this.nextPageStart = nextPageStart;
	}
	public Values[] getValues() {
		return values;
	}
	public void setValues(Values[] values) {
		this.values = values;
	}


	
}
