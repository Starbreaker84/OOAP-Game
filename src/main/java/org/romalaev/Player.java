package org.romalaev;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private Location currentLocation;
    private final List<Item> inventory;
    private final Set<Location> visitedLocations;

    public Player(Location startingLocation) {
        this.currentLocation = startingLocation;
        this.inventory = new ArrayList<>();
        this.visitedLocations = new HashSet<>();
        visitLocation(startingLocation);
    }

    public void moveTo(Location location) {
        this.currentLocation = location;
        visitLocation(location);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public Set<Location> getVisitedLocations() {
        return visitedLocations;
    }

    private void visitLocation(Location location) {
        visitedLocations.add(location);
    }
}
