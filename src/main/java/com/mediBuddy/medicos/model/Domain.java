package com.mediBuddy.medicos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Domain {
    @MongoId
    private  String id;
    private  String domainName;
    @DBRef
    private List<Question> questions;
}
