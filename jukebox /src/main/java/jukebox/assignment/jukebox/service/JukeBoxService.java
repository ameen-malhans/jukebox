package jukebox.assignment.jukebox.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import jukebox.assignment.jukebox.controller.exceptions.model.RestTemplateException;
import jukebox.assignment.jukebox.model.JukeBox;
import jukebox.assignment.jukebox.model.Setting;
import jukebox.assignment.jukebox.model.SettingWrapper;
import jukebox.assignment.jukebox.service.constants.DownStreamAPI;

@Service
public class JukeBoxService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JukeBoxService.class);

	@Autowired
	private RestTemplate restTemplate;

	public List<JukeBox> getJukes() {
		try {
			JukeBox[] result = restTemplate.getForObject(DownStreamAPI.GET_JUKES.getUri(), JukeBox[].class);
			return Arrays.asList(result);
		} catch (RestClientException ex) {
			LOGGER.error("Exception occured getJukes::", ex);
			throw new RestTemplateException(DownStreamAPI.GET_JUKES, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	public SettingWrapper getSettings() {
		try {
			ResponseEntity<SettingWrapper> result = restTemplate.getForEntity(DownStreamAPI.GET_SETTINGS.getUri(),
					SettingWrapper.class);
			return result.getBody();
		} catch (RestClientException ex) {
			LOGGER.error("Exception occured getJukes::", ex);
			throw new RestTemplateException(DownStreamAPI.GET_SETTINGS, HttpStatus.INTERNAL_SERVER_ERROR,
					ex.getMessage());
		}

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
