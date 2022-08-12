package com.example.weatherapp.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    private String city;

    private String temperature;

    @PrePersist
    public void setCreationDate() {
        this.creationDate = LocalDateTime.now();
    }

}
