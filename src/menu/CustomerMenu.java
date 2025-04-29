package menu;

import model.Customer;
import service.PortofolioService;
import service.SahamService;
import service.SBNService;

import java.util.Scanner;

public class CustomerMenu {
    public static void showMenu(Scanner scanner, Customer customer) {
        while (true) {
            MenuUtil.clearScreen();
            System.out.println("||=====================================================================||");
            System.out.println("||                            MENU CUSTOMER                            ||");
            System.out.println("||=====================================================================||");
            System.out.println("|| 1. Beli Saham                                                       ||");
            System.out.println("|| 2. Jual Saham                                                       ||");
            System.out.println("|| 3. Portofolio                                                       ||");
            System.out.println("|| 4. Logout                                                           ||");
            System.out.println("||=====================================================================||");

            int pilihan = MenuUtil.getPilihan(scanner, 4);
            switch (pilihan) {
                case 1 -> showSahamMenu(scanner, customer);
                case 2 -> showSBNMenu(scanner, customer);
                case 3 -> {
                    MenuUtil.clearScreen();
                    PortofolioService.tampilkanPortofolio(customer);
                    MenuUtil.pressEnter(scanner);
                }
                case 4 -> {
                    return;
                }
            }
        }
    }

    private static void showSahamMenu(Scanner scanner, Customer customer) {
        while (true) {
            MenuUtil.clearScreen();
            System.out.println("||=====================================================================||");
            System.out.println("||                            MENU SAHAM                               ||");
            System.out.println("||=====================================================================||");
            System.out.println("|| 1. Beli Saham                                                       ||");
            System.out.println("|| 2. Jual Saham                                                       ||");
            System.out.println("|| 3. Logout                                                           ||");
            System.out.println("||=====================================================================||");

            int pilihan = MenuUtil.getPilihan(scanner, 3);
            switch (pilihan) {
                case 1 -> {
                    MenuUtil.clearScreen();
                    SahamService.beliSaham(scanner, customer);
                    MenuUtil.pressEnter(scanner);
                }
                case 2 -> {
                    MenuUtil.clearScreen();
                    SahamService.jualSaham(scanner, customer);
                    MenuUtil.pressEnter(scanner);
                }
                case 3 -> {
                    return;
                }
            }
        }
    }

    private static void showSBNMenu(Scanner scanner, Customer customer) {
        while (true) {
            MenuUtil.clearScreen();
            System.out.println("||=====================================================================||");
            System.out.println("||                            MENU SBN                                 ||");
            System.out.println("||=====================================================================||");
            System.out.println("|| 1. Beli SBN                                                         ||");
            System.out.println("|| 2. Simulasi SBN                                                     ||");
            System.out.println("|| 3. Logout                                                           ||");
            System.out.println("||=====================================================================||");

            int pilihan = MenuUtil.getPilihan(scanner, 3);
            switch (pilihan) {
                case 1 -> {
                    MenuUtil.clearScreen();
                    SBNService.beliSBN(scanner, customer);
                    MenuUtil.pressEnter(scanner);
                }
                case 2 -> {
                    MenuUtil.clearScreen();
                    SBNService.simulasiKupon(scanner, customer);
                    MenuUtil.pressEnter(scanner);
                }
                case 3 -> {
                    return;
                }
            }
        }
    }
}