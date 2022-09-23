package it.pascal.fabrik.testsv4;

import it.pascal.fabrik.testsv4.config.TestSv4Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties({TestSv4Properties.class})

public class TestSv4Application {

	public static void main(String[] args) {
		SpringApplication.run(TestSv4Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
