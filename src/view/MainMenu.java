package view;

import java.util.List;

public class MainMenu extends Menu{
    public MainMenu() {
        super("Main menu: ", "x");
        MenuItem menuItem1 = new MenuItem("a", "Register");
        MenuItem menuItem2 = new MenuItem("b", "Login");
        MenuItem menuItem3 = new MenuItem("x", "Exit");
        getMenuItems().addAll(List.of(menuItem1, menuItem2, menuItem3));
    }

}