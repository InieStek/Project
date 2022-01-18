package com.sda.weather;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;

    // todo write some tests
    Localization createLocalization(String city, String country, String region, Float latitude, Float longitude) {
        if (city == null || country == null|| latitude == null || longitude == null || city.isBlank() || country.isBlank() || latitude > 90.0 || latitude < -90.0 || longitude > 180.0 || longitude < -180.0) {
            throw new IllegalArgumentException("Walidacja danych nie powiodła się"); // todo specify this message, what went wong?
        }
        Localization localization = new Localization();
        localization.setCity(city);
        localization.setCountry(country);
        localization.setRegion(region); // todo if it's eg. "   " it will be stored in the database, we want to avoid this
        localization.setLatitude(latitude);
        localization.setLongitude(longitude);

        return weatherRepository.save(localization);
    }
}
