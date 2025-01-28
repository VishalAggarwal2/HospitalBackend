package com.mediBuddy.medicos.repositories;

import com.mediBuddy.medicos.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionRepository extends MongoRepository<Question,String> {
    List<Question> findBydomainId(String domainId);
    List<Question> findBychatId(String chatId);
    List<Question> findBycounslingSessionId(String counslingSessionId);
}
