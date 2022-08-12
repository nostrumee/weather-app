package com.example.weatherapp.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(WeatherInfoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleWeatherInfoNotFound(WeatherInfoNotFoundException e, WebRequest request) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "404");
        response.put("message", e.getLocalizedMessage());
        return response;
    }
}
