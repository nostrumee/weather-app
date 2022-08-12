package com.example.weatherapp.service;

import com.example.weatherapp.model.dto.CreatedWeatherInfoDto;
import com.example.weatherapp.model.dto.WeatherInfoDto;

public interface WeatherInfoService {

    WeatherInfoDto getWeatherInfo(String cityName);

    CreatedWeatherInfoDto saveWeatherInfo(WeatherInfoDto weatherInfoDto);

}
