package com.mediBuddy.medicos.controllers.domain;

import com.mediBuddy.medicos.Advice.ApiResponseProject;
import com.mediBuddy.medicos.Exceptions.ResourceAlreadyExist;
import com.mediBuddy.medicos.Exceptions.ResourceNotFoundException;
import com.mediBuddy.medicos.dto.DomainDTO;
import com.mediBuddy.medicos.dto.QuestionDTO;
import com.mediBuddy.medicos.service.domainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/domain")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class domain {
    private  final domainService ds;
    // get All Domain
    @GetMapping("/all")
    public ResponseEntity<ApiResponseProject<List<DomainDTO>>> getAllDomain(){

       List<DomainDTO> dt= ds.getAllDomain();
       ApiResponseProject<List<DomainDTO>> response = new ApiResponseProject<>("Success","All Domain Get Succ",dt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseProject<List<QuestionDTO>>>  getAllQuestion(@PathVariable String id){
        List<QuestionDTO> qdto= ds.getAllQuestionOfDomain(id);
        ApiResponseProject<List<QuestionDTO>> response = new ApiResponseProject<>("success","Question For This Domain Geted",qdto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add/{domainName}")
    public ResponseEntity<ApiResponseProject<DomainDTO>> addDomain(@PathVariable String domainName){
        if(ds.getByName(domainName)!=null) {
            throw new ResourceAlreadyExist("Domain with this name already Exist");
        }
         DomainDTO d= ds.addDomain(domainName);
        ApiResponseProject<DomainDTO>response = new ApiResponseProject<>("Success","Domain created Succ",d);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
