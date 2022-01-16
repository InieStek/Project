package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;
    private final ObjectMapper objectMapper;
}
