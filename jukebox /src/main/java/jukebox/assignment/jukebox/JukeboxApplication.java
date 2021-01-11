package jukebox.assignment.jukebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import jukebox.assignment.jukebox.controller.exceptions.RestTemplateErrorHandler;

@SpringBootApplication
public class JukeboxApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplateBuilder().errorHandler(new RestTemplateErrorHandler()).build();
		return restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(JukeboxApplication.class, args);
	}

}
