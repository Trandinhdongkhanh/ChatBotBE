package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.req.ChatReq;
import com.tddk.chatbotapp.dto.res.ChatRes;
import com.tddk.chatbotapp.service.impl.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ChatController {
    private final ChatService service;

    public ChatController(ChatService service) {
        this.service = service;
    }

    @PostMapping("/chat")
    public ResponseEntity<ChatRes> chat(@RequestBody ChatReq req) {
        return ResponseEntity.ok().body(service.chat(req));
    }
}
