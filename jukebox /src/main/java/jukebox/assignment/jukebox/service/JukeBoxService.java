package jukebox.assignment.jukebox.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jukebox.assignment.jukebox.model.JukeBox;
import jukebox.assignment.jukebox.model.Setting;
import jukebox.assignment.jukebox.model.SettingWrapper;

@Service
public class JukeBoxService {

	@Autowired
	private RestTemplate restTemplate;

	public static final String GET_JUKES = "http://my-json-server.typicode.com/touchtunes/tech-assignment/jukes";
	public static final String GET_SETTINGS = "http://my-json-server.typicode.com/touchtunes/tech-assignment/settings";

	public List<JukeBox> getJukes() {

		JukeBox[] result = restTemplate.getForObject(GET_JUKES, JukeBox[].class);

		return Arrays.asList(result);
	}

	public SettingWrapper getSettings() {

		ResponseEntity<SettingWrapper> result = restTemplate.getForEntity(GET_SETTINGS, SettingWrapper.class);

		return result.getBody();
	}

	
	
	public List<JukeBox> filterJukeBoxes(String settingId, String model, Integer offset, Integer limit) {
		List<JukeBox> filteredJukes = new ArrayList<JukeBox>();

		// call services
		List<JukeBox> jukeBoxes = getJukes();
		SettingWrapper settingWrapper = getSettings();

		// filter setting
		Optional<Setting> settingOpt = settingWrapper.getSettings().stream()
				.filter(setting -> setting.getId().equals(settingId)).findAny();

		if (settingOpt.isPresent()) {

			// get requires
			List<String> requires = settingOpt.get().getRequires();

			final List<JukeBox> filteredJukesFinal = new ArrayList<>();
			// collect jokebox with settings
			jukeBoxes.forEach(juke -> {

				if (model != null && juke.getModel() != null && !model.equals(juke.getModel())) {
					return;
				}

				List<String> componentName = new ArrayList<>();

				juke.getComponents().forEach(component -> {

					componentName.add(component.getName());

				});

				if (componentName.containsAll(requires)) {
					filteredJukesFinal.add(juke);
				}
			});

			filteredJukes = filteredJukesFinal;
		}

		if (limit == null) {
			limit = filteredJukes.size();
		}

		filteredJukes = filteredJukes.stream().skip(offset).limit(limit).collect(Collectors.toList());

		return filteredJukes;
	}
}
