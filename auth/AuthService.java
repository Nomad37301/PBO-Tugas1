package auth;

import model.Admin;
import model.Customer;
import model.User;
import java.util.Scanner;

public class AuthService {
    // Hardcoded users
    private static final String adminUsername = "admin";
    private static final String adminPassword = "admin123";

    private static final String custUsername = "customer";
    private static final String custPassword = "cust123";

    

    public static User login(Scanner scanner) {
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        if (user.equals(adminUsername) && pass.equals(adminPassword)) {
            return new Admin(adminUsername);
        } else if (user.equals(custUsername) && pass.equals(custPassword)) {
            return new Customer(custUsername);
        }
        return null;
    }
}
