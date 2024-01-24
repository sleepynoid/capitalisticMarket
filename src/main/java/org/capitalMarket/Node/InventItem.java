package org.capitalMarket.Node;

public class InventItem {
    private Item item;
    private int stok;
    private ShelfItem itemLocation;
    
    public InventItem(Item newItem, int stokItem) {
        item = newItem;
        stokItem = stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setItemLocation(ShelfItem itemLocation) {
        this.itemLocation = itemLocation;
    }

    public Item getItem() {
        return item;
    }

    public int getStok() {
        return stok;
    }
}
