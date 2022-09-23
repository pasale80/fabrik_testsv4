package it.pascal.fabrik.testsv4.controller;

import it.pascal.fabrik.testsv4.service.TestSv4Service;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.mock.web.MockHttpServletRequest;

@SpringBootTest
public class TestSv4ControllerTest {

    @MockBean
    private TestSv4Service testSv4Service;

    @SpyBean
    private TestSv4Controller controller;

    @Test
    public void getAccountBalance() {
        MockHttpServletRequest get = new MockHttpServletRequest("GET", "http://localhost:8080/test?mock=true");
        controller.getAccountBalance(123456l, get);
    }

    @Test
    public void createMoneyTransfer() {
        MockHttpServletRequest post = new MockHttpServletRequest("POST", "http://localhost:8080/test?mock=true");
        controller.createMoneyTransfer(123456l, post, "a_body");
    }

    @Test
    public void getAccountTransactions() {
        MockHttpServletRequest get = new MockHttpServletRequest("GET", "http://localhost:8080/test?mock=true");
        controller.getAccountTransactions(123456l, get);
    }
}