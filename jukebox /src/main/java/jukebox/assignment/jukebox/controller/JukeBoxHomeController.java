package jukebox.assignment.jukebox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import jukebox.assignment.jukebox.model.JukeBox;
import jukebox.assignment.jukebox.service.JukeBoxService;

@RestController
@RequestMapping("/jukebox")
public class JukeBoxHomeController {

	@Autowired
	private JukeBoxService jukeBoxService;

	@GetMapping("/jukeboxes/{settingId}")
	@ApiOperation(value = "Get JukeBoxes By Setting ID", notes = "Provide a setting id to get a paginated list of jukeboxes that suppport a given setting id", response = JukeBox.class, responseContainer = "List")
	public List<JukeBox> getJukeboxes(@PathVariable(value = "settingId") String settingId,
			@RequestParam(value = "model", required = false) String model,
			@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = false) Integer limit) {
		return jukeBoxService.filterJukeBoxes(settingId, model, offset, limit);
	}

}
