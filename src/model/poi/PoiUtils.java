package model.poi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoiUtils {

    private static final Scanner sc = new Scanner(System.in);

    private final List<PointOfInterest> pois;

    public PoiUtils(List<PointOfInterest> pois) {
        this.pois = pois;
    }

    public List<PointOfInterest> getPois() {
        return pois;
    }

    public void create() {
        PointOfInterest poi = new PointOfInterest();
        poi.setId(pois.getLast().getId() + 1);
        System.out.println("Creating a new Point Of Interest: ");
        System.out.println("Please enter the name: ");
        poi.setName(sc.nextLine());
        System.out.println("Please enter the location: ");
        poi.setLocation(sc.nextLine());
        System.out.println("Please enter the type: ");
        poi.setType(sc.nextLine());
        pois.add(poi);
        System.out.println("Poi was created successfully: " + poi);
        listPois(pois);
    }

    public void listPois(List<PointOfInterest> pois) {
        System.out.println("List of All Point Of Interests: ");
        System.out.printf("%-3s %-30s %-20s %-20s %-5s%n", "Id", "Name", "Location", "Type", "Likes");
        for (PointOfInterest poi : pois) {
            System.out.printf("%-3s %-30s %-20s %-20s %-5s%n", poi.getId(), poi.getName(), poi.getLocation(), poi.getType(), poi.getLikes());
        }
    }

    public void getPoisByLocation() {
        List<PointOfInterest> poisByLocation = new ArrayList<>();
        System.out.println("Get List of Point Of Interests by Location: ");
        System.out.println("Please enter the name of the location!");
        String location = sc.nextLine().toLowerCase();
        for (PointOfInterest poi : pois) {
            if (poi.getLocation().toLowerCase().contains(location)) poisByLocation.add(poi);
        }
        if (!poisByLocation.isEmpty()) {
            listPois(poisByLocation);
        } else {
            System.out.println("No Point Of Interest was found by given location name: " + location);
        }
    }

    public void getPoisByType() {
        List<PointOfInterest> poisByType = new ArrayList<>();
        System.out.println("Get List of Point Of Interests by Type: ");
        System.out.println("Please enter the type of the pois!");
        String type = sc.nextLine().toLowerCase();
        for (PointOfInterest poi : pois) {
            if (poi.getType().toLowerCase().contains(type)) poisByType.add(poi);
        }
        if (!poisByType.isEmpty()) {
            listPois(poisByType);
        } else {
            System.out.println("No Point Of Interest was found by given type: " + type);
        }
    }

    public void likePoi() {
        System.out.println("Like Point Of Interest By Id: ");
        System.out.println("Please enter the ID of the POI you would like to like!");
        PointOfInterest likedPoi = null;
        String poiId = sc.nextLine();
        for (PointOfInterest poi : pois) {
            int likes = poi.getLikes();
            if (String.valueOf(poi.getId()).equals(poiId)) {
                poi.setLikes(likes + 1);
                System.out.println("Point Of Interest with id: " + poiId + " successfully liked!");
                likedPoi = poi;
            }
        }
        if (likedPoi == null) System.out.println("No Point Of Interested found with id: " + poiId);
    }

    public PointOfInterest getPoiById(String poiId){
        for (PointOfInterest poi : pois) {
            if (String.valueOf(poi.getId()).equals(poiId)) return poi;
        }
        return null;
    }
}