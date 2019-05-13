package edu.ycp.cs320.independent_study_hub.model;

public class ResourceBlock {
	private String link, description, by;
	
	public ResourceBlock() {}
	
	public void set_link(String l) {
		link = l;
	}
	
	public void set_description(String d) {
		description = d;
	}
	
	public void set_by(String b) {
		by = b;
	}
	
	public String get_by() {
		return by;
	}
	
	public String get_description() {
		return description
	}
	
	public String get_link() {
		return link;
	}
}
