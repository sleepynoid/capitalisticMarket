package org.capitalMarket.Model;

import java.util.ArrayList;
import java.util.Objects;

import org.capitalMarket.Node.Account;
import org.capitalMarket.Node.InventItem;
import org.capitalMarket.Node.Item;
import org.capitalMarket.Node.Kategori;
import org.capitalMarket.Node.ShelfItem;

public class Warehouse {
    // private int id;
    private ArrayList<Account> admins;
    public ArrayList<InventItem> items;
    public ArrayList<Kategori> kategori;
    public ShelfItem locker;

    public Warehouse(int idUser) {
        // id = idUser;
        admins = new ArrayList<>();
        items = new ArrayList<>();
    }

    public boolean addItem(Item newItem, int stok) {
        for (InventItem temp: items) {
            if (Objects.requireNonNull(temp).getItem().getIdItem() == newItem.getIdItem()) {
                return false;
            }
        }
        items.add(new InventItem(newItem, stok));
        return true;
    }

    boolean delItem(int targetItemId) {
        InventItem targetItem = getItems(targetItemId);
        if (targetItem == null) {
            return false;
        }
        items.remove(targetItem);
        return false;
    }

    public InventItem getItems(int Id) {
        for (InventItem i: items) {
            if (i.getItem().getIdItem() == Id) {
                return i;
            }
        }
        return null;
    }

    public boolean editItemStok(int Id, int newStok) {
        InventItem targetItem = getItems(Id);
        if (targetItem == null) {
            return false;
        }
        targetItem.setStok(newStok);
        return true;
    }

    public static void main(String[] args) {
        Warehouse test = new Warehouse(1);
        test.addItem(new Item(1, "sword", "nyah"), 10);
        test.addItem(new Item(2, "shield", "nyah"), 10);
        test.delItem(1);
        test.addItem(new Item(1, "shield", "nyah"), 10);
        test.editItemStok(1, 2);
        for (InventItem tmp : test.items) {
            System.out.printf("%d %s %d\n",tmp.getItem().getIdItem(),tmp.getItem().getNameItem(),tmp.getStok());
        }
    }
}
