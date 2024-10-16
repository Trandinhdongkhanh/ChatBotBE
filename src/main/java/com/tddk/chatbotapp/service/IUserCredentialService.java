package com.tddk.chatbotapp.service;

import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.UserRes;

public interface IUserCredentialService {
    UserRes signup(SignUpReq req);
}
