package com.picpaysimplificado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class MerchantUserNotAuthorizedException extends RuntimeException{
    public MerchantUserNotAuthorizedException(){
        super("Merchant user is not authorized");
    }
    public MerchantUserNotAuthorizedException(String message){
        super(message);
    }
}
