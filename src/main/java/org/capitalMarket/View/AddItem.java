package org.capitalMarket.View;

import javax.swing.*;

import org.capitalMarket.Model.Gudang;
import org.capitalMarket.Model.ModelGudang;
import org.capitalMarket.Node.Sepatu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItem extends JFrame {
    private JTextField nameField;
    private JTextField brandField;
    private JTextField ukuranField;
    private JTextField kategoriField;
    private JButton addButton;

    public AddItem() {
        setTitle("Add Sepatu");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        nameField = new JTextField(20);
        brandField = new JTextField(20);
        ukuranField = new JTextField(5);
        kategoriField = new JTextField(15);

        addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String brand = brandField.getText();
                int ukuran = Integer.parseInt(ukuranField.getText());
                String kategori = kategoriField.getText();

                Gudang gudang = new Gudang();
                gudang.add(new Sepatu(name, brand, ukuran, kategori));
                gudang.save();
                String message = "Berhasil ditambah:\n"
                        + "Name: " + name + "\n"
                        + "Brand: " + brand + "\n"
                        + "Ukuran: " + ukuran + "\n"
                        + "Kategori: " + kategori;
                JOptionPane.showMessageDialog(AddItem.this, message);

                clearFields();
            }
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Brand:"), gbc);

        gbc.gridx = 1;
        add(brandField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Ukuran:"), gbc);

        gbc.gridx = 1;
        add(ukuranField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Kategori:"), gbc);

        gbc.gridx = 1;
        add(kategoriField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(addButton, gbc);

        setVisible(true);
    }

    private void clearFields() {
        nameField.setText("");
        brandField.setText("");
        ukuranField.setText("");
        kategoriField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddItem();
        });
    }
}
