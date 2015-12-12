package org.abhishek.bookstore.jersey.service.config;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by abhishek on 24/07/15.
 */
public class JerseyServiceConfigHolder {

    private ObjectMapper objectMapper;
    private String serviceConfigFile;
    private JsonNode configRoot;

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void setServiceConfigFile(String serviceConfigFile) {
        this.serviceConfigFile = serviceConfigFile;
    }

    public void init() throws IOException {
        loadCoreConfig();
    }

    public void loadCoreConfig() throws IOException {
        configRoot = objectMapper.readTree(new File(serviceConfigFile));
    }

    public String getMessageForService(String environment) {
        return configRoot.path("service").path("message").path(environment).getTextValue();
    }

}
