package com.juliusyolo.yoho.service.impl;

import com.juliusyolo.service.UserService;
import com.juliusyolo.yoho.service.ChatBotService;
//import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatBotServiceImpl implements ChatBotService {
//    @Autowired
//    private ChatModel chatModel;
    @Autowired
    UserService userService;
    @Override
    public String chat(String message) {
        return "";
    }
}
