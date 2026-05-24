package com.annab.ai.aidepositguard.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    // 手动创建 ObjectMapper Bean，交给 Spring 管理
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}