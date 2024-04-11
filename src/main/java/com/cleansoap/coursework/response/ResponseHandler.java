package com.cleansoap.coursework.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler { // Обработчик ответов
    // Статический метод для генерации ответа
    public static ResponseEntity<Object> responseBuilder(
            String message, HttpStatus httpStatus, Object responseObject){ // В качестве ответа мы получаем объект из БД
        Map<String, Object> response = new HashMap<>(); // Карта с 3 ключами
        // Помещаем значения
        response.put("message", message); // Можем указать другое имя ключа
        response.put("httpStatus", httpStatus);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }
}
