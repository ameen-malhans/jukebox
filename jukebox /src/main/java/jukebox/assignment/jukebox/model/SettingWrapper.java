package jukebox.assignment.jukebox.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about Setting Wrapper")
public class SettingWrapper {

	@ApiModelProperty(notes = "List of all settings")
	private List<Setting> settings = new ArrayList<>();

	public List<Setting> getSettings() {
		return settings;
	}

	public void setSettings(List<Setting> settings) {
		this.settings = settings;
	}

}
