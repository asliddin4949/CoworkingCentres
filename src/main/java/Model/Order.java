package Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode

public class Order {
    private int id;
    private User user;
    private Place place;
    private BigDecimal sum;
    private Date Date;

    public Order(int id, User user, Place place, BigDecimal sum, java.util.Date date) {
        this.id = id;
        this.user = user;
        this.place = place;
        this.sum = sum;
        Date = date;
    }

    @Override
    public String toString() {
        return "\nOrder Id: " + id +
                "\nUser: " + user +
                "\nPlace: " + place +
                "\nSum: " + sum +
                "\nDate: " + Date +
                "\n- - - - - - - - - - -";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
