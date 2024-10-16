package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.req.AuthReq;
import com.tddk.chatbotapp.dto.res.TokenRes;
import com.tddk.chatbotapp.service.impl.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    @PostMapping("/user/login")
    public ResponseEntity<TokenRes> login(@RequestBody @Valid AuthReq req) {
        return ResponseEntity.ok().body(service.login(req));
    }
}
