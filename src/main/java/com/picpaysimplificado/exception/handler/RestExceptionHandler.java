package com.picpaysimplificado.exception.handler;

import com.picpaysimplificado.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
@RestController
public class RestExceptionHandler {

    @ExceptionHandler(InsufficientBalanceException.class)
    public final ResponseEntity<ExceptionResponse> handleInsufficientBalanceExceptions(
            InsufficientBalanceException e, WebRequest request
    ){
        ExceptionResponse er = new ExceptionResponse(
                Instant.now(),
                e.getMessage(),
                request.getDescription(false));

        return ResponseEntity.badRequest().body(er);
    }

    @ExceptionHandler(MerchantUserNotAuthorizedException.class)
    public final ResponseEntity<ExceptionResponse> handleMerchantUserNotAuthorizedExceptions(
            MerchantUserNotAuthorizedException e, WebRequest request
    ){
        ExceptionResponse er = new ExceptionResponse(
                Instant.now(),
                e.getMessage(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(er);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<ExceptionResponse> handleNoSuchElementExceptions(
            NoSuchElementException e, WebRequest request
    ){
        ExceptionResponse er = new ExceptionResponse(
                Instant.now(),
                e.getMessage(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }

    @ExceptionHandler(UnauthorizedTransactionException.class)
    public final ResponseEntity<ExceptionResponse> handleUnauthorizedTransactionExceptions(
            UnauthorizedTransactionException e, WebRequest request
    ){
        ExceptionResponse er = new ExceptionResponse(
                Instant.now(),
                e.getMessage(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(er);
    }

    @ExceptionHandler(UnavailableNotificationServiceException.class)
    public final ResponseEntity<ExceptionResponse> handleUnavailableNotificationServiceExceptions(
            UnavailableNotificationServiceException e, WebRequest request
    ){
        ExceptionResponse er = new ExceptionResponse(
                Instant.now(),
                e.getMessage(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }

    @ExceptionHandler(DocumentAlreadyRegisteredException.class)
    public final ResponseEntity<ExceptionResponse> handleDocumentAlreadyRegisteredExceptions(
            DocumentAlreadyRegisteredException e, WebRequest request
    ){
        ExceptionResponse er = new ExceptionResponse(
                Instant.now(),
                e.getMessage(),
                request.getDescription(false));
        System.out.println(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleGenericExceptions(
            Exception e, WebRequest request) {
        ExceptionResponse er = new ExceptionResponse(
                Instant.now(),
                e.getMessage(),
                request.getDescription(false));

        return ResponseEntity.internalServerError().body(er);
    }
}
