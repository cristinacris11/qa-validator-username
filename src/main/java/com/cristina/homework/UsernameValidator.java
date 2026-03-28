package com.cristina.homework;

import java.util.Scanner;

public class UsernameValidator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String username;
        boolean esteValid;

        do {
            System.out.print("Introdu un username: ");
            username = scanner.nextLine();
            esteValid = true;

            boolean areCifre = false;

            // 1. Verificare spatii + cifra
            for (int i = 0; i < username.length(); i++) {
                char c = username.charAt(i);

                // PRIORITATE: spatii
                if (c == ' ') {
                    System.out.println("Eroare: Username-ul nu poate contine spatii.");
                    esteValid = false;
                    break;
                }

                if (Character.isDigit(c)) {
                    areCifre = true;
                }
            }

            // daca are spatii, NU mai verificam nimic
            if (!esteValid) {
                continue;
            }

            // 2. Verificare lungime
            if (username.length() < 6 || username.length() > 12) {
                System.out.println("Eroare: Username-ul trebuie sa aiba intre 6 si 12 caractere.");
                esteValid = false;
                continue;
            }

            // 3. Verificare cifra
            if (!areCifre) {
                System.out.println("Eroare: Username-ul trebuie sa contina cel putin o cifra.");
                esteValid = false;
            }

        } while (!esteValid);

        System.out.println("Username acceptat: " + username);
        scanner.close();
    }
}