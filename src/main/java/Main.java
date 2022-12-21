import Interfaces.Consoles.Application;
import Interfaces.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = Application.getInstance();
        mainMenu.applicationStart();
    }
}
