package com.mediBuddy.medicos.service;

import com.mediBuddy.medicos.Exceptions.ResourceNotFoundException;
import com.mediBuddy.medicos.dto.DomainDTO;
import com.mediBuddy.medicos.dto.QuestionDTO;
import com.mediBuddy.medicos.model.Domain;
import com.mediBuddy.medicos.repositories.domainRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class domainService {

    private  final domainRepository domainrepo;
    private  final questionService qs;
    private ModelMapper modelMapper;
    // get All Domain

    public List<DomainDTO> getAllDomain(){
        List<Domain> domains = domainrepo.findAll();
        return domains.stream().map((domain)-> modelMapper.map(domain,DomainDTO.class)).collect(Collectors.toList());
    }


    // get All Question Of Particular Domain
public List<QuestionDTO> getAllQuestionOfDomain(String domainId){
    Optional<Domain> d = domainrepo.findById(domainId);
    if(d.isEmpty()){
        throw new ResourceNotFoundException("Domain Not Exist");
    }
        return qs.getAllQuestionsOfDomain(domainId);
}


    // Add Domain
    public  DomainDTO addDomain(String domainname){
        Domain domain = Domain.builder().domainName(domainname.toLowerCase()).build();
        Domain savedDomain = domainrepo.save(domain);
        qs.addQuestionsToDomain(domainname.toLowerCase(),savedDomain.getId());
      return  modelMapper.map(savedDomain,DomainDTO.class);
    }


    public  DomainDTO getByName(String name){
        Domain getDomain = domainrepo.findBydomainName(name.toLowerCase());

        System.out.println(getDomain);
        if (getDomain == null) {
            return  null;
        }
        System.out.println(getDomain);
        return  modelMapper.map(getDomain,DomainDTO.class);
    }

}
