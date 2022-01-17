package com.sda.frontend;

import com.sda.weather.WeatherController;
import lombok.RequiredArgsConstructor;

import java.util.InputMismatchException;
import java.util.Scanner;

@RequiredArgsConstructor
public class UserInterface extends InputMismatchException {

    private final WeatherController weatherController;

    public void run() {

        System.out.println("Aplikacja jest uruchomiona\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Witaj w aplikacji WeatherApp!, co chcesz zrobić?");
            System.out.println("1. Dodanie konkretnej lokalizacji");
            System.out.println("2. Wyszukaj pogodę");
            System.out.println("3. Pobierz wartość pogody");
            System.out.println("0. Wyjdź z aplikacji");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createLocalization();
                    break;
                case 2:
                    getAllLocalizations();
                    break;
                case 3:

                    break;
                case 0:
                    System.out.println("Do zobaczenia!");
                    System.exit(0);
            }
            System.out.println();
        }
    }

    private void getAllLocalizations() {
        String localizations = weatherController.getAllLocalizations();
        System.out.println("Odpowiedź serwera: " + localizations);
    }


    private void createLocalization() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);
        System.out.println("Podaj nazwę miasta:");
        String city = scanner.nextLine();
        System.out.println("Podaj nazwę państwa:");
        String country = scanner.nextLine();
        System.out.println("Podaj nazwę regionu:");
        String region = scanner.nextLine();

        System.out.println("Podaj długość geograficzną:");
        Float longitude = scanner.nextFloat();

        System.out.println("Podaj szerokość geograficzną:");
        Float latitude = scanner.nextFloat();

        String requestBody = String.format("{\"city\":\"%s\",\"country\":\"%s\",\"region\":\"%s\",\"longitude\":%s,\"latitude\":%s}", city, country, region, longitude, latitude);
        String responseBody = weatherController.createLocalization(requestBody);
        System.out.println("Odpowiedź serwera: " + responseBody);
    }
}
