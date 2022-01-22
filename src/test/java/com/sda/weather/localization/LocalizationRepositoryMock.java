package com.sda.weather.localization;

public class LocalizationRepositoryMock implements LocalizationRepositoryInt {

    @Override
    public Localization save(Localization localization) {
        localization.setId(1L);
        return localization;
    }
}
