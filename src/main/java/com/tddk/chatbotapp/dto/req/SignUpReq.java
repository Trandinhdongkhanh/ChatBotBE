package com.tddk.chatbotapp.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpReq extends AuthReq{
    @JsonProperty("full_name")
    private String fullName;
}
