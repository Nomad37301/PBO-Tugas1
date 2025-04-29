package menu;

import model.Customer;
import service.PortofolioService;
import service.SahamService;
import service.SBNService;

import java.util.Scanner;

public class CustomerMenu {
    public static void showMenu(Scanner scanner, Customer customer) {
        while (true) {
            System.out.println("||=====================================================================||");
            System.out.println("||                            MENU CUSTOMER                            ||");
            System.out.println("||=====================================================================||");
            System.out.println("|| 1. Beli Saham                                                       ||");
            System.out.println("|| 2. Jual Saham                                                       ||");
            System.out.println("|| 3. Beli SBN                                                         ||");
            System.out.println("|| 4. Simulasi SBN                                                     ||");
            System.out.println("|| 5. Portofolio                                                       ||");
            System.out.println("|| 6. Logout                                                           ||");
            System.out.println("||=====================================================================||");

            int pilihan = MenuUtil.getPilihan(scanner, 6);
            switch (pilihan) {
                case 1 -> SahamService.beliSaham(scanner, customer);
                case 2 -> SahamService.jualSaham(scanner, customer);
                case 3 -> SBNService.beliSBN(scanner, customer);
                case 4 -> SBNService.simulasiKupon(scanner, customer);
                case 5 -> PortofolioService.tampilkanPortofolio(customer);
                case 6 -> {
                    return;
                }
            }
        }
    }
}
