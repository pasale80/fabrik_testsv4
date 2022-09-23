package it.pascal.fabrik.testsv4.service;

import it.pascal.fabrik.testsv4.config.TestSv4Properties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestSv4ServiceTest {

    @MockBean
    RestTemplate restTemplate;

    @MockBean
    TestSv4Properties properties;
    @SpyBean
    private TestSv4Service service;


    @Test
    public void execGetRequest_exception1() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () ->  service.execGetRequest("http://localhost:8080/test?mock=true", null),
                "testSv4Properties.baseUrl cannot be null"
        );
    }

    @Test
    public void execGetRequest_1() {
        when(properties.getBaseUrl()).thenReturn("http://locahlost:8080/test?mock=true");
        service.execGetRequest("http://localhost:8080/test?mock=true", null);
    }

    @Test
    public void execGetRequest_2() {
        when(properties.getBaseUrl()).thenReturn("http://locahlost:8080/test?mock=true");
        service.execGetRequest("http://localhost:8080/test?mock=true", new LinkedMultiValueMap<>());
    }
    @Test
    public void execPostRequest_exception1() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.execPostRequest(any(), any(), any()),
                "testSv4Properties.baseUrl cannot be null"
        );
    }

    @Test
    public void execPostRequest() {
        when(properties.getBaseUrl()).thenReturn("http://locahlost:8080/test?mock=true");
        service.execPostRequest(any(), any(), any());

    }
}