package menu;

import auth.AuthService;
import model.Admin;
import model.Customer;
import model.User;

import java.util.Scanner;

public class LoginMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void show() {
        User user = null;
        while (true) {
            MenuUtil.clearScreen();
            System.out.println("||=====================================================================||");
            System.out.println("||                           SISTEM INVESTASI                          ||");
            System.out.println("||=====================================================================||");
            System.out.println("|| 1. Login                                                            ||");
            System.out.println("|| 2. Exit                                                             ||");
            System.out.println("||=====================================================================||");
            System.out.print("Pilih: ");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                MenuUtil.clearScreen();
                user = AuthService.login(scanner);

                if (user == null) {
                    System.out.println("||=====================================================================||");
                    System.out.println("|| Login gagal!                                                        ||");
                    System.out.println("||=====================================================================||");
                    MenuUtil.pressEnter(scanner);
                } else {
                    if (user instanceof Admin) {
                        AdminMenu.showMenu(scanner, (Admin) user);
                    } else if (user instanceof Customer) {
                        CustomerMenu.showMenu(scanner, (Customer) user);
                    }
                }
            } else if (input.equals("2")) {
                System.out.println("Terima kasih. Keluar...");
                break;
            } else {
                System.out.println("Input tidak valid.\n");
                MenuUtil.pressEnter(scanner);
            }
        }
    }
}
