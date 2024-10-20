package com.tddk.chatbotapp.service.impl;

import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.UserRes;
import com.tddk.chatbotapp.entity.UserCredential;
import com.tddk.chatbotapp.enums.UserRole;
import com.tddk.chatbotapp.repo.UserCredentialRepo;
import com.tddk.chatbotapp.service.IUserCredentialService;
import com.tddk.chatbotapp.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCredentialService implements IUserCredentialService {
    private final UserCredentialRepo userRepo;
    private final PasswordEncoder encoder;

    @Override
    public UserRes signup(SignUpReq req) {
        UserCredential user = UserCredential.builder()
                .username(req.getUsername())
                .password(encoder.encode(req.getPassword()))
                .isAccNonExpired(true)
                .isAccNonLocked(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .roles(List.of(UserRole.USER.name()))
                .build();
        return Mapper.toUserRes(userRepo.save(user));
    }

    @Override
    public List<UserRes> getUsers() {
        return userRepo.findAll().stream().map(Mapper::toUserRes).toList();
    }
}
