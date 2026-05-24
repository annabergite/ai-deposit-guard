package com.annab.ai.aidepositguard.controller;

import com.annab.ai.aidepositguard.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class DemoController {
    private final ChatService chatService;

    public DemoController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/ping")
    public String ping(@RequestParam String question) {
        return chatService.call(question);
    }
}
