package menu;

import java.util.Scanner;

public class MenuUtil {
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
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ex) {
            System.out.println("\n\n");
        }
    }

    public static void pressEnter(Scanner scanner) {
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }
}
