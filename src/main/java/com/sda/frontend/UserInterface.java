package com.sda.frontend;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class UserInterface {

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

                    break;
                case 2:

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
}
