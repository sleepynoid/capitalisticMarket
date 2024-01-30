package org.capitalMarket.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.print.DocFlavor.STRING;

import org.capitalMarket.Node.Account;
import org.capitalMarket.Node.InventItem;
import org.capitalMarket.Node.Item;
import org.capitalMarket.Node.Kategori;

public class Warehouse {
    private Account admin;
    private ArrayList<InventItem> items;
    private ArrayList<Kategori> kategori;
    private Map<Account, ModelShelf> userShelves;
    private Map<Account, List<InventItem>> userInventItemMap;
    private Map<Account, List<Kategori>> userKategoriMap;

    public Warehouse(Account newAdmin) {
        admin = newAdmin;
        items = new ArrayList<>();
        kategori = new ArrayList<>();
        userShelves = new HashMap<>();
        userInventItemMap = new HashMap<>();
        userKategoriMap = new HashMap<>();

        userShelves.put(admin, new ModelShelf());
        userInventItemMap.put(admin, new ArrayList<>());
        userKategoriMap.put(admin, new ArrayList<>());
    }

    public boolean addItem(Item newItem, int stok, Account user) {
        if (!userShelves.containsKey(user)) {
            // Create user-specific structures if not present
            userShelves.put(user, new ModelShelf());
            userInventItemMap.put(user, new ArrayList<>());
            userKategoriMap.put(user, new ArrayList<>());
        }

        if (hasDuplicateItem(user, newItem.getIdItem())) {
            return false;
        }

        InventItem newInventItem = new InventItem(newItem, stok);
        items.add(newInventItem);
        userShelves.get(user).addItem(newInventItem);
        userInventItemMap.get(user).add(newInventItem);
        return true;
    }

    public boolean delItem(int targetItemId) {
        boolean itemDeleted = false;

        // Delete the item from the main list
        Iterator<InventItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            InventItem item = iterator.next();
            if (item.getItem().getIdItem() == targetItemId) {
                iterator.remove();
                itemDeleted = true;
            }
        }

        // Delete the item from each user's shelf
        for (Map.Entry<Account, List<InventItem>> entry : userInventItemMap.entrySet()) {
            List<InventItem> userItems = entry.getValue();
            Iterator<InventItem> userIterator = userItems.iterator();
            while (userIterator.hasNext()) {
                InventItem userItem = userIterator.next();
                if (userItem.getItem().getIdItem() == targetItemId) {
                    userIterator.remove();
                }
            }
        }

        return itemDeleted;
    }

    public InventItem getItems(int Id) {
        for (InventItem i : items) {
            if (i.getItem().getIdItem() == Id) {
                return i;
            }
        }
        return null;
    }

    public List<Kategori> getUserKategoriList(Account user) {
        return userKategoriMap.get(user);
    }

    private boolean hasDuplicateItem(Account user, int itemId) {
        List<InventItem> userItems = userInventItemMap.get(user);
        for (InventItem temp : userItems) {
            if (temp.getItem().getIdItem() == itemId) {
                return true;
            }
        }
        return false;
    }

    public boolean editItemStok(int Id, int newStok) {
        InventItem targetItem = getItems(Id);
        if (targetItem == null) {
            return false;
        }

        targetItem.setStok(newStok);
        return true;
    }

    public List<InventItem> getUserItemsList(Account user) {
        if (userInventItemMap.containsKey(user)) {
            return userInventItemMap.get(user);
        }
        return new ArrayList<>(); // User doesn't have a shelf in this warehouse
    }

    public InventItem getUserItem(Account user, String nameItem) {
        if (!userInventItemMap.containsKey(user)) {
            return null;
        }
        List<InventItem> temp = userInventItemMap.get(user);
        for (InventItem tmpItem : temp) {
            if (tmpItem.getItem().getNameItem().equals(nameItem)) {
                return tmpItem;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Account adminUser = new Account(1,"admin", "password");
        Account regularUser = new Account(2,"user", "password");

        Warehouse test = new Warehouse(adminUser);

        // Admin adds items
        test.addItem(new Item(1, "sword", "nyah"), 10, adminUser);
        System.out.println(test.addItem(new Item(1, "sword", "nyah"), 10, regularUser));

        test.addItem(new Item(2, "shield", "nyah"), 10, adminUser);
        test.addItem(new Item(2, "shield", "nyah"), 10, regularUser);

        // Admin and regular user add the same item
        test.addItem(new Item(3, "armor", "nyah"), 5, adminUser);
        test.addItem(new Item(3, "armor", "nyah"), 5, regularUser);

        // Print items
        for (InventItem tmp : test.items) {
            System.out.printf("%d %s %d\n", tmp.getItem().getIdItem(), tmp.getItem().getNameItem(), tmp.getStok());
        }

        // Get items for a specific user
        List<InventItem> adminItems = test.getUserItemsList(adminUser);
        System.out.println("Admin's items:");
        for (InventItem tmp : adminItems) {
            System.out.printf("%d %s %d\n", tmp.getItem().getIdItem(), tmp.getItem().getNameItem(), tmp.getStok());
        }

        List<InventItem> userItems = test.getUserItemsList(regularUser);
        System.out.println("user's items:");
        for (InventItem tmp : userItems) {
           System.out.printf("%d %s %d\n", tmp.getItem().getIdItem(), tmp.getItem().getNameItem(), tmp.getStok());
        }
        // Delete the item with ID 3
        test.delItem(3);

        // Print items after deletion
        System.out.println("Items after deletion:");
        for (InventItem tmp : test.items) {
            System.out.printf("%d %s %d\n", tmp.getItem().getIdItem(), tmp.getItem().getNameItem(), tmp.getStok());
        }

        System.out.println("Admin's items:");
        for (InventItem tmp : adminItems) {
            System.out.printf("%d %s %d\n", tmp.getItem().getIdItem(), tmp.getItem().getNameItem(), tmp.getStok());
        }
        
        System.out.println("user's items:");
        for (InventItem tmp : userItems) {
           System.out.printf("%d %s %d\n", tmp.getItem().getIdItem(), tmp.getItem().getNameItem(), tmp.getStok());
        }
    }
}
