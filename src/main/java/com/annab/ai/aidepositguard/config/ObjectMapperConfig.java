package com.annab.ai.aidepositguard.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    // 手动创建 ObjectMapper Bean，交给 Spring 管理
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // 注册 JavaTimeModule 以支持 Java 8 日期时间类型(如 Instant)
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}