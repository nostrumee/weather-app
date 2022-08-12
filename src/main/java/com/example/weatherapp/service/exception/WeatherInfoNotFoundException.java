package com.example.weatherapp.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class WeatherInfoNotFoundException extends RuntimeException {

    public WeatherInfoNotFoundException(String message) {
        super(message);
    }

}
