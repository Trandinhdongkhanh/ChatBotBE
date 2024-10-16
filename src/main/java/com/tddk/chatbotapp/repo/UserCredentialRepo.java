package com.tddk.chatbotapp.repo;

import com.tddk.chatbotapp.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialRepo extends JpaRepository<UserCredential, Integer> {

}
