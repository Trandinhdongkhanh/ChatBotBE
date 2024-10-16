package com.tddk.chatbotapp.service.impl;

import com.tddk.chatbotapp.dto.req.AuthReq;
import com.tddk.chatbotapp.dto.res.TokenRes;
import com.tddk.chatbotapp.service.IAuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Override
    public TokenRes login(AuthReq req) {
        return null;
    }
}
