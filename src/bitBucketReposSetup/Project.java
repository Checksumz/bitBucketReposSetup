package bitBucketReposSetup;

public class Project {
	private String key;
	private int id;
	private String name;
	private String description;
	private boolean publicDescriptor;
	private String type;
	private Links links;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPublicDescriptor() {
		return publicDescriptor;
	}
	public void setPublicDescriptor(boolean publicDescriptor) {
		this.publicDescriptor = publicDescriptor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}

	
}
