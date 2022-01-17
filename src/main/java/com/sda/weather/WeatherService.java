package com.sda.weather;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;

    Localization createLocalization(String city, String country, String region, Float latitude, Float longitude) {
        if (city == null || country == null|| latitude == null || longitude == null || city.isBlank() || country.isBlank() || latitude > 90.0 || latitude < -90.0 || longitude > 180.0 || longitude < -180.0) {
            throw new IllegalArgumentException("Walidacja danych nie powiodła się");
        }
        Localization localization = new Localization();
        localization.setCity(city);
        localization.setCountry(country);
        localization.setRegion(region);
        localization.setLatitude(latitude);
        localization.setLongitude(longitude);

        Localization localizationSave = weatherRepository.save(localization);
        return localizationSave;
    }

    List<Localization> getAllLocalizations() {
        List<Localization> localizations = weatherRepository.findAll();
        return localizations;
    }
}
