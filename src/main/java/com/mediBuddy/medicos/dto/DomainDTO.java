package com.mediBuddy.medicos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DomainDTO {
    private String id;
    private  String domainName;
    private List<QuestionDTO> questions;
}
