package com.mediBuddy.medicos.dto;

import lombok.Getter;
import lombok.Setter;

 enum  questionType{
    FAQ,
    CSQ,
    CQ
}


@Getter
@Setter
public class QuestionDTO {
    private String id;

    private questionType type;

    private String questionTitle;
    private String answer;

    private  String domainId;

    private  String chatId;

    private  String counslingSessionId;

}
