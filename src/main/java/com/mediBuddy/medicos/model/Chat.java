package com.mediBuddy.medicos.model;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.util.List;

@Document
public class Chat {
    @MongoId
    private  String id;
    private  String chatName;
    private String userId;
    @DBRef
    private List<Question> questions;
}
