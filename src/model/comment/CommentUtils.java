package model.comment;

import model.poi.PoiUtils;
import model.poi.PointOfInterest;
import model.user.User;
import model.user.UserUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommentUtils {

    private static final Scanner sc = new Scanner(System.in);
    private final List<User> users;
    private final List<PointOfInterest> pois;
    private final List<Comment> comments;
    private final PoiUtils poiUtils;
    private final UserUtils userUtils;

    public CommentUtils(List<Comment> comments, PoiUtils poiUtils, UserUtils userUtils) {
        this.comments = comments;
        this.poiUtils =  poiUtils;
        this.userUtils = userUtils;
        this.users = userUtils.getUsers();
        this.pois = poiUtils.getPois();
    }

    public void create(User loggedInUser) {
        Comment comment = null;
        System.out.println("Creating a new Comment: ");
        System.out.println("Please enter the Id of the Point Of Interest: ");
        String poiId = sc.nextLine();
        for (PointOfInterest poi : pois) {
            if (String.valueOf(poi.getId()).equals(poiId)) {
                comment = new Comment();
                System.out.println("Please enter the content of the comment: ");
                comment.setId(comments.getLast().getId() + 1);
                comment.setContent(sc.nextLine());
                comment.setUserId(loggedInUser.getId());
                comment.setPointOfInterestId(Integer.parseInt(poiId));
                comment.setAuthorized(false);
                comments.add(comment);
            }
        }
        if (comment == null) System.out.println("No Point Of Interest was found by given id: " + poiId);
    }

    public void listComments(List<Comment> comments) {
        System.out.println("List of Comments: ");
        System.out.printf("%-3s %-30s %-7s %-6s %-30s %-11s%n", "Id", "Content", "User Id", "POI Id", "Name of POI", "Authorized?");
        for (Comment comment : comments) {
            System.out.printf("%-3s %-30s %-7s %-6s %-30s %-11s%n",
                    comment.getId(),
                    comment.getContent(),
                    comment.getUserId(),
                    comment.getPointOfInterestId(),
                    poiUtils.getPoiById(String.valueOf(comment.getPointOfInterestId())).getName(),
                    comment.isAuthorized());
        }
    }

    public List<Comment> getCommentsByUser(User user) {
        List<Comment> commentsByUser = new ArrayList<>();
        if (user == null) {
            System.out.println("Please enter the Id of an existing User: ");
            String userId = sc.nextLine();
            user = userUtils.getUserById(users, userId);
        }
            for (Comment comment : comments) {
                if ((comment.getUserId()) == user.getId()) commentsByUser.add(comment);
            }
            if (!commentsByUser.isEmpty()) {
                listComments(commentsByUser);
            } else {
                System.out.println("No Comments was created by user: " + user.getUserName());
            }
        return commentsByUser;
    }

    public void edit(User loggedInUser) {
        List<Comment> commentsByUser = getCommentsByUser(loggedInUser);
        if (!commentsByUser.isEmpty()) {
            System.out.println("Editing an existing Comment: ");
            System.out.println("Please enter the Id of the existing Comment: ");
            String commentId = sc.nextLine();
            for (Comment comment : comments) {
                if (String.valueOf(comment.getId()).equals(commentId)) {
                    System.out.println("Please enter the content of the comment: ");
                    comment.setContent(sc.nextLine());
                    comment.setAuthorized(false);
                }
            }
        }
    }

    public List<Comment> listAllUnauthorizedComments() {
        List<Comment> unauthorizedComments = new ArrayList<>();
        for (Comment comment : comments) {
            if (!comment.isAuthorized()) unauthorizedComments.add(comment);
        }
        if (!unauthorizedComments.isEmpty()) {
            listComments(unauthorizedComments);
        } else {
            System.out.println("No Non-Authorized Comments was found!");
        }
        return unauthorizedComments;
    }

    public Comment getCommentById(List<Comment> comments, String commentId) {
        for (Comment comment : comments) {
            if (String.valueOf(comment.getId()).equals(commentId)) return comment;
        }
        return null;
    }

    public void authorizeComment() {
        List<Comment> unauthorizedComments = listAllUnauthorizedComments();
        if (!unauthorizedComments.isEmpty()) {
            System.out.println("Authorize Comment: ");
            System.out.println("Please enter the Id of the existing Comment: ");
            String commentId = sc.nextLine();
            Comment comment = getCommentById(unauthorizedComments, commentId);
            if (comment != null) {
                comment.setAuthorized(true);
                System.out.println("Comment was succesfully authorized!");
            } else {
                System.out.println("No Non-Authorized Comments was found by Id: " + commentId);
            }
        }
    }

    public void delete() {
        System.out.println("Delete Comment: ");
        System.out.println("Please enter the Id of the existing Comment: ");
        String commentId = sc.nextLine();
        Comment comment = getCommentById(comments, commentId);
        if (comment != null) {
            comments.remove(comment);
            System.out.println("Comment was succesfully deleted!");
        } else {
            System.out.println("No Comments was found by Id: " + commentId);
        }
    }
}