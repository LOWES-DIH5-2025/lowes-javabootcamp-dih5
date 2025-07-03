package com.labs.sboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GreetingsExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> handleException(Exception e) {
        ResponseMessage responseMessage = new ResponseMessage("ERROR", "GENERIC: An unexpected error occurred: " + e.getMessage());
        return ResponseEntity.internalServerError().body(responseMessage);
    }

}
