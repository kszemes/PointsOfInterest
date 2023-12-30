package utils;

import model.comment.Comment;
import model.poi.PointOfInterest;
import model.user.Role;
import model.user.User;

import java.util.ArrayList;
import java.util.List;

public class DataSeeder {
    public static List<PointOfInterest> getPointsOfInterest() {
        List<PointOfInterest> points = new ArrayList<>();
        points.add(new PointOfInterest(1, "Exeter Cathedral", "London", "Architectural sites"));
        points.add(new PointOfInterest(2, "Castle Howard", "Yorkshire", "Historic House"));
        points.add(new PointOfInterest(3, "Stonehenge", "Wiltshire", "Prehistoric Monument"));
        points.add(new PointOfInterest(4, "Eden Project", "Cornwall", "Botanical Garden"));
        points.add(new PointOfInterest(5, "Tower of London", "London", "Historic Castle"));
        points.add(new PointOfInterest(6, "Lake District National Park", "Cumbria", "Natural Beauty"));
        points.add(new PointOfInterest(7, "British Museum", "London", "Museum"));
        points.add(new PointOfInterest(8, "Big Ben", "London", "Historic Landmark"));
        return points;
    }

    public static List<Comment> getComments() {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(1, "Beautiful Cathedral!", 1, 1, false));
        comments.add(new Comment(2, "Great Castle!", 1, 2, true));
        comments.add(new Comment(3, "Mysterious Place!", 1, 3, false));
        comments.add(new Comment(4, "Like a really eden garden !", 2, 4, true));
        comments.add(new Comment(5, "Fearful Place!", 2, 5, false));
        comments.add(new Comment(6, "Naturally preserved territory!", 3, 6, true));
        comments.add(new Comment(7, "Lot of interesting things!", 3, 7, true));
        comments.add(new Comment(8, "Iconic place of London", 3, 8, false));
        return comments;
    }

    public static List<User> getUsers(){
       List<User> users = new ArrayList<>();
       users.add(new User(1, "andika", "andika", Role.REGULARUSER));
       users.add(new User(2, "papika", "papika", Role.REGULARUSER));
       users.add(new User(3, "mamika", "mamika", Role.REGULARUSER));
       users.add(new User(4, "admin1", "admin1", Role.ADMIN));
       users.add(new User(5, "admin2", "admin2", Role.ADMIN));
       return users;
    }
}