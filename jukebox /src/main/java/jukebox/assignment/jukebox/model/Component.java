package jukebox.assignment.jukebox.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Component Details")
public class Component {

	@ApiModelProperty(notes = "name of component")
	private String name;

	public Component() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
