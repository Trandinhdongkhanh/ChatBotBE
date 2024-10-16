package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.UserRes;
import com.tddk.chatbotapp.service.impl.UserCredentialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserCredentialService service;
    @PostMapping("/user")
    public ResponseEntity<UserRes> signup(@RequestBody @Valid SignUpReq req) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.signup(req));
    }
}
