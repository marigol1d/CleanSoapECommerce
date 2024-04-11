package com.cleansoap.coursework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Глобальный контроллер, можно обрабатывать несколько исключений
public class ClientExceptionHandler {

    @ExceptionHandler(value = {ClientNotFoundException.class}) // {} - список исключений, если надо еще одно исключение, то через запятую указываем еще один класс
    public ResponseEntity<Object> handlerClientNotFoundException
            (ClientNotFoundException clientNotFoundException)
    { // Возвращаем объект в виде ResponseEntity
        ClientException clientException = new ClientException(
                // 1 Любое сообщение, котор. мы хотим вернуть, придет сюда
                clientNotFoundException.getMessage(),
                clientNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
                );

        return new ResponseEntity<>(clientException, HttpStatus.NOT_FOUND);
    }
}
