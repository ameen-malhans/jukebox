package jukebox.assignment.jukebox.unit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import jukebox.assignment.jukebox.model.JukeBox;
import jukebox.assignment.jukebox.model.SettingWrapper;
import jukebox.assignment.jukebox.service.JukeBoxService;

//@RunWith(SpringRunner.class) 
//@SpringBootTest
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class JukeBoxServiceTest {

	
}
