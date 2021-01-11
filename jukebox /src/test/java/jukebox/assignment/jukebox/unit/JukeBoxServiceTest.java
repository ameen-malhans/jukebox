package jukebox.assignment.jukebox.unit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jukebox.assignment.jukebox.model.JukeBox;
import jukebox.assignment.jukebox.model.SettingWrapper;
import jukebox.assignment.jukebox.service.JukeBoxService;
import jukebox.assignment.jukebox.service.constants.DownStreamAPI;

@SpringBootTest
class JukeBoxServiceTest {

	@Autowired
	private JukeBoxService jukeBoxService;

	@MockBean
	private RestTemplate restTemplate;

	@BeforeEach
	public void init() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objMapper = new ObjectMapper();
		InputStream is = getClass().getClassLoader().getResourceAsStream("static/jukebox.json");
		JukeBox[] jukeBoxes = objMapper.readValue(is, JukeBox[].class);
		Mockito.when(restTemplate.getForObject(DownStreamAPI.GET_JUKES.getUri(), JukeBox[].class))
				.thenReturn(jukeBoxes);

		objMapper = new ObjectMapper();
		is = getClass().getClassLoader().getResourceAsStream("static/setting.json");
		SettingWrapper settingWrapper = objMapper.readValue(is, SettingWrapper.class);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<SettingWrapper> responseEntity = new ResponseEntity<SettingWrapper>(settingWrapper, httpHeaders,
				HttpStatus.OK);
		Mockito.when(restTemplate.getForEntity(DownStreamAPI.GET_SETTINGS.getUri(), SettingWrapper.class))
				.thenReturn(responseEntity);
	}

	@Test
	public void getJukeBoxAllInputs() {
		// All inputs
		List<JukeBox> jukeBoxesResult = jukeBoxService.filterJukeBoxes("67ab1ec7-59b8-42f9-b96c-b261cc2a2ed9",
				"angelina", 0, 1);
		assertNotNull(jukeBoxesResult);
		assertFalse(jukeBoxesResult.isEmpty());
		assertThat(jukeBoxesResult.size(), is(1));

	}

	@Test
	public void getJukeBoxBySettingId() {
		// Inputs: setting id
		List<JukeBox> jukeBoxesResult = jukeBoxService.filterJukeBoxes("67ab1ec7-59b8-42f9-b96c-b261cc2a2ed9", null, 0,
				null);
		assertNotNull(jukeBoxesResult);
		assertFalse(jukeBoxesResult.isEmpty());
		assertThat(jukeBoxesResult.size(), is(7));

	}

	@Test
	public void getJukeBoxByModel() {
		// Inputs:settingid,model
		List<JukeBox> jukeBoxesResult = jukeBoxService.filterJukeBoxes("67ab1ec7-59b8-42f9-b96c-b261cc2a2ed9",
				"angelina", 0, null);
		assertNotNull(jukeBoxesResult);
		assertFalse(jukeBoxesResult.isEmpty());
		assertThat(jukeBoxesResult.size(), is(3));

	}

	@Test
	public void getJukeBoxByOffset() {
		// Inputs:settingid,model,offset
		List<JukeBox> jukeBoxesResult = jukeBoxService.filterJukeBoxes("67ab1ec7-59b8-42f9-b96c-b261cc2a2ed9",
				"angelina", 1, null);
		assertNotNull(jukeBoxesResult);
		assertFalse(jukeBoxesResult.isEmpty());
		assertThat(jukeBoxesResult.size(), is(2));

	}

	@Test
	public void getJukeBoxByLimit() {
		// Inputs:settingid,model,limit
		List<JukeBox> jukeBoxesResult = jukeBoxService.filterJukeBoxes("67ab1ec7-59b8-42f9-b96c-b261cc2a2ed9",
				"angelina", 0, 2);
		assertNotNull(jukeBoxesResult);
		assertFalse(jukeBoxesResult.isEmpty());
		assertThat(jukeBoxesResult.size(), is(2));
	}

	@Test
	public void getJukeBoxByLimitAndOffset() {
		// Inputs:settingid,model,offset,limit
		List<JukeBox> jukeBoxesResult = jukeBoxService.filterJukeBoxes("67ab1ec7-59b8-42f9-b96c-b261cc2a2ed9",
				"angelina", 1, 2);
		assertNotNull(jukeBoxesResult);
		assertFalse(jukeBoxesResult.isEmpty());
		assertThat(jukeBoxesResult.size(), is(2));
	}
}
