package com.mediBuddy.medicos.Exceptions;


public class ResourceNotFoundException extends RuntimeException {
    public  ResourceNotFoundException(String message){
        super(message);
    }
}
