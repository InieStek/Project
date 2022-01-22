package com.sda.weather.localization;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class LocalizationServiceTest {

    LocalizationService localizationService;

    @BeforeEach
    void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        LocalizationRepositoryMock localizationRepositoryMock = new LocalizationRepositoryMock();
        localizationService = new LocalizationService(localizationRepositoryMock, objectMapper);
    }

    @Test
    void createLocalization_whenAllArgumentsAreProper_createsNewLocalization() {
        //when
        Localization localization = localizationService.createLocalization("Warszawa", "Poland"," ", 55.75F, 37.62F);
        //then
        assertThat(localization.getCity()).isEqualTo("Warszawa");
        assertThat(localization.getCountry()).isEqualTo("Poland");
        assertThat(localization.getRegion()).isBlank();
        assertThat(localization.getLatitude()).isEqualTo(55.75F);
        assertThat(localization.getLongitude()).isEqualTo(37.62F);
        assertThat(localization.getId()).isNotNull();
    }

    @Test
    void createLocalization_whenCityIsNull_throwsIllegalArgumentException() {
        //when
        Throwable throwable = catchThrowable(() -> localizationService.createLocalization(null, "Poland"," ", 55.75F, 37.62F));
        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
