package jukebox.assignment.jukebox.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Setting {
	
	private String id;
	private List<String> requires = new ArrayList<>();

	
	public Setting() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getRequires() {
		return requires;
	}

	public void setRequires(List<String> requires) {
		this.requires = requires;
	}


	
	

	
}
