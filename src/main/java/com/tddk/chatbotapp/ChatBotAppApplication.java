package com.tddk.chatbotapp;

import com.tddk.chatbotapp.config.security.RSAKeyRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RSAKeyRecord.class)
public class ChatBotAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatBotAppApplication.class, args);
    }

}
