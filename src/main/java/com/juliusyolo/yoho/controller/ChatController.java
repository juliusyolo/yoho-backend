package com.juliusyolo.yoho.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ChatController {

    @GetMapping("/api/v1/ai/chat")
    public Mono<String> chat(){
        //TODO
       return ReactiveSecurityContextHolder.getContext().map(SecurityContext::getAuthentication).map(Authentication::getName);
    }
}
