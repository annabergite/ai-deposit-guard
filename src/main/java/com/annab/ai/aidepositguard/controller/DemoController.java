package com.annab.ai.aidepositguard.controller;

import com.annab.ai.aidepositguard.service.ChatService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class DemoController {

    @Resource
    private ChatService chatService;


    @GetMapping("/ping")
    public String ping(@RequestParam String question) {
        return chatService.call(question);
    }

    @PostMapping("/ping")
    public String pingPost(@RequestBody Map<String, String> request) {
        String question = request.get("question");
        if (question == null || question.isEmpty()) {
            throw new IllegalArgumentException("question参数不能为空");
        }
        return chatService.call(question);
    }
}
