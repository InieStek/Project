package com.sda.weather;

import lombok.Data;

@Data
public class WeatherDTO {

    public class Main {
        private double temp;
        private int pressure;
        private int humidity;
    }
    public class Wind{
        private double speed;
    }
}
