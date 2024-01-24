package org.capitalMarket.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputHandler implements ActionListener {
    private String menuItem;

    public InputHandler(String menuItem) {
        this.menuItem = menuItem;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click based on the selected menu item
        switch (menuItem) {
            case "Detail Sepatu":
                System.out.println("Selected menu item: Detail Sepatu");
                // Add your code for Detail Sepatu action
                break;
            case "Edit Detail Sepatu":
                System.out.println("Selected menu item: Edit Detail Sepatu");
                // Add your code for Edit Detail Sepatu action
                break;
            case "Edit Stok Sepatu":
                System.out.println("Selected menu item: Edit Stok Sepatu");
                // Add your code for Edit Stok Sepatu action
                break;
            case "Search by Name":
                System.out.println("Selected menu item: Search by Name");
                // Add your code for Search by Name action
                break;
            case "Search by Brand":
                System.out.println("Selected menu item: Search by Brand");
                // Add your code for Search by Brand action
                break;
            case "Check Stok":
                System.out.println("Selected menu item: Check Stok");
                // Add your code for Check Stok action
                break;
        }
    }
}