package com.tddk.chatbotapp.service.impl;

import com.tddk.chatbotapp.dto.req.AuthReq;
import com.tddk.chatbotapp.dto.res.TokenRes;
import com.tddk.chatbotapp.repo.UserCredentialRepo;
import com.tddk.chatbotapp.service.IAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements IAuthService {
    private final UserCredentialRepo userRepo;
    @Override
    public TokenRes login(AuthReq req) {
        return null;
    }
}
