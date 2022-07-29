package com.pmart5a.sprbootresthw.advice;

import com.pmart5a.sprbootresthw.exception.InvalidCredentials;
import com.pmart5a.sprbootresthw.exception.UnauthorizedUser;
import com.pmart5a.sprbootresthw.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<Message> invalidCredentials(InvalidCredentials exception) {
        Message message = new Message(exception.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<Message> mismatchException(UnauthorizedUser exception) {
        Message message = new Message(exception.getMessage());
        System.out.println(message);
        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    }
}