package com.sda.weather.localization;

import java.util.List;

public interface LocalizationRepositoryInt {

    public Localization save(Localization localization);

    List<Localization> findAll();
}
