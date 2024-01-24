package org.capitalMarket.Model;

import java.util.HashMap;
import java.util.Map;

public class tester {
    public static void main(String[] args) {
        ModelShelfBeta modelShelf = new ModelShelfBeta();

        // Add shelves and items
        modelShelf.addShelf();
        modelShelf.addItemToShelf("001", "Shoe");
        modelShelf.addItemToShelf("002", "Hat");

        // Display shelves and items
        modelShelf.displayShelves();
    }
}

class ShelfLocation {
    private static char currentId = 'A';
    private static int currentRow = 1;
    private static int currentColumn = 1;

    private String location;

    private ShelfLocation(String location) {
        this.location = location;
    }

    public static ShelfLocation generateNextLocation() {
        String nextLocation = String.format("%s-%02d%02d", currentId, currentRow, currentColumn);

        currentColumn++;
        if (currentColumn > 4) {
            currentColumn = 1;
            currentRow++;
            if (currentRow > 5) {
                currentRow = 1;
                currentId++;
                if (currentId > 'Z') {
                    currentId = 'A';
                    currentRow = 1;
                    currentColumn = 1;
                }
            }
        }

        return new ShelfLocation(nextLocation);
    }

    @Override
    public String toString() {
        return location;
    }
}

class Shelf {
    private Map<String, String> items;  // Assuming items are stored in the shelf with some identifier

    public Shelf() {
        this.items = new HashMap<>();
    }

    public void addItem(String itemId, String itemName) {
        items.put(itemId, itemName);
    }

    public void displayItems() {
        for (Map.Entry<String, String> entry : items.entrySet()) {
            System.out.println("Item ID: " + entry.getKey() + ", Item Name: " + entry.getValue());
        }
    }
}

class ModelShelfBeta {
    private Map<ShelfLocation, Shelf> shelves;

    public ModelShelfBeta() {
        this.shelves = new HashMap<>();
    }

    public void addShelf() {
        ShelfLocation location = ShelfLocation.generateNextLocation();
        shelves.put(location, new Shelf());
    }

    public void addItemToShelf(String itemId, String itemName) {
        ShelfLocation location = ShelfLocation.generateNextLocation();
        if (!shelves.containsKey(location)) {
            addShelf();
        }

        shelves.get(location).addItem(itemId, itemName);
    }

    public void displayShelves() {
        for (Map.Entry<ShelfLocation, Shelf> entry : shelves.entrySet()) {
            System.out.println("Shelf Location: " + entry.getKey());
            entry.getValue().displayItems();
            System.out.println("--------------");
        }
    }
}
