package menu;

import model.Admin;
import service.SahamService;
import service.SBNService;

import java.util.Scanner;

public class AdminMenu {
    public static void showMenu(Scanner scanner, Admin admin) {
        while (true) {
            System.out.println("\n|====== MENU ADMIN ======|");
            System.out.println("| 1. Saham               |");
            System.out.println("| 2. SBN                 |");
            System.out.println("| 3. Logout              |");
            System.out.println("|========================|");


            int pilihan = MenuUtil.getPilihan(scanner, 3);
            if (pilihan == 1) {
                showSahamMenu(scanner);
            } else if (pilihan == 2) {
                showSBNMenu(scanner);
            } else if (pilihan == 3) {
                break;
            }
        }
    }

    private static void showSahamMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n|------- Saham -------|");
            System.out.println("| 1. Tambah Saham     |");
            System.out.println("| 2. Ubah Harga Saham |");
            System.out.println("| 3. Kembali          |");
            System.out.println("|---------------------|");


            int pilihan = MenuUtil.getPilihan(scanner, 3);
            if (pilihan == 1) {
                SahamService.tambahSaham(scanner);
            } else if (pilihan == 2) {
                SahamService.ubahHargaSaham(scanner);
            } else if (pilihan == 3) {
                break;
            }
        }
    }

    private static void showSBNMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n|-------- SBN --------|");
            System.out.println("| 1. Tambah SBN       |");
            System.out.println("| 2. Kembali          |");
            System.out.println("|---------------------|");


            int pilihan = MenuUtil.getPilihan(scanner, 2);
            if (pilihan == 1) {
                SBNService.tambahSBN(scanner);
            } else if (pilihan == 2) {
                break;
            }
        }
    }
}
