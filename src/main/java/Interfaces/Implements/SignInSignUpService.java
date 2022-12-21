package Interfaces.Implements;

import Interfaces.Consoles.AdminConsole;
import Interfaces.Consoles.ManagerConsole;
import Interfaces.Consoles.UserConsole;
import Interfaces.SignInSignUp;
import Model.Role;
import Model.User;
import Storage.Storage;

import java.math.BigDecimal;
import java.util.Scanner;


public class SignInSignUpService implements SignInSignUp {

    private static SignInSignUpService signInSignUp;

    public static SignInSignUpService getInstance() {

        if (signInSignUp == null) {
            signInSignUp = new SignInSignUpService();
        }
        return signInSignUp;

    }

    @Override
    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("username:");
        String username = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();

        User checkUser = Storage.users.stream().filter(user ->
                        user.getLogin().equals(username) && user.getPassword().equals(password))
                .findFirst().orElse(null);
        if (Storage.admin.getLogin().equals(username) && Storage.admin.getPassword().equals(password)) {
            AdminConsole.getInstance().openConsole(Storage.admin);
        } else if (checkUser == null) {
            System.out.println("You Entered Wrong Login or Password!");
        } else if (checkUser.getRole().equals(Role.MANAGER)) {
            ManagerConsole.getInstance().openConsole(checkUser);
        } else {
            UserConsole.getInstance().openConsole(checkUser);
        }
    }


    @Override
    public User signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.nextLine();
        User checkUser = Storage.users.stream().filter(user -> user.getLogin().equals(username)).findFirst().orElse(null);
        if (checkUser == null) {
            System.out.println("Password: ");
            String password = scanner.nextLine();
            System.out.println("Name: ");
            String name = scanner.nextLine();
            User registeredUser = new User(User.currentId, name, username, password, BigDecimal.valueOf(350_000), Role.USER);
            Storage.users.add(registeredUser);
            System.out.println("Successfully Signed Up");
            return registeredUser;
        } else {
            System.out.println("This username exists");
            return null;
        }
    }
}
