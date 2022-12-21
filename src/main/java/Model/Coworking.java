package Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

public class Coworking {
    private int id;
    private String name;
    private String address;

    public Coworking(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nCoworking Id: " + id +
                "\nName: " + name +
                "\nAddress: " + address +
                "\n - - - - - - - - - - - ";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
