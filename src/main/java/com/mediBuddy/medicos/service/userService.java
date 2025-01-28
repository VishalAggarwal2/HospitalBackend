package com.mediBuddy.medicos.service;

import com.mediBuddy.medicos.Advice.ApiResponseProject;
import com.mediBuddy.medicos.dto.ApiResponse;
import com.mediBuddy.medicos.dto.userDTO;
import com.mediBuddy.medicos.model.User;
import com.mediBuddy.medicos.repositories.userRepository;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class userService {
    private  final userRepository userRepo;
    private  ModelMapper modelMapper;

    // create User SignUp
    public userDTO signup(User user){
        User savedUser = userRepo.save(user);
        userDTO userDTO = modelMapper.map(savedUser, userDTO.class);
        return userDTO;
    }


    public userDTO login(String email,String password){
        User user = userRepo.findByEmail(email);
        if(user==null){
            return null;
        }

        if(password.equals(user.getPassword())){
            return modelMapper.map(user, userDTO.class);
        }
        else {
            return null;
        }

    }



    public userDTO getByEmail(String email){
        User user = userRepo.findByEmail(email);
        if(user==null){
            return null;
        }
        userDTO userDTO = modelMapper.map(user, userDTO.class);
        return userDTO;
    }
}
