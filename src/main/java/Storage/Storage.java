package Storage;

import Model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static User admin = new User(0, "Asliddin", "admin","admin1", BigDecimal.ZERO, Role.ADMIN);
    public static List<User> users = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();
    public static List<Coworking> coworking = new ArrayList<>();
    public static List<CoworkingManager> coworkingManagers = new ArrayList<>();
    public static List<Place> places = new ArrayList<>();


}
