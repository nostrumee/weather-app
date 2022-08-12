package com.example.weatherapp.controller;

import com.example.weatherapp.model.dto.CreatedWeatherInfoDto;
import com.example.weatherapp.service.WeatherInfoWorkflow;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

import static com.example.weatherapp.config.Constants.WEATHER_TASK_LIST;

@RestController
public class WeatherInfoController {

    private final WorkflowClient workflowClient;

    @Autowired
    public WeatherInfoController(WorkflowClient workflowClient) {
        this.workflowClient = workflowClient;
    }

    @GetMapping("/info")
    public ResponseEntity<CreatedWeatherInfoDto> startWorkflow(@RequestParam String city) {
        var workflow = workflowClient.newWorkflowStub(
                WeatherInfoWorkflow.class,
                new WorkflowOptions.Builder()
                        .setExecutionStartToCloseTimeout(Duration.ofSeconds(2))
                        .setTaskList(WEATHER_TASK_LIST)
                        .build()
        );
        var weatherInfo = workflow.processWeatherInfo(city);
        return ResponseEntity.ok(weatherInfo);
    }

}
