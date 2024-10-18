package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.ApiRes;
import com.tddk.chatbotapp.service.impl.UserCredentialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Sign up new user")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Sign up successfully")})
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
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiRes.builder()
                        .code(HttpStatus.CREATED.value())
                        .data(userService.getUsers())
                        .build());
    }
}
