package Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode

public class Room {
    private int id;
    private String name;
    private Coworking coworking;
    private int floorNumber;
    private int numberOfPlaces;

    public Room(int id, String name, Coworking coworking, int floorNumber, int numberOfPlaces) {
        this.id = id;
        this.name = name;
        this.coworking = coworking;
        this.floorNumber = floorNumber;
        this.numberOfPlaces = numberOfPlaces;
    }

    @Override
    public String toString() {
        return "\nRoom Id:" + id +
                "\nName: " + name +
                "\nCoworking Name: " + coworking.getName() +
                "\nCoworking Address: " + coworking.getAddress() +
                "\nFloor Number: " + floorNumber +
                "\nNumber of Places: " + numberOfPlaces +
                "\n - - - - - - - - - - - - - - - - - -";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
