package jukebox.assignment.jukebox.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about Settings")
public class Setting {

	@ApiModelProperty(notes = "unique setting id")
	private String id;
	@ApiModelProperty(notes = "components required for enabling this setting")
	private List<String> requires = new ArrayList<>();

	public Setting() {
	}

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
