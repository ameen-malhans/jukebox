package jukebox.assignment.jukebox;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jukebox.assignment.jukebox.controller.JukeBoxHomeController;
import jukebox.assignment.jukebox.model.JukeBox;
import jukebox.assignment.jukebox.service.JukeBoxService;


@WebMvcTest(JukeBoxHomeController.class)
public class JukeboxApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private JukeBoxService jukeBoxService;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
	
	}
	
}
/*@SpringBootTest
class JukeboxApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@Autowired
	private JukeBoxService jukeBoxService;
	
	@MockBean
	private RestTemplate restTemplate;
	
	
	@Test
	public void filterJukeBoxesTest() throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objMapper = new ObjectMapper();
		
		//ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		//InputStream is = classloader.getResourceAsStream("static/setting.json");
		JukeBox[] jukeBoxes = objMapper.readValue(new File("static/jukebox.json"), JukeBox[].class); 
	    //SettingWrapper settingWrapper = gson.fromJson(theString, SettingWrapper.class);

		
		Mockito.when(restTemplate.getForObject(JukeBoxService.GET_JUKES,JukeBox[].class)).thenReturn(jukeBoxes);
		

		//[] jukeBoxes = objMapper.readValue(new File("static/setting.json"), JukeBox[].class); 
	    //SettingWrapper settingWrapper = gson.fromJson(theString, SettingWrapper.class);

		
		//Mockito.when(restTemplate.getForObject(JukeBoxService.SettingWrapper,JukeBox[].class)).thenReturn(jukeBoxes);

		
		//jukeBoxService.filterJukeBoxes(settingId, model, offset, limit)
		
		
	System.out.println("");
	}
}*/
