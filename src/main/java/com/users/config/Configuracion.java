package com.users.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@ConfigurationProperties
public class Configuracion {
    
    @Value("${application.users.endpoint.user}")
    private String endpoint;

    private int write;

    public String getEndpoint() {
        return endpoint;
    }
    
}
