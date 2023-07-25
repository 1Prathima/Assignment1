package com.example.Assignment1.Exceptions;

public class EmailAlreadyPresentException extends Exception{
    public EmailAlreadyPresentException(String message){
        super(message);
    }
}
