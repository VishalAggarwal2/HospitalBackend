package com.mediBuddy.medicos.service;
import com.mediBuddy.medicos.dto.QuestionDTO;
import com.mediBuddy.medicos.model.Question;
import com.mediBuddy.medicos.repositories.questionRepository;
import com.mediBuddy.medicos.utils.GoogleGemini;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class questionService {

    private final questionRepository questionRepo;
    private final ModelMapper modelMapper;
    private  final GoogleGemini gm;


    public List<QuestionDTO> getAllQuestionsOfDomain(String domainId) {
        List<Question> questions = questionRepo.findBydomainId(domainId);
        if(questions.size()==0){
            return null;
        }
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDTO.class))
                .collect(Collectors.toList());
    }

    public List<QuestionDTO> getAllQuestionsOfChat(String chatId) {
        List<Question> questions = questionRepo.findBychatId(chatId);
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDTO.class))
                .collect(Collectors.toList());
    }

    public List<QuestionDTO> getAllQuestionsOfCounselingSession(String sessionId) {
        List<Question> questions = questionRepo.findBycounslingSessionId(sessionId);
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDTO.class))
                .collect(Collectors.toList());
    }

    public void addQuestionsToDomain(String domainName, String domainId) {
        String requestPayload = gm.createRequestPayload(domainName);
        List<Question> fetchedQuestions = gm.fetchQuestionsFromGemini(requestPayload,domainId);
        questionRepo.saveAll(fetchedQuestions);
    }



}
