package com.example.weatherapp.service;

import com.example.weatherapp.model.dto.CreatedWeatherInfoDto;
import com.example.weatherapp.model.dto.WeatherInfoDto;
import com.uber.cadence.activity.ActivityMethod;

public interface WeatherInfoActivities {

    WeatherInfoDto getWeatherInfo(String cityName);

    CreatedWeatherInfoDto saveWeatherInfo(WeatherInfoDto weatherInfoDto);

}
