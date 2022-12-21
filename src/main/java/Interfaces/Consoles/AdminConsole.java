package Interfaces.Consoles;

import Interfaces.Console;
import Interfaces.Implements.AdminService;
import Model.User;

import java.util.Scanner;

public class AdminConsole implements Console {
    private static AdminConsole adminConsole;

    public static AdminConsole getInstance() {
        if (adminConsole == null) {
            adminConsole = new AdminConsole();
        }
        return adminConsole;
    }

    @Override
    public void openConsole(User user) {
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - add coworking '2' - add manager '3' - add manager to coworking '0' - exit" +
                    "\n'4' - show orders  '5' - show managers  '6' - show users");
            int command = scanner.nextInt();
            if (command == 1) {
                AdminService.getInstance().addCoworking();
            } else if (command == 2) {
                AdminService.getInstance().addManager();
            } else if (command == 3) {
                AdminService.getInstance().addManagerToCoworking();
            } else if (command==4) {
                AdminService.getInstance().showOrders();
            } else if (command==5) {
                AdminService.getInstance().showManager();
            } else if (command==6) {
                AdminService.getInstance().showUsers();
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong Command!");
            }

        }

    }
}
