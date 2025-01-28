package com.mediBuddy.medicos.controllers.auth;

import com.mediBuddy.medicos.Advice.ApiResponseProject;
import com.mediBuddy.medicos.Exceptions.InvalidCreadentials;
import com.mediBuddy.medicos.Exceptions.ResourceAlreadyExist;
import com.mediBuddy.medicos.Exceptions.ResourceNotFoundException;
import com.mediBuddy.medicos.dto.ApiResponse;
import com.mediBuddy.medicos.dto.userDTO;
import com.mediBuddy.medicos.dto.userLogin;
import com.mediBuddy.medicos.model.User;
import com.mediBuddy.medicos.service.userService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@AllArgsConstructor
public class auth {


    private final userService userservice;
    @PostMapping("/login")
    public ResponseEntity<ApiResponseProject<userDTO>> Login(@RequestBody userLogin login){
        userDTO user = userservice.login(login.getEmail(),login.getPassword());

if(user==null){
throw new InvalidCreadentials("Invalid Creadentials ....");
}

        ApiResponseProject<userDTO> api= new ApiResponseProject<userDTO>("success","User registered successfully",user);
        return new ResponseEntity<>(api, HttpStatus.CREATED);
    }


    @GetMapping("/{email}")
  public ResponseEntity<ApiResponseProject<String>> getuserid(@PathVariable String email){
        userDTO u = userservice.getByEmail(email);
        if(u==null){
           throw  new ResourceNotFoundException("User Not Exist");
        }
        ApiResponseProject<String> reponse = new ApiResponseProject<>("Success","",u.getId());
        return new ResponseEntity<>(reponse, HttpStatus.CREATED);
    }







    @PostMapping("/signup")
    public ResponseEntity<ApiResponseProject<userDTO>>  Signup(@RequestBody User user){
        if(userservice.getByEmail(user.getEmail())!=null){
           throw  new ResourceAlreadyExist("User Already Exist With This Email");
        }
        userDTO u=  userservice.signup(user);
        ApiResponseProject<userDTO> api= new ApiResponseProject<userDTO>("success","User registered successfully",u);
        return new ResponseEntity<>(api, HttpStatus.CREATED);
    }



}
