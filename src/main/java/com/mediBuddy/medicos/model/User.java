package com.mediBuddy.medicos.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document
@Getter
@Setter
@NoArgsConstructor
public class User {
    @MongoId
    private String id;
    private String username;
    private String email;
    private String password;
}
