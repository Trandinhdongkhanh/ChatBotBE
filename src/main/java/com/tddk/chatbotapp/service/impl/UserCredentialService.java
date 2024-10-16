package com.tddk.chatbotapp.service.impl;

import com.tddk.chatbotapp.dto.req.AuthReq;
import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.TokenRes;
import com.tddk.chatbotapp.dto.res.UserRes;
import com.tddk.chatbotapp.repo.UserCredentialRepo;
import com.tddk.chatbotapp.service.IUserCredentialService;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService implements IUserCredentialService {
    private final UserCredentialRepo repo;

    public UserCredentialService(UserCredentialRepo repo) {
        this.repo = repo;
    }

    @Override
    public TokenRes login(AuthReq req) {
        return null;
    }

    @Override
    public UserRes signup(SignUpReq req) {
        return null;
    }
}
