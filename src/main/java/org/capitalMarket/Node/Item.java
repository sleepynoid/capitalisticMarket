package org.capitalMarket.Node;

public class Item { 
    private int idItem;
    private String nameItem;
    private String brandItem;

    public Item(int idItem, String nameItem, String brandItem) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.brandItem = brandItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public void setBrandItem(String brand) {
        brandItem = brand;
    }

    public int getIdItem() {
        return idItem;
    }
    
    public String getNameItem() {
        return nameItem;
    }

    public String getBrandItem() {
        return brandItem;
    }
}
