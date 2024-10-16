package com.tddk.chatbotapp.dto.req;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthReq {
    private String username;
    private String password;
}
