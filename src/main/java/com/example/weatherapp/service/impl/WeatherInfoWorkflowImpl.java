package com.example.weatherapp.service.impl;

import com.example.weatherapp.model.dto.CreatedWeatherInfoDto;
import com.example.weatherapp.model.dto.WeatherInfoDto;
import com.example.weatherapp.service.WeatherInfoActivities;
import com.example.weatherapp.service.WeatherInfoWorkflow;
import com.uber.cadence.activity.ActivityOptions;
import com.uber.cadence.workflow.Workflow;
import lombok.Data;

import java.time.Duration;

@Data
public class WeatherInfoWorkflowImpl implements WeatherInfoWorkflow {

    private final ActivityOptions weatherInfoActivityOptions = new ActivityOptions.Builder()
            .setScheduleToCloseTimeout(Duration.ofSeconds(2))
            .build();

    private final WeatherInfoActivities weatherInfoActivities =
            Workflow.newActivityStub(WeatherInfoActivities.class, weatherInfoActivityOptions);

    @Override
    public CreatedWeatherInfoDto processWeatherInfo(String cityName) {
        WeatherInfoDto weatherInfoFromAPI = weatherInfoActivities.getWeatherInfo(cityName);
        return weatherInfoActivities.saveWeatherInfo(weatherInfoFromAPI);
    }

}
