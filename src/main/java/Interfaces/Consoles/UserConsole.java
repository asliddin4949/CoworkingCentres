package Interfaces.Consoles;

import Interfaces.Console;
import Interfaces.Implements.UserService;
import Model.User;

import java.util.Scanner;

public class UserConsole implements Console {

    private static UserConsole userConsole;

    public static UserConsole getInstance() {

        if (userConsole == null) {
            userConsole = new UserConsole();
        }
        return userConsole;
    }


    @Override
    public void openConsole(User user) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - Order Place  '2' - Order History  '0' - exit");
            int command = scanner.nextInt();

            if (command == 1) {
                UserService.getInstance().orderPlace(user);
            } else if (command == 2) {
                UserService.getInstance().showMyOrders(user);
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong Command!");
            }


        }


    }
}
