package com.annab.ai.aidepositguard.controller;

import com.annab.ai.aidepositguard.service.ChatService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class DemoController {

    @Resource
    private ChatService chatService;


    @GetMapping("/ping")
    public String ping(@RequestParam String question) {
        return chatService.call(question);
    }
}
