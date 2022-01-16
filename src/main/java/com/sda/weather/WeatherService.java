package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final ObjectMapper objectMapper;

    List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }

    Weather createWeather(float latitude, float longitude, String city, String country) {
        if (city == null || country == null || city.isBlank() || country.isBlank() || latitude > 90 || latitude < -90 || longitude > 180 || longitude < -180) {
            throw new IllegalArgumentException("Walidacja danych nie powiodła się");
        }

        Weather weather = new Weather();
        weather.setCity(city);
        weather.setCountry(country);
        weather.setLatitude(latitude);
        weather.setLongitude(longitude);

        try {
            HttpClient client = HttpClient.newHttpClient();
            String apiKey = "1c5c10a2d8cdf099564d8e58cc5b0d0a";
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            WeatherDTO weatherDto = objectMapper.readValue(body, WeatherDTO.class);

        } catch (Exception e) {
            throw new IllegalArgumentException("Komunikacja z serwerem pogodowym nie powiodła się");
        }

        Weather savedWeather = weatherRepository.save(weather);
        return savedWeather;
    }
}
