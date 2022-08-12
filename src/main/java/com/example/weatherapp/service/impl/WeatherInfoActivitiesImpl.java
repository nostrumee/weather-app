package com.example.weatherapp.service.impl;

import com.example.weatherapp.model.dto.CreatedWeatherInfoDto;
import com.example.weatherapp.model.dto.WeatherInfoDto;
import com.example.weatherapp.service.WeatherInfoService;
import com.example.weatherapp.service.WeatherInfoActivities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoActivitiesImpl implements WeatherInfoActivities {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherInfoActivitiesImpl.class);

    private final WeatherInfoService weatherInfoService;

    @Autowired
    public WeatherInfoActivitiesImpl(WeatherInfoService weatherInfoService) {
        this.weatherInfoService = weatherInfoService;
    }

    @Override
    public WeatherInfoDto getWeatherInfo(String cityName) {
        LOGGER.info("Starting getWeatherInfo activity");
        return weatherInfoService.getWeatherInfo(cityName);

    }

    @Override
    public CreatedWeatherInfoDto saveWeatherInfo(WeatherInfoDto weatherInfoDto) {
        LOGGER.info("Starting saveWeatherInfo activity");
        return weatherInfoService.saveWeatherInfo(weatherInfoDto);
    }

}
