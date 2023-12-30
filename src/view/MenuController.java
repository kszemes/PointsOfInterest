package view;

import model.comment.Comment;
import model.comment.CommentUtils;
import model.poi.PoiUtils;
import model.poi.PointOfInterest;
import model.user.User;
import model.user.UserUtils;
import utils.DataSeeder;

import java.util.List;
import java.util.Objects;

public class MenuController {

    private static final List<User> users = DataSeeder.getUsers();
    private static final List<PointOfInterest> pois = DataSeeder.getPointsOfInterest();
    private static final List<Comment> comments = DataSeeder.getComments();
    private final UserUtils userUtils = new UserUtils(users);
    private final PoiUtils poiUtils = new PoiUtils(pois);
    private final CommentUtils commentUtils = new CommentUtils(comments, poiUtils, userUtils);
    private static final MainMenu mainMenu = new MainMenu();
    private static final AdminMenu adminMenu = new AdminMenu();
    private static final UserMenu userMenu = new UserMenu();

    public MenuController() {
        handleMenus();
    }

    public void handleMenus() {
        System.out.println("Welcome to Point Of Interest Application!");
        while (!Objects.equals(mainMenu.getExitChoice(), mainMenu.getChoice())) {
            mainMenu.print();
            mainMenu.setChoice();
            switch (mainMenu.getChoice()) {
                case "a" -> userUtils.signUp(users);
                case "b" -> {
                    User loggedInUser = userUtils.signIn(users);
                    if (loggedInUser != null) {
                        switch (loggedInUser.getRole()) {
                            case ADMIN:
                                while (!Objects.equals(adminMenu.getExitChoice(), adminMenu.getChoice())) {
                                    adminMenu.print();
                                    adminMenu.setChoice();
                                    switch (adminMenu.getChoice()) {
                                        case "a" -> userUtils.listAllUser();
                                        case "b" -> userUtils.editUser();
                                        case "c" -> userUtils.deleteUser(loggedInUser);
                                        case "d" -> commentUtils.listAllUnauthorizedComments();
                                        case "e" -> commentUtils.authorizeComment();
                                        case "f" -> commentUtils.delete();
                                        case "g" -> commentUtils.getCommentsByUser(null);
                                        case "h" -> poiUtils.create();
                                        case "x" -> {}
                                    }
                                }
                                adminMenu.resetChoice();
                                break;
                            case REGULARUSER:
                                while (!Objects.equals(userMenu.getExitChoice(), userMenu.getChoice())) {
                                    userMenu.print();
                                    userMenu.setChoice();
                                    switch (userMenu.getChoice()) {
                                        case "a" -> poiUtils.getPoisByLocation();
                                        case "b" -> poiUtils.getPoisByType();
                                        case "c" -> poiUtils.likePoi();
                                        case "d" -> commentUtils.create(loggedInUser);
                                        case "e" -> commentUtils.edit(loggedInUser);
                                        case "f" -> commentUtils.getCommentsByUser(loggedInUser);
                                        case "x" -> {}
                                    }
                                }
                                userMenu.resetChoice();
                                break;
                        }
                    } else {
                        System.out.println("Sorry but username/password is incorrect!");
                    }
                }
                case "x" -> {}
                default -> System.out.println("Invalid choice!");
            }
        }
        System.out.println("Bye!");
    }
}