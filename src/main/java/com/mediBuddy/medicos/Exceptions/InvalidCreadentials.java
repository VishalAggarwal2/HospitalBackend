package com.mediBuddy.medicos.Exceptions;

public class InvalidCreadentials extends RuntimeException{
    public InvalidCreadentials(String message){
        super(message);
    }
}
