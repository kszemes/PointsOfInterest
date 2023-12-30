package view;

import java.util.List;

public class UserMenu extends Menu{
    public UserMenu() {
        super("User menu: ", "x");
        MenuItem menuItem1 = new MenuItem("a", "Search for points of interest by location ");
        MenuItem menuItem2 = new MenuItem("b", "Search for points of interest by type ");
        MenuItem menuItem3 = new MenuItem("c", "Like a points of interest ");
        MenuItem menuItem4 = new MenuItem("d", "Add comment to a points of interest ");
        MenuItem menuItem5 = new MenuItem("e", "Edit comment of a points of interest ");
        MenuItem menuItem6 = new MenuItem("f", "View My Previous Comments ");
        MenuItem menuItem7 = new MenuItem("x", "Exit ");
        getMenuItems().addAll(List.of(menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6, menuItem7));
    }
}