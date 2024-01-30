package org.capitalMarket.Node;

import java.util.regex.Pattern;

public class ShelfItem {
    private char shelfId;
    private int position;
    private InventItem shelfItem;

    public ShelfItem(String locStr, InventItem newItem) throws InvalidFormatException {
        validateFormat(locStr);

        String[] validStr = locStr.split("-");
        shelfId = validStr[0].charAt(0);
        position = Integer.parseInt(validStr[1]);

        System.out.printf("Id:%c Position: %d  | ", shelfId, position);
    }

    private void validateFormat(String str) throws InvalidFormatException {
        String regex = "^[A-Z]-(0[0-9]|1[0-9]|20)$";
        if (!Pattern.matches(regex, str)) {
            throw new InvalidFormatException("Error: invalid format");
        }
    }

    public char getShelfId() {
        return shelfId;
    }

    public int getPosition() {
        return position;
    }

    public InventItem getShelfItem() {
        return shelfItem;
    }

    // Add getter and setter methods for other fields as needed

    public class InvalidFormatException extends Exception {
        public InvalidFormatException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            ShelfItem test = new ShelfItem("A-10", new InventItem(new Item(0, "null", "null"), 10));
            // Access fields using getters
            System.out.println("Shelf ID: " + test.getShelfId());
            System.out.println("Position: " + test.getPosition());
        } catch (ShelfItem.InvalidFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
