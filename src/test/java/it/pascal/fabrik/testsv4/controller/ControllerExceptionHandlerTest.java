package it.pascal.fabrik.testsv4.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.charset.Charset;

@SpringBootTest
public class ControllerExceptionHandlerTest {

    @SpyBean
    ControllerExceptionHandler controllerExceptionHandler;

    @Test
    public void handleConflict() {
        HttpClientErrorException badRequestException = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "bad request", new HttpHeaders(), "a_body".getBytes(), Charset.defaultCharset());


        controllerExceptionHandler.handleConflict(badRequestException, null);
    }
}