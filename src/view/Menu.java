package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {

    private static final Scanner sc = new Scanner(System.in);
    private String header;
    private List<MenuItem> menuItems;
    private String choice;
    private String exitChoice;

    public void print() {
        System.out.println(header);
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getButton() + " - " + menuItem.getName());
        }
        System.out.print("Enter your choice: ");
    }

    public Menu(String header, String exitChoice) {
        setHeader(header);
        this.menuItems = new ArrayList<>();
        this.exitChoice = exitChoice;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice() {
        this.choice = sc.nextLine();
    }

    public void resetChoice(){
        this.choice = "";
    }

    public String getExitChoice() {
        return exitChoice;
    }

    public void setExitChoice(String exitChoice) {
        this.exitChoice = exitChoice;
    }
}
