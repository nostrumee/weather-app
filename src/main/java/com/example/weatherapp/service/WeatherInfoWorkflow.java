package com.example.weatherapp.service;

import com.example.weatherapp.model.dto.CreatedWeatherInfoDto;
import com.uber.cadence.workflow.WorkflowMethod;

public interface WeatherInfoWorkflow {

    @WorkflowMethod
    CreatedWeatherInfoDto processWeatherInfo(String cityName);

}
