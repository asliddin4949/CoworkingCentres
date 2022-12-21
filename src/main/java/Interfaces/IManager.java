package Interfaces;

import Model.Coworking;
import Model.User;

import java.text.ParseException;

public interface IManager {
    void showCoworking(User user);
    void addRoom(User user);
    void showPlacesStatus(User user);

}
