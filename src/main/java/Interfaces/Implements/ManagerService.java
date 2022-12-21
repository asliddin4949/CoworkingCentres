package Interfaces.Implements;

import Interfaces.IManager;
import Model.*;
import Storage.Storage;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class ManagerService implements IManager {

    private static ManagerService managerService;

    public static ManagerService getInstance() {

        if (managerService == null) {
            managerService = new ManagerService();
        }
        return managerService;
    }

    @Override
    public void showCoworking(User user) {

        for (CoworkingManager coworkingManager : Storage.coworkingManagers) {
            if (coworkingManager.getUser().equals(user)) {
                System.out.println(coworkingManager.getCoworking());
            }
        }

    }

    @SneakyThrows
    @Override
    public void addRoom(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        for (CoworkingManager coworkingManager : Storage.coworkingManagers) {
            if (coworkingManager.getUser().equals(user)) {
                System.out.println(coworkingManager.getCoworking());
                flag = false;
            }
        }
        if (flag) {
            System.out.println("You do not have any coworking!");
        } else {
            System.out.println("Enter coworking Id:");
            int id = scanner.nextInt();
            Coworking coworking = Storage.coworking.stream().filter(coworking1 ->
                    coworking1.getId() == id).findFirst().orElse(null);

            if (coworking == null) {
                System.out.println("Wrong Id!");
            } else {
                scanner = new Scanner(System.in);
                System.out.println("Name:");
                String name = scanner.nextLine();
                scanner = new Scanner(System.in);
                System.out.println("Floor:");
                int floor = scanner.nextInt();
                System.out.println("Number Of Places:");
                int numberPlaces = scanner.nextInt();
                System.out.println("Place Price:");
                BigDecimal price = scanner.nextBigDecimal();
                System.out.println("Enter Date(dd.MM.yyyy):");
                scanner = new Scanner(System.in);
                String dateIn = scanner.nextLine();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                Date date = simpleDateFormat.parse(dateIn);
                Room room = new Room(Room.currentId, name, coworking, floor, numberPlaces);
                Storage.rooms.add(room);
                for (int i = 1; i <= numberPlaces; i++) {
                    Storage.places.add(new Place(Place.currentId, room, price, i, date, Status.AVAILABLE));
                }
                System.out.println("Room added!");
            }
        }
    }

    @Override
    public void showPlacesStatus(User user) {
        showCoworking(user);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coworking Id:");
        int id = scanner.nextInt();
        Coworking coworking = Storage.coworking.stream().filter(coworking1 ->
                coworking1.getId() == id).findFirst().orElse(null);
        if (coworking == null) {
            System.out.println("Wrong Id!");
        } else {
            for (Room room : Storage.rooms) {
                if (room.getCoworking().equals(coworking)) {
                    System.out.println(room);
                }
            }
            System.out.println("Enter Room Id:");
            int roomId = scanner.nextInt();
            Room room = Storage.rooms.stream().filter(room1 -> room1.getId() == roomId).findFirst().orElse(null);

            if (room == null) {
                System.out.println("Wrong Id!");
            } else {
                for (Place place : Storage.places) {
                    if (place.getRoom().equals(room)) {
                        System.out.println(place);
                    }
                }
            }
        }
    }


}
