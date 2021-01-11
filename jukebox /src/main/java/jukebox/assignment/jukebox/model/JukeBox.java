package jukebox.assignment.jukebox.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about Jukebox")
public class JukeBox {

	@ApiModelProperty(notes = "unique id")
	private String id;
	@ApiModelProperty(notes = "model name")
	private String model;
	@ApiModelProperty(notes = "components present")
	private List<Component> components = new ArrayList<>();

	public JukeBox() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

}
