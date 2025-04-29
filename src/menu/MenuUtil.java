package menu;

import java.util.Scanner;

public class MenuUtil {
    //Exception Handling Khusus Menu
    public static int getPilihan(Scanner scanner, int max) {
        System.out.print("Pilih: ");
        try {
            int pilihan = Integer.parseInt(scanner.nextLine());
            if (pilihan >= 1 && pilihan <= max) {
                return pilihan;
            }
        } catch (NumberFormatException e) {
            // no-op
        }
        System.out.println("Input tidak valid.\n");
        pressEnter(scanner);
        clearScreen();
        return -1;
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (Exception ex) {
        }
    }

    public static void pressEnter(Scanner scanner) {
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    // Exception Handling General, Bisa Digunakan Selain Menu
    public static int getIntegerInput(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) return value;
            } catch (NumberFormatException ignored) {
            }

            System.out.println("Input tidak valid. Masukkan angka antara " + min + " - " + max + ".");
            pressEnter(scanner);
            clearScreen();
        }
    }
}