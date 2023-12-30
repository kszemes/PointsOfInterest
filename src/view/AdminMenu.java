package view;

import java.util.List;

public class AdminMenu extends Menu{
    public AdminMenu() {
        super("Admin Menu: ", "x");
        MenuItem menuItem1 = new MenuItem("a", "List of all user ");
        MenuItem menuItem2 = new MenuItem("b", "Change User ");
        MenuItem menuItem3 = new MenuItem("c", "Delete User ");
        MenuItem menuItem4 = new MenuItem("d", "List of all unauthorised comments ");
        MenuItem menuItem5 = new MenuItem("e", "Authorize comment by Id ");
        MenuItem menuItem6 = new MenuItem("f", "Delete comment by Id ");
        MenuItem menuItem7 = new MenuItem("g", "Search for a comment by user Id ");
        MenuItem menuItem8 = new MenuItem("h", "Add a new Point Of Interest ");
        MenuItem menuItem9 = new MenuItem("x", "Exit ");
        getMenuItems().addAll(List.of(menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6, menuItem7, menuItem8, menuItem9));
    }

}