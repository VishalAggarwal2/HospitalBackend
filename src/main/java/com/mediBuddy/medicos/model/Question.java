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
public class Question {
    @MongoId
    private String id;
    private  questionType type;
    private String questionTitle;
    private String answer;
   private  String domainId;
   private  String chatId;
   private  String counslingSessionId;
}
