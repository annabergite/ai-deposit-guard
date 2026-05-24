package com.annab.ai.aidepositguard.config;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.annab.ai.aidepositguard.service.ChatService;


@Configuration
public class ChatServiceConfig {

    @Bean
    public ChatService chatService(ObjectProvider<OllamaChatModel> modelProvider) {
        OllamaChatModel model = modelProvider.getIfAvailable(() -> null);
        if (model != null) {
            // delegate to the real model
            return model::call;
        }

        // fallback stub implementation
        return prompt -> "[fallback] Ollama not configured. Received: " + prompt;
    }
}

