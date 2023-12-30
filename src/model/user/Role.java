package model.user;

public enum Role {

    ADMIN("Admin"),
    REGULARUSER("User");

    public final String label;

    private Role(String label) {
        this.label = label;
    }
}
