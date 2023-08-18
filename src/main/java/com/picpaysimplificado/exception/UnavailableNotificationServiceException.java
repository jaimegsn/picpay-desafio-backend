package com.picpaysimplificado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnavailableNotificationServiceException extends RuntimeException{
    public UnavailableNotificationServiceException(){
        super("Unstable or unavailable notification service");
    }

    public UnavailableNotificationServiceException(String message){
        super(message);
    }
}
