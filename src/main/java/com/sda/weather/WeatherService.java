package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final ObjectMapper objectMapper;
}
