package org.capitalMarket.View;

import javax.swing.*;

import org.capitalMarket.Model.Gudang;
import org.capitalMarket.Node.Account;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainView extends JFrame {
    private static String userName = "John Doe";
    private static int userID;
    private static Account currentUser;
    
    
    public mainView(Account akun) {
        userID = akun.getAccountId();
        userName = akun.getUsername();
        init();
        loadComponent();
    }

    void init() {
        setTitle("Shoe Store Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void loadComponent() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        // buttonPanel.setPreferredSize(new Dimension(200,200));
        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = 0;
        grid.gridy = 0;
        // grid.insets = new Insets(50, 50, 50, 50);
        grid.insets = new Insets(10, 10, 10, 10);
        
        JLabel welcomeLabel = new JLabel("Welcome " + userName);
        buttonPanel.add(welcomeLabel,grid);
        grid.gridy++;

        String[] menuItems = {
                "Detail Sepatu",
                "Edit Detail Sepatu",
                "Edit Stok Sepatu",
                "Add Sepatu",
                "Search by Name",
                "Search by Brand",
                "List All"
        };

        for (String menuItem : menuItems) {
            JButton button = new JButton(menuItem);
            button.setPreferredSize(new Dimension(200,20));
            // button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(new InputHandler(menuItem));
            buttonPanel.add(button,grid);
            grid.gridy++;
        }

        buttonPanel.setBackground(Color.red);
        setLayout(new BorderLayout());
        add(buttonPanel);
    }
    

    private static class InputHandler implements ActionListener {
        private String menuItem;

        public InputHandler(String menuItem) {
            this.menuItem = menuItem;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (menuItem) {
                case "Detail Sepatu":
                    SwingUtilities.invokeLater(() -> {
                        SearchByString mainWindow = new SearchByString(currentUser);
                        mainWindow.setVisible(true);
                    });
                    System.out.println("Selected menu item: Detail Sepatu");
                    break;
                case "Edit Detail Sepatu":
                    System.out.println("Selected menu item: Edit Detail Sepatu");
                    break;
                case "Add Sepatu":
                    SwingUtilities.invokeLater(() -> {
                        AddItem mainWindow = new AddItem();
                        mainWindow.setVisible(true);
                    });
                case "Edit Stok Sepatu":
                    System.out.println("Selected menu item: Edit Stok Sepatu");
                    break;
                case "Search by Name":
                    System.out.println("Selected menu item: Search by Name");
                    break;
                case "Search by Brand":
                    System.out.println("Selected menu item: Search by Brand");
                    break;
                case "List All":
                    SwingUtilities.invokeLater(() -> {
                        Gudang gudang = new Gudang();
                        ListAll mainWindow = new ListAll(gudang.getListSepatu());
                        mainWindow.setVisible(true);
                    });
            }
        }
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater(() -> {
        //     mainView mainWindow = new mainView(1,"aa");
        //     mainWindow.setVisible(true);
        // });
    }
}

