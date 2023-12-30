package model.user;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserUtils {

    private static final Scanner sc = new Scanner(System.in);
    private final List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public UserUtils(List<User> users) {
        this.users = users;
    }

    public void signUp(List<User> users) {
        int lastUserId = users.getLast().getId();
        users.add(create(lastUserId + 1));
    }
    public User signIn(List<User> users) {
        User initialUser = null;
        System.out.println("Username:");
        String username = sc.nextLine();
        System.out.println("Password:");
        String password = sc.nextLine();
        for (User user : users) {
            if (Objects.equals(user.getUserName(), username) && Objects.equals(user.getPassword(), password)) {
                System.out.println("Success identification!");
                initialUser = user;
            }
        }
        return initialUser;
    }

    public User create(int id) {
        System.out.println("Username: ");
        String username = sc.nextLine();

        System.out.println("Password: ");
        String password = sc.nextLine();

        return new User(id, username, password, Role.REGULARUSER);
    }

    public void listAllUser() {
        System.out.println("List of All Users: ");
        System.out.printf("%-3s %-15s %-5s%n", "Id", "User Name", "Role");
        for (User user : users) {
            System.out.printf("%-3s %-15s %-5s%n", user.getId(), user.getUserName(), user.getRole().label);
        }
    }

    public void editUser() {
        User initialUser = null;
        System.out.println("Please enter the id of the user to be modified!");
        String id = sc.nextLine();
        for (User user : users) {
            if (Objects.equals(String.valueOf(user.getId()), id)) {
                initialUser = user;
                System.out.println("Please enter username: ");
                user.setUserName(sc.nextLine());
                System.out.println("Please enter password: ");
                user.setPassword(sc.nextLine());
            }
        }
        if (initialUser == null) System.out.println("There was no user found with specified id: " + id);
    }

    public void deleteUser(User loggedInUser) {
        User initialUser = null;
        System.out.println("Please enter the id of the user to be deleted!");
        String id = sc.nextLine();
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (Objects.equals(String.valueOf(user.getId()), id)) {
                if (!Objects.equals(loggedInUser.getId(), user.getId())) {
                    initialUser = user;
                    iterator.remove();
                    System.out.println("User deleted successfully!");
                    break;
                } else {
                    System.out.println("Don't try to delete yourself! :-)");
                    initialUser = user;
                }
            }
        }
        if (initialUser == null) System.out.println("There was no user found with specified id: " + id);
    }

    public User getUserById(List<User> users, String userId){
        for (User user : users) {
            if (String.valueOf(user.getId()).equals(userId)) return user;
        }
        return null;
    }
}
