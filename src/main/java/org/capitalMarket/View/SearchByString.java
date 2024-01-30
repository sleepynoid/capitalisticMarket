package org.capitalMarket.View;

import javax.swing.*;

import org.capitalMarket.Controller.ControllerGudang;
import org.capitalMarket.Controller.WarehouseController;
import org.capitalMarket.Model.Gudang;
import org.capitalMarket.Node.Account;
import org.capitalMarket.Node.InventItem;
import org.capitalMarket.Node.Sepatu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByString extends JFrame {
    Account currentUser;
    private JTextField searchField;

    public SearchByString(Account akun) {
        currentUser = akun;
        initializeComponents();
        initializeUI();
    }

    private void initializeUI() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Search label and text field
        searchPanel.add(new JLabel("Search:"), gbc);
        gbc.gridx++;
        searchField = new JTextField(15);
        searchPanel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchString = searchField.getText();

                // WarehouseController test = new WarehouseController(currentUser);
                // InventItem find = test.getUserItem(currentUser, searchString);
                // ControllerGudang main = new ControllerGudang(currentUser);
                
                Gudang gudang = new Gudang();
                Sepatu find = gudang.getSepatu(searchString);
                if (find == null) {
                    JOptionPane.showMessageDialog(searchButton, searchString + "Not found");
                    dispose();
                    return;
                }
                DetailItem newWin = new DetailItem(find);
                dispose();
            }
        });
        searchPanel.add(searchButton, gbc);

        add(searchPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Example of how to use the frame
        SwingUtilities.invokeLater(() -> {
            // new SearchByString();
        });
    }
}
