package com.mediBuddy.medicos.Exceptions;

public class ResourceAlreadyExist extends RuntimeException{
    public ResourceAlreadyExist(String message){
        super(message);
    }
}
