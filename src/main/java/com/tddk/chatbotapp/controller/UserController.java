package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.ApiRes;
import com.tddk.chatbotapp.service.impl.UserCredentialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserCredentialService userService;

    @PostMapping("/user")
    public ResponseEntity<ApiRes> signup(@RequestBody @Valid SignUpReq req) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiRes.builder()
                        .code(HttpStatus.OK.value())
                        .data(userService.signup(req))
                        .build());
    }

    @GetMapping("/users")
    public ResponseEntity<ApiRes> getUsers() {
        return ResponseEntity.ok(
                ApiRes.builder()
                        .code(HttpStatus.OK.value())
                        .data(userService.getUsers())
                        .build()
        );
    }
}
