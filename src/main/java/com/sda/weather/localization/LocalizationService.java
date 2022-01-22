package com.sda.weather.localization;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LocalizationService {

    private final LocalizationRepositoryInt localizationRepository;
    private final ObjectMapper objectMapper;

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

        return localizationRepository.save(localization);
    }

    List<Localization> getAllLocalizations() {
        List<Localization> localizations = localizationRepository.findAll();
        return localizations;
    }
}
