package org.capitalMarket.Node;

import java.util.regex.Pattern;

public class ShelfItem {
    public char shelfId;
    // public int shelfRow;
    // public int shelfCollum;
    public int position;
    public InventItem shelfItem;
    public ShelfItem(String locStr, InventItem newItem) throws ArrayIndexOutOfBoundsException, NumberFormatException, InvalidFormat {
        if (!isValidFormat(locStr)) {
            throw new InvalidFormat("Error: salah format");
        }
        String[] validStr = locStr.split("-");
        shelfId = validStr[0].charAt(0);
        position = Integer.parseInt(validStr[1]);
        // shelfRow = Character.getNumericValue(validStr[1].charAt(0));
        // shelfCollum = Character.getNumericValue(validStr[1].charAt(1));
        // shelfItem = newItem;
        // for (String s: validStr) {
        //     System.out.println(s);
        // }
        // System.out.println(shelfId);
        // System.out.println(shelfRow+shelfCollum);
        // System.out.printf("Id:%c Row: %d Collum: %d | ",shelfId, shelfRow, shelfCollum);
        System.out.printf("Id:%c Position: %d  | ",shelfId, position);
    }

    boolean isValidFormat(String Str) {
        // String regex = "^[A-Z]-(0[0-9]|1[0-9]|20)$";
        String regex = "^[A-Z]-([0-9]|10)$";
        return Pattern.matches(regex, Str);
    }

    public class InvalidFormat extends Exception {
        public InvalidFormat(String mess) {
            super(mess);
        }
    }

    public static void main(String[] args) {
        try {
            ShelfItem test = new ShelfItem("A-10", new InventItem(new Item(0, "null", "null"), 10));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ShelfItem.InvalidFormat s) {
            System.out.println(s.getMessage());
        }
    }
}
