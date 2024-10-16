package com.tddk.chatbotapp.dto.req;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatReq {
    private String question;
}
