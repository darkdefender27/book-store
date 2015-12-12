package org.abhishek.bookstore.jersey.service.bindings;

import org.abhishek.bookstore.jersey.service.config.JerseyServiceConfigHolder;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * Created by abhishek on 24/07/15.
 */
@Configuration
public class ServiceBindings {

    @Bean
    public static File jerseyServiceConfigDir() {
        return new File(System.getProperty("org.abhishek.service.config"));
    }

    @Bean
    public File jerseyServiceConfigFile() {
        return new File(jerseyServiceConfigDir(), "jersey-service-config.json");
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Enable DeserializationFeature
        objectMapper.enable(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        // Disable DeserializationFeature
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES);
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);

        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        return objectMapper;
    }

    @Bean(initMethod = "init")
    public JerseyServiceConfigHolder jerseyServiceConfigHolder() throws IOException {
        JerseyServiceConfigHolder jerseyServiceConfigHolder = new JerseyServiceConfigHolder();
        jerseyServiceConfigHolder.setObjectMapper(objectMapper());
        jerseyServiceConfigHolder.setServiceConfigFile(jerseyServiceConfigFile().getAbsolutePath());
        return jerseyServiceConfigHolder;
    }

}
