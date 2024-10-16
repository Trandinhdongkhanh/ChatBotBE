package com.tddk.chatbotapp.service;

import com.tddk.chatbotapp.dto.req.AuthReq;
import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.TokenRes;
import com.tddk.chatbotapp.dto.res.UserRes;

public interface IUserCredentialService {
    TokenRes login(AuthReq req);
    UserRes signup(SignUpReq req);
}
