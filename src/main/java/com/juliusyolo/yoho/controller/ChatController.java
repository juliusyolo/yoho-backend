package com.juliusyolo.yoho.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @GetMapping("/api/v1/ai/test")
    public String test(){
        return "test";
    }

    @GetMapping("/api/v1/ai/chat1")
    public String chat(){
        return "test";
    }
}
