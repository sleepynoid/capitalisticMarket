package org.capitalMarket.Controller;

import java.util.List;

import org.capitalMarket.Model.Warehouse;
import org.capitalMarket.Node.Account;
import org.capitalMarket.Node.InventItem;
import org.capitalMarket.Node.Item;
import org.capitalMarket.Node.Kategori;

public class WarehouseController {
    private Warehouse gudang;

    public WarehouseController(Account admin) {
        this.gudang = new Warehouse(admin);
    }

    public boolean addItem(Item newItem, int stok, Account user) {
        return gudang.addItem(newItem, stok, user);
    }

    // public boolean addKategori(Kategori newKategori, Account user) {
    //     return gudang.addKategori(newKategori, user);
    // 

    public boolean delItem(int targetItemId) {
        return gudang.delItem(targetItemId);
    }

    public InventItem getItems(int Id) {
        return gudang.getItems(Id);
    }

    public boolean editItemStok(int Id, int newStok) {
        return gudang.editItemStok(Id, newStok);
    }

    public List<InventItem> getUserItemsList(Account user) {
        return gudang.getUserItemsList(user);
    }

    public InventItem getUserItem(Account user, String nameItem) {
        return gudang.getUserItem(user,nameItem);
    }

    // public Kategori getKategori(int kategoriId) {
    //     return gudang.get(kategoriId);
    // }

    public List<Kategori> getUserKategoriList(Account user) {
        return gudang.getUserKategoriList(user);
    }

    public static void main(String[] args) {
        Account adminUser = new Account(1,"admin", "password");
        Account regularUser = new Account(2,"user", "password");

        WarehouseController warehouseController = new WarehouseController(adminUser);

        // Admin adds items
        warehouseController.addItem(new Item(1, "sword", "nyah"), 10, adminUser);
        warehouseController.addItem(new Item(2, "shield", "nyah"), 10, adminUser);

        // Admin adds category
        // warehouseController.addKategori(new Kategori(1, "Weapons"), adminUser);

        // Regular user adds items
        warehouseController.addItem(new Item(3, "armor", "nyah"), 5, regularUser);

        // Print items and categories
        System.out.println("Admin's items:");
        for (InventItem item : warehouseController.getUserItemsList(adminUser)) {
            System.out.printf("%d %s %d\n", item.getItem().getIdItem(), item.getItem().getNameItem(), item.getStok());
        }

        System.out.println("Admin's categories:");
        for (Kategori kategori : warehouseController.getUserKategoriList(adminUser)) {
            System.out.printf("%d %s\n", kategori.getIdKategori(), kategori.getNameKategori());
        }

        System.out.println("Regular user's items:");
        for (InventItem item : warehouseController.getUserItemsList(regularUser)) {
            System.out.printf("%d %s %d\n", item.getItem().getIdItem(), item.getItem().getNameItem(), item.getStok());
        }
    }
}
