package com.picpaysimplificado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedTransactionException extends RuntimeException{
    public UnauthorizedTransactionException() {
        super("Unauthorized Transaction");
    }

    public UnauthorizedTransactionException(String message){
        super(message);
    }
}
