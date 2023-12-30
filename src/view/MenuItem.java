package view;

public class MenuItem {

    private String button;
    private String name;

    public MenuItem(String button, String name) {
        this.button = button;
        this.name = name;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
