package it.pascal.fabrik.testsv4.config;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestSv4HttpClient {
    private final RestTemplate restTemplate;

    public TestSv4HttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
