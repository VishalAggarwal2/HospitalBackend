package com.mediBuddy.medicos.model;

import com.mediBuddy.medicos.dto.CounslingSessionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CounslingSession {
    @MongoId
    private  String id;
    private  String doctorName;
    private  String sessionName;
    private  String userId;
    private  String summary;
    private String precautions;
    @DBRef
    private List<Question> questionList;
    @DBRef
    private  List<Domain> Domain;
}

