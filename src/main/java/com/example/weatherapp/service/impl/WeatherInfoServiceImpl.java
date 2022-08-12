package com.example.weatherapp.service.impl;

import com.example.weatherapp.model.dto.CreatedWeatherInfoDto;
import com.example.weatherapp.model.dto.WeatherInfoDto;
import com.example.weatherapp.model.jpa.WeatherInfo;
import com.example.weatherapp.repository.WeatherInfoRepository;
import com.example.weatherapp.service.OpenWeatherMapClient;
import com.example.weatherapp.service.WeatherInfoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherInfoServiceImpl implements WeatherInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherInfoServiceImpl.class);

    private final OpenWeatherMapClient openWeatherMapClient;
    private final WeatherInfoRepository weatherInfoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WeatherInfoServiceImpl(OpenWeatherMapClient openWeatherMapClient, WeatherInfoRepository weatherInfoRepository, ModelMapper modelMapper) {
        this.openWeatherMapClient = openWeatherMapClient;
        this.weatherInfoRepository = weatherInfoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public WeatherInfoDto getWeatherInfo(String cityName) {
        LOGGER.info("Retrieving weather info for {}", cityName);
        return openWeatherMapClient.getWeatherInfo(cityName);
    }

    @Override
    public CreatedWeatherInfoDto saveWeatherInfo(WeatherInfoDto weatherInfoDto) {
        LOGGER.info("Saving weather info in database");
        WeatherInfo weatherInfo = modelMapper.map(weatherInfoDto, WeatherInfo.class);
        weatherInfoRepository.save(weatherInfo);
        return modelMapper.map(weatherInfo, CreatedWeatherInfoDto.class);
    }

}
