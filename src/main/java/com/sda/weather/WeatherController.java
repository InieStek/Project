package com.sda.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;
    private final ObjectMapper objectMapper;

    public String createLocalization(String data) {
        try {
            Localization newLocalization = objectMapper.readValue(data, Localization.class);
            Localization localization = weatherService.createLocalization(newLocalization.getCity(), newLocalization.getCountry(), newLocalization.getRegion(), newLocalization.getLatitude(), newLocalization.getLongitude());
            return objectMapper.writeValueAsString(localization);
        } catch (IllegalArgumentException e) {
            return String.format("{\"message\": \"%s\"}", e.getMessage());
        } catch (JsonProcessingException e) {
            return String.format("{\"message\": \"%s\"}", e.getMessage());
        }
    }
}
