package org.capitalMarket.Model;

import java.util.ArrayList;

import org.capitalMarket.Node.InventItem;
import org.capitalMarket.Node.Item;
import org.capitalMarket.Node.ShelfItem;

public class ModelShelf {
    ArrayList<ShelfItem> listShelf;
    int capacity = 10;
    char currentId = 'A';
    char maxId = 'B';
    int currentPosition = -1;
    int maxPosition = 10;
    ArrayList<String> listKeys = new ArrayList<>();

    public ModelShelf() {
        listShelf = new ArrayList<>();
    }

    void addBeta(InventItem newItem) {
        String locFormat = String.valueOf(currentId)+Integer.toString(currentPosition);

        // ShelfItem newShelf = new ShelfItem(locFormat, newItem);
    }

    String locationGenerator() {
        String tempStr = String.valueOf(currentId)+Integer.toString(currentPosition);
        char tempId = currentId;
        int tempPosition = currentPosition;
        while (!isExist(tempStr)) {
            if (tempPosition != 10) {
                tempPosition++;   
            } else if (tempId == 'A' || tempId == 'B') {
                tempPosition = 0;
                tempId++;
            } else {
                System.out.println("keluar"+ tempPosition+tempId);
                break;
            }
            tempStr = String.valueOf(tempId)+Integer.toString(tempPosition);
            System.out.println("salah"+tempStr);
            if (!isExist(tempStr)) {
                System.out.println(tempStr);
                currentId = tempId;
                currentPosition = tempPosition;
                listKeys.add(tempStr);
                break;
            }
        }
        return "nyahh";
    }

    boolean isExist(String str) {
        for (String tempString : listKeys) {
            if (tempString.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ModelShelf test = new ModelShelf();
    }
}
