package com.sda.weather.localization;

import java.util.Collections;
import java.util.List;

public class LocalizationRepositoryMock implements LocalizationRepositoryInt {

    @Override
    public Localization save(Localization localization) {
        localization.setId(1L);
        return localization;
    }

    @Override
    public List<Localization> findAll() {
        return Collections.emptyList();
    }
}
