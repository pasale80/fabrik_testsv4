package it.pascal.fabrik.testsv4;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
class TestSv4ApplicationTests {

	@SpyBean
	TestSv4Application application;

	@Test
	void main() {
		application.main(new String[]{});
	}

	@Test
	void restTemplate() {

	}
}
