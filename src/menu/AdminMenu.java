package menu;

import java.util.Scanner;
import model.Admin;
import service.SBNService;
import service.SahamService;

public class AdminMenu {
    public static void showMenu(Scanner scanner, Admin admin) {
        while (true) {
            System.out.println("||=====================================================================||");
            System.out.println("||                               MENU ADMIN                            ||");
            System.out.println("||=====================================================================||");
            System.out.println("|| 1. Saham                                                            ||");
            System.out.println("|| 2. SBN                                                              ||");
            System.out.println("|| 3. Logout                                                           ||");
            System.out.println("||=====================================================================||");

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
            System.out.println("||=====================================================================||");
            System.out.println("||                                 SAHAM                               ||");
            System.out.println("||=====================================================================||");
            System.out.println("|| 1. Tambah Saham                                                     ||");
            System.out.println("|| 2. Ubah Harga Saham                                                 ||");
            System.out.println("|| 3. hapus Saham                                                      ||");
            System.out.println("|| 4. Kembali                                                          ||");
            System.out.println("||=====================================================================||");

            int pilihan = MenuUtil.getPilihan(scanner, 4);
            switch (pilihan) {
                case 1 -> SahamService.tambahSaham(scanner);
                case 2 -> SahamService.ubahHargaSaham(scanner);
                case 3 -> SahamService.hapusSaham(scanner);
                case 4 -> { return; }
            }
        }
    }


    private static void showSBNMenu(Scanner scanner) {
        while (true) {
            System.out.println("||=====================================================================||");
            System.out.println("||                                 SBN                                 ||");
            System.out.println("||=====================================================================||");
            System.out.println("|| 1. Tambah SBN                                                       ||");
            System.out.println("|| 2. Hapus SBN                                                        ||");
            System.out.println("|| 3. Kembali                                                          ||");
            System.out.println("||=====================================================================||");
            int pilihan = MenuUtil.getPilihan(scanner, 3);
            switch (pilihan) {
                case 1 -> SBNService.tambahSBN(scanner);
                case 2 -> SBNService.hapusSBN(scanner);
                case 3 -> { return; }
            }
        }
    }
}
