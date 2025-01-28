package com.mediBuddy.medicos.repositories;

import com.mediBuddy.medicos.model.Domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface domainRepository extends MongoRepository<Domain,String> {
    Domain findBydomainName(String domainName);
}
