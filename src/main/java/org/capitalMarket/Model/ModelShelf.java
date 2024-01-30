package org.capitalMarket.Model;

import java.util.Map;
import java.util.TreeMap;

import org.capitalMarket.Node.InventItem;
import org.capitalMarket.Node.Item;
import org.capitalMarket.Node.ShelfItem;
import org.capitalMarket.Node.ShelfItem.InvalidFormatException;

public class ModelShelf {
    TreeMap<String, ShelfItem> shelfMap;
    int positionMax = 10;
    public ModelShelf() {
        shelfMap = new TreeMap<>();
        // shelfMap.put("A-00", new ShelfItem(null, null));
    }

    void addItem(InventItem newItem) {
        char newId = getLastID();
        int newPosition = shelfMap.isEmpty() ? 0 : shelfMap.lastEntry().getValue().getPosition() + 1;
        System.out.println(newPosition);

        if (newPosition > positionMax) {
            newId = (char) (newId + 1);
            newPosition = 0;
        }

        String newLocation = String.format("%c-%02d", newId, newPosition);
        try {
            shelfMap.put(newLocation, new ShelfItem(newLocation, newItem));
        } catch (InvalidFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    void delItem(String location) {
        shelfMap.remove(location);
    }

    public String getLastLocation() {
        if (shelfMap.isEmpty()) {
            return null;
        }
        return shelfMap.lastKey();
    }

    public char getLastID() {
        if (shelfMap.isEmpty()) {
            return 'A';
        }

        String lastKey = shelfMap.lastKey();
        return lastKey.charAt(0);
    }

    InventItem getItem(String str) {
        return shelfMap.get(str).getShelfItem();
    }

    boolean isExist(String location) {
        return shelfMap.containsKey(location);
    }

    public void printAllItems() {
        for (Map.Entry<String, ShelfItem> entry : shelfMap.entrySet()) {
            String location = entry.getKey();
            ShelfItem shelfItem = entry.getValue();
            System.out.println("Location: " + location + ", Shelf Item: " + shelfItem);
        }
    }

    public static void main(String[] args) {
        ModelShelf test = new ModelShelf();
        InventItem newItem = new InventItem(new Item(1, "null"," null"),7);  // Replace with actual instantiation
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.addItem(newItem);
        test.delItem("B-01");
        test.printAllItems();
        System.out.println("Last id: " + test.getLastID());
    }
}
