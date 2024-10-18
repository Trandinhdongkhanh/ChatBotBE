package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.req.ChatReq;
import com.tddk.chatbotapp.dto.res.ApiRes;
import com.tddk.chatbotapp.service.impl.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @Operation(summary = "User send chat request")
    @ApiResponse(responseCode = "200", description = "Send chat request successfully")
    @PostMapping("/chat")
    public ResponseEntity<ApiRes> chat(@RequestBody @Valid ChatReq req) {
        return ResponseEntity.ok().body(
                ApiRes.builder()
                        .data(chatService.chat(req))
                        .code(HttpStatus.OK.value())
                        .build());
    }
}
