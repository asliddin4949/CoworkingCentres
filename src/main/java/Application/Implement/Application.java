package Application.Implement;

import Interfaces.Implements.SignInSignUpService;
import Application.MainMenu;

import java.util.Scanner;

public class Application implements MainMenu {
    private static Application application;

    public static Application getInstance() {
        if (application == null) {
            application = new Application();
        }
        return application;
    }

    @Override
    public void applicationStart() {
        while (true) {
            System.out.println("'1' - sign in  '2' - sign up  '0' - exit ");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
                SignInSignUpService.getInstance().signIn();
            } else if (command == 2) {
                SignInSignUpService.getInstance().signUp();
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong Command!");
            }
        }
    }
}
