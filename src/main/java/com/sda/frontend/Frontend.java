package com.sda.frontend;

import com.sda.weather.WeatherService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class Frontend {

    public void run() {
        System.out.println("Aplikacja jest uruchomiona\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Witaj w aplikacji WeatherApp!, co chcesz zrobić?");
            System.out.println("1. Wyszukaj pogodę");
            System.out.println("2. Dodanie konkretnej lokaizacji");
            System.out.println("3. Pobierz wartość pogody");
            System.out.println("0. Wyjdź z aplikacji");

            int option = scanner.nextInt();

//            switch (option) {
//                case 1:
//                    createWeather();
//                    break;
//                case 2:
//                    addLocation();
//                    break;
//                case 3:
//                    getWeather();
//                    break;
//                case 0:
//                    System.out.println("Do zobaczenia!");
//                    System.exit(0);
//            }
//            System.out.println();
        }
    }

//    private void createWeather() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj nazwę miasta: ");
//        String city = scanner.nextLine();
//        System.out.println("Podaj kraj: ");
//        String country = scanner.nextLine();
//
//    }
//
//    private void getWeather() {
//        String weather = WeatherService.getWeather();
//        System.out.println("Odpowiedź serwera: " + weather);
//    }
//
//    private void addLocation() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj nazwę miasta: ");
//        String city = scanner.nextLine();
//        System.out.println("Podaj nazwe regionu: ");
//        String region = scanner.nextLine();
//        System.out.println("Podaj nazwę kraju: ");
//        String country = scanner.nextLine();
//        String requestBody = String.format("{\"city\":\"%s\",\"region\":\"%s\",\"country\":\"%s\"}", city, region, country);
//        String response = WeatherService.addLocation(requestBody);
//        System.out.println("Odpowiedź serwera: " + response);
//
//    }
}
