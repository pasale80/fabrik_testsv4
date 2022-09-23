package it.pascal.fabrik.testsv4.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.charset.StandardCharsets;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<Object> handleConflict(HttpClientErrorException ex, WebRequest request) {
        log.info("{}", ex.getResponseBodyAsString(StandardCharsets.UTF_8));
        ex.getResponseHeaders().remove("Transfer-encoding");
        return handleExceptionInternal(ex, ex.getResponseBodyAsString(StandardCharsets.UTF_8), ex.getResponseHeaders(), ex.getStatusCode(), request);
    }
}