package Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private BigDecimal balance;
    private Role role;

    @Override
    public String toString() {
        return "\nUser Id: " + id +
                "\nName: " + name +
                "\nBalance: " + balance +
                "\nRole: " + role +
                "\n- - - - - - - - - - - - ";
    }


    public User(int id, String name, String login, String password, BigDecimal balance, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }

    public static int currentId = 0;

    {
        currentId++;
    }
}
