package com.sda.weather.localization;

import lombok.Data;

@Data
public class LocalizationDTO {
    private Long id;
    private String city;
    private String country;
    private String region;
    private Float latitude;
    private Float longitude;

}
