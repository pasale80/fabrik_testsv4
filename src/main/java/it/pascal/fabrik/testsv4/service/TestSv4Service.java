package it.pascal.fabrik.testsv4.service;

import it.pascal.fabrik.testsv4.config.TestSv4Properties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class TestSv4Service {

    private final RestTemplate restTemplate;

    private final TestSv4Properties testSv4Properties;

    public TestSv4Service(RestTemplate restTemplate, TestSv4Properties testSv4Properties) {
        this.restTemplate = restTemplate;
        this.testSv4Properties = testSv4Properties;
    }

    public ResponseEntity<String> execGetRequest(String apiUrl, MultiValueMap<String, String> headers) {
        return execRequest(apiUrl, HttpMethod.GET, headers, null);
    }
    public ResponseEntity<String> execPostRequest(String apiUrl, MultiValueMap<String, String> headers, Object body) {
        return execRequest(apiUrl, HttpMethod.POST, headers, body);
    }
    private ResponseEntity<String> execRequest(String apiUrl, HttpMethod method, MultiValueMap<String, String> headers, Object body) {
        Assert.notNull(testSv4Properties, "testSv4Properties cannot be null");
        Assert.notNull(restTemplate, "restTemplate cannot be null");
        Assert.notNull(testSv4Properties.getBaseUrl(), "testSv4Properties.baseUrl cannot be null");

        MultiValueMap<String, String> requestHeaders = new HttpHeaders();
        requestHeaders.set("Auth-Schema", testSv4Properties.getAuthSchema());
        requestHeaders.set("apikey", testSv4Properties.getApiKey());

        HttpEntity<Object> httpEntity = new HttpEntity<>(body, requestHeaders);

        if (headers != null) {
            requestHeaders.addAll(headers);
        }

        String uri = new StringBuilder()
                .append(testSv4Properties.getBaseUrl())
                .append("/")
                .append(apiUrl)
                .toString();
        return restTemplate.exchange(uri, method, httpEntity, String.class, new String[]{});
    }



}
