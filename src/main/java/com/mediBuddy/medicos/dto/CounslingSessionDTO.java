package com.mediBuddy.medicos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CounslingSessionDTO {
    private  String id;
    private  String doctorName;
    private  String sessionName;
    private  String summary;
    private String precautions;
    private  String userId;
    private List<QuestionDTO> questionList;
    private  List<DomainDTO> Domain;
}
