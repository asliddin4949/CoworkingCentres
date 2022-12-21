package Interfaces.Implements;

import Interfaces.IAdmin;
import Model.Coworking;
import Model.CoworkingManager;
import Model.Role;
import Model.User;
import Storage.Storage;

import java.math.BigDecimal;
import java.util.Scanner;

public class AdminService implements IAdmin {

    private static AdminService adminService;

    public static AdminService getInstance() {

        if (adminService == null) {
            adminService = new AdminService();
        }
        return adminService;
    }

    @Override
    public void addManager() {
        User user = SignInSignUpService.getInstance().signUp();
        for (User user1 : Storage.users) {
            if (user1.equals(user)) {
                user1.setRole(Role.MANAGER);
                user1.setBalance(BigDecimal.ZERO);
            }
        }
    }

    public void addCoworking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name:");
        String name = scanner.nextLine();
        Coworking coworking = Storage.coworking.stream().filter(coworking1 ->
                coworking1.getName().equals(name)).findFirst().orElse(null);

        if (coworking == null) {
            System.out.println("Address:");
            String address = scanner.nextLine();
            Storage.coworking.add(new Coworking(Coworking.currentId, name, address));
            System.out.println("Coworking added!");

        } else {
            System.out.println("This name exists in Coworking List!");
        }
    }

    @Override
    public void addManagerToCoworking() {
        for (User user : Storage.users) {
            if (user.getRole().equals(Role.MANAGER)) {
                System.out.println(user);
            }
        }
        System.out.println("Enter Manager Id:");
        Scanner scanner = new Scanner(System.in);
        int managerId = scanner.nextInt();
        User manager = Storage.users.stream().filter(user ->
                user.getId() == managerId).findFirst().orElse(null);
        if (manager == null) {
            System.out.println("Wrong Manager Id");
        } else {
            Storage.coworking.forEach(System.out::println);
            System.out.println("Enter Coworking Id:");
            int coworkingId = scanner.nextInt();
            Coworking coworking = Storage.coworking.stream().filter(coworking1 ->
                    coworking1.getId() == coworkingId).findFirst().orElse(null);

            if (coworking == null) {
                System.out.println("Wrong Coworking Id");
            } else {
                CoworkingManager coworkingManager = Storage.coworkingManagers.stream().filter(coworkingManager1 ->
                                coworkingManager1.getCoworking().equals(coworking) && coworkingManager1.getUser().equals(manager))
                        .findFirst().orElse(null);

                if (coworkingManager == null) {
                    Storage.coworkingManagers.add(new CoworkingManager(CoworkingManager.currentId, coworking, manager));
                    System.out.println("Manager Added To Coworking");
                }else {
                    System.out.println("This manager is already manager of this Coworking!");
                }
            }

        }
    }
}
