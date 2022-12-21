package Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

public class CoworkingManager {
    private int id;
    private Coworking coworking;
    private User user;

    @Override
    public String toString() {
        return "\nCoworkingManager Id: " + id +
                "\nName: "+ user.getName()+
                "\nCoworking: " + coworking +
                "\n- - - - - - - - - - - - - -";
    }

    public CoworkingManager(int id, Coworking coworking, User user) {
        this.id = id;
        this.coworking = coworking;
        this.user = user;
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
