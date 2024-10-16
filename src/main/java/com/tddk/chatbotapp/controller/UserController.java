package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.req.AuthReq;
import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.TokenRes;
import com.tddk.chatbotapp.dto.res.UserRes;
import com.tddk.chatbotapp.service.impl.UserCredentialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserCredentialService service;

    public UserController(UserCredentialService service) {
        this.service = service;
    }

    @PostMapping("/user/login")
    public ResponseEntity<TokenRes> login(@RequestBody AuthReq req) {
        return ResponseEntity.ok().body(service.login(req));
    }

    @PostMapping("/user")
    public ResponseEntity<UserRes> signup(@RequestBody SignUpReq req) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.signup(req));
    }
}
