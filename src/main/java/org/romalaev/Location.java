package org.romalaev;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final String name;
    private final String description;
    private Item item;
    private final Map<String, Location> exits;

    public Location(String name, String description, Item item) {
        this.name = name;
        this.description = description;
        this.item = item;
        this.exits = new HashMap<>();
    }

    public void addExit(String direction, Location location) {
        exits.put(direction.toLowerCase(), location);
    }

    public Map<String, Location> getExits() {
        return exits;
    }

    public String getDescription() {
        return description;
    }

    public Item getItem() {
        return item;
    }

    public void removeItem() {
        item = null;
    }

    public String getName() {
        return name;
    }
}
