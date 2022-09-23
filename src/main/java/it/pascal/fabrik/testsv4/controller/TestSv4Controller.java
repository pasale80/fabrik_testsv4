package it.pascal.fabrik.testsv4.controller;

import it.pascal.fabrik.testsv4.service.TestSv4Service;
import it.pascal.fabrik.testsv4.utils.UriUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TestSv4Controller {

    private final TestSv4Service testSv4Service;

    public TestSv4Controller(TestSv4Service testSv4Service) {
        this.testSv4Service = testSv4Service;
    }

    @GetMapping(path = "/api/gbs/banking/v4.0/accounts/{accountId}/balance")
    public ResponseEntity<String> getAccountBalance(@PathVariable Long accountId, HttpServletRequest request) {
         return testSv4Service.execGetRequest(UriUtils.buildUri(request), null);
    }
    @PostMapping(path = "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers")
    public ResponseEntity<String> createMoneyTransfer(@PathVariable Long accountId, HttpServletRequest request, @RequestBody Object body) {

        MultiValueMap<String, String> requestHeaders = new HttpHeaders();
        requestHeaders.add("X-Time-Zone", "Europe/Rome");
        requestHeaders.add("Content-type", "application/json");

        return testSv4Service.execPostRequest(request.getRequestURI(), requestHeaders, body);
    }

    @GetMapping(path = "/api/gbs/banking/v4.0/accounts/{accountId}/transactions")
    public ResponseEntity<String> getAccountTransactions(@PathVariable Long accountId, HttpServletRequest request) {
        return testSv4Service.execGetRequest(UriUtils.buildUri(request), null);
    }


}
