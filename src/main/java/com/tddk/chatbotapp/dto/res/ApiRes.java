package com.tddk.chatbotapp.dto.res;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiRes {
    private int code;
    private Object data;
}
