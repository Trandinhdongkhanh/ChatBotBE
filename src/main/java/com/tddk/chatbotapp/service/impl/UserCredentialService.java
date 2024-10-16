package com.tddk.chatbotapp.service.impl;

import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.UserRes;
import com.tddk.chatbotapp.entity.UserCredential;
import com.tddk.chatbotapp.repo.UserCredentialRepo;
import com.tddk.chatbotapp.service.IUserCredentialService;
import com.tddk.chatbotapp.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCredentialService implements IUserCredentialService {
    private final UserCredentialRepo repo;
    private final PasswordEncoder encoder;

    @Override
    public UserRes signup(SignUpReq req) {
        UserCredential user = UserCredential.builder()
                .username(req.getUsername())
                .password(encoder.encode(req.getPassword()))
                .fullName(req.getFullName())
                .build();
        return Mapper.toUserRes(repo.save(user));
    }
}
