package jukebox.assignment.jukebox;

import java.time.Duration;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import jukebox.assignment.jukebox.controller.exceptions.RestTemplateErrorHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JukeboxApplication {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/jukebox/jukeboxes/*"))
				.apis(RequestHandlerSelectors.basePackage("jukebox.assignment")).build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("REST API", "JukeBox Project", "", "",
				new Contact("Ameen Malhans", "https://www.linkedin.com/in/ameen-malhans/", "ameenpal@hotmail.com"),
				null, null, Collections.emptyList());
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplateBuilder().errorHandler(new RestTemplateErrorHandler()).build();
		return restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(JukeboxApplication.class, args);
	}

}
