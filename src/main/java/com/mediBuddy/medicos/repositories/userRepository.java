package com.mediBuddy.medicos.repositories;


import com.mediBuddy.medicos.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
}
