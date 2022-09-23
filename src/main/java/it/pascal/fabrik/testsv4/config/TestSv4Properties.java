package it.pascal.fabrik.testsv4.config;

import lombok.Data;
import lombok.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "testsv4", ignoreUnknownFields = false)
@Data
@Generated
public class TestSv4Properties {
    private String baseUrl;
    private String authSchema;
    private String apiKey;
    private Long accountId;

}
