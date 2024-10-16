package com.tddk.chatbotapp.service.impl;

import com.tddk.chatbotapp.dto.req.ChatReq;
import com.tddk.chatbotapp.dto.res.ChatRes;
import com.tddk.chatbotapp.repo.ChatResponseRepo;
import com.tddk.chatbotapp.service.IChatService;
import org.springframework.stereotype.Service;

@Service
public class ChatService implements IChatService {
    private final ChatResponseRepo repo;

    public ChatService(ChatResponseRepo repo) {
        this.repo = repo;
    }

    @Override
    public ChatRes chat(ChatReq req) {
        return null;
    }
}
