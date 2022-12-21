package Interfaces.Implements;

import Interfaces.IUser;
import Model.*;
import Storage.Storage;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserService implements IUser {

    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    @Override
    public void orderPlace(User user) {
        Scanner scanner = new Scanner(System.in);
        Storage.coworking.forEach(System.out::println);
        System.out.println("Enter Coworking Id:");
        int coworkingId = scanner.nextInt();
        Coworking coworking = Storage.coworking.stream().filter(coworking1 ->
                coworking1.getId() == coworkingId).findFirst().orElse(null);
        if (coworking == null) {
            System.out.println("Wrong Coworking Id");
        } else {
            Room room = bookRoom(coworking);
            if (room == null) {
                System.out.println("Wrong Room Id!");
            } else {
                Place place = bookPlace(room);
                if (place == null) {
                    System.out.println("Wrong Place Id!");
                } else {
                    order(user, place);
                }
            }
        }

    }

    private void order(User user, Place place) {
        BigDecimal userBalance = user.getBalance();
        BigDecimal price = place.getPrice();
        int case1 = userBalance.compareTo(price);

        if (case1 == 1 || case1 == 0) {
            Order order = new Order(Order.currentId, user, place, price, place.getDate());
            for (User user1 : Storage.users) {
                if (user1.equals(user)) {
                    user1.setBalance(user1.getBalance().subtract(price));
                }
            }
            Storage.orders.add(order);
            for (Place place1 : Storage.places) {
                if (place1.equals(place)) {
                    place1.setStatus(Status.BOOKED);
                }
            }
            System.out.println("Thank You for Ordering Place!");
        } else {
            System.out.println("Not Enough Balance to Order Place");
        }
    }

    private Place bookPlace(Room room) {
        Scanner scanner = new Scanner(System.in);
        for (Place place : Storage.places) {
            if (place.getRoom().equals(room) && place.getStatus().equals(Status.AVAILABLE)) {
                System.out.println(place);
            }
        }
        int placeId = scanner.nextInt();
        return Storage.places.stream().filter(place -> place.getId() == placeId).findFirst().orElse(null);
    }

    private Room bookRoom(Coworking coworking) {
        Scanner scanner = new Scanner(System.in);
        for (Room room : Storage.rooms) {
            if (room.getCoworking().equals(coworking)) {
                System.out.println(room);
            }
        }
        System.out.println("Enter Room Id:");
        int roomId = scanner.nextInt();
        return Storage.rooms.stream().filter(room -> room.getId() == roomId).findFirst().orElse(null);
    }

    @Override
    public void showMyOrders(User user) {
        for (Order order : Storage.orders) {
            if (order.getUser().equals(user)) {
                System.out.println(order);
            }
        }
    }
}
