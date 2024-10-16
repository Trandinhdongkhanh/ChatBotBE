package com.tddk.chatbotapp.service.impl;

import com.tddk.chatbotapp.dto.req.ChatReq;
import com.tddk.chatbotapp.dto.res.ChatRes;
import com.tddk.chatbotapp.entity.ChatResponse;
import com.tddk.chatbotapp.repo.ChatResponseRepo;
import com.tddk.chatbotapp.service.IChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ChatService implements IChatService {
    private final ChatResponseRepo repo;

    @Override
    public ChatRes chat(ChatReq req) {
        List<ChatResponse> resList = repo.findByKeyword(req.getQuestion().trim().toLowerCase());
        Random random = new Random();
        ChatResponse cRes = resList.isEmpty() ? null : resList.get(random.nextInt(resList.size()));
        return ChatRes.builder()
                .res(cRes != null ? cRes.getResponse() : "Can you please provide me with more information")
                .build();
    }
}
