package com.example.weatherapp.service;

import com.example.weatherapp.model.dto.WeatherInfoDto;
import com.example.weatherapp.service.exception.WeatherInfoNotFoundException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class OpenWeatherMapClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapClient.class);
    private static final String API_KEY = "88167608f0a57963f5638235084eda08";
    private static final String NOT_FOUND_MESSAGE = "weather info not found";

    private final RestTemplate restTemplate;

    @Autowired
    public OpenWeatherMapClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherInfoDto getWeatherInfo(String cityName) {
        LOGGER.info("Retrieving weather info from API for {}", cityName);
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, API_KEY);

        try {
            ObjectNode weatherInfoFromAPI = restTemplate.getForObject(url, ObjectNode.class);
            String temperatureInKelvin = String.valueOf(weatherInfoFromAPI.get("main").get("temp"));
            String temperature = new BigDecimal(temperatureInKelvin).subtract(new BigDecimal("273.15")).toString();
            return new WeatherInfoDto(cityName, temperature);
        } catch (HttpClientErrorException.NotFound e) {
            throw new WeatherInfoNotFoundException(NOT_FOUND_MESSAGE);
        }
    }

}
