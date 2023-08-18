package com.picpaysimplificado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DocumentAlreadyRegisteredException extends RuntimeException{
    public DocumentAlreadyRegisteredException(){
        super("The user of this document is already registered");
    }

    public DocumentAlreadyRegisteredException(String message){
        super(message);
    }
}
