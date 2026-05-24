package com.annab.ai.aidepositguard.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class DemoChatService {

    private final ChatClient chatClient;

    public DemoChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * 发送消息到AI模型并获取响应
     *
     * @param message 用户输入的消息
     * @return AI模型的响应
     */
    public String chat(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    /**
     * 使用系统提示进行聊天
     *
     * @param systemPrompt 系统提示
     * @param userMessage 用户消息
     * @return AI模型的响应
     */
    public String chatWithSystemPrompt(String systemPrompt, String userMessage) {
        return chatClient.prompt()
                .system(systemPrompt)
                .user(userMessage)
                .call()
                .content();
    }
}
