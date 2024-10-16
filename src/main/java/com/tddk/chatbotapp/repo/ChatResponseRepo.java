package com.tddk.chatbotapp.repo;

import com.tddk.chatbotapp.entity.ChatResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatResponseRepo extends JpaRepository<ChatResponse, Integer> {

}
