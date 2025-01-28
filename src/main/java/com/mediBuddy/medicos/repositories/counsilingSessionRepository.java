package com.mediBuddy.medicos.repositories;

import com.mediBuddy.medicos.model.CounslingSession;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface counsilingSessionRepository extends MongoRepository<CounslingSession,String> {
    List<CounslingSession> findBySessionNameAndUserId(String sessionName, String userId);
    List<CounslingSession> findByUserId(String userId);
}
