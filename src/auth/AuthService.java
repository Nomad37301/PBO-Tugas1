package auth;

import model.Admin;
import model.Customer;
import model.User;
import java.util.Scanner;

public class AuthService {
    // Hardcoded users
    private static final String adminUsername = "GungPur";
    private static final String adminPassword = "Gungpur123";

    private static final String custUsername = "Jihan";
    private static final String custPassword = "Jihan123";

    

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
