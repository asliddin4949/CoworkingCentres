package Interfaces.Consoles;

import Interfaces.Console;
import Interfaces.Implements.ManagerService;
import Model.User;

import java.util.Scanner;


public class ManagerConsole implements Console {

    private static ManagerConsole managerConsole;

    public static ManagerConsole getInstance() {

        if (managerConsole == null) {
            managerConsole = new ManagerConsole();
        }
        return managerConsole;
    }

    @Override
    public void openConsole(User user) {

        while (true){
            System.out.println("'1' - show my coworking list  '2' - add room to coworking  " +
                    "\n'3' - show room status  '0' - exit");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();

            if(command==1){
                ManagerService.getInstance().showCoworking(user);
            } else if (command==2) {
                ManagerService.getInstance().addRoom(user);
            } else if (command==3) {
                ManagerService.getInstance().showPlacesStatus(user);
            }else if(command==0){
                break;
            }else {
                System.out.println("Wrong command!");
            }


        }

    }
}
