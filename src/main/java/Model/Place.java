package Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class Place {
    private int id;
    private Room room;
    private BigDecimal price;
    private int placeNumber;
    private Date date;
    private Status status;

    public Place(int id, Room room, BigDecimal price, int placeNumber, Date date, Status status) {
        this.id = id;
        this.room = room;
        this.price = price;
        this.placeNumber = placeNumber;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nPlace Id:" + id +
                "\nCoworking Name: " + room.getCoworking().getName() +
                "\nCoworking Address: "+room.getCoworking().getAddress()+
                "\nRoom Name: "+ room.getName()+
                "\nPlace Number: " + placeNumber +
                "\nPrice: " + price +
                "\nDate: " + date +
                "\nStatus=" + status +
                "\n - - - - - - - - - - - - - -";
    }

    public static int currentId = 1;
    {
        currentId++;
    }
}
