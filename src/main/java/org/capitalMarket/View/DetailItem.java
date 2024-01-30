package org.capitalMarket.View;

import javax.swing.*;

import org.capitalMarket.Node.Sepatu;

import java.awt.*;
import java.util.Objects;

public class DetailItem extends JFrame {
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel brandLabel;
    private JLabel ukuranLabel;
    private JLabel kategoriLabel;

    public DetailItem(Sepatu item) {
        setTitle("Item Details");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        titleLabel = new JLabel("Item Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        nameLabel = new JLabel("Name: " + Objects.requireNonNullElse(item.getNama(), ""));
        brandLabel = new JLabel("Brand: " + Objects.requireNonNullElse(item.getKategori(), ""));
        ukuranLabel = new JLabel("Ukuran: " + item.getUkuran());
        kategoriLabel = new JLabel("Kategori: " + Objects.requireNonNullElse(item.getKategori(), ""));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.PAGE_START;
        add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nameLabel, gbc);

        gbc.gridy = 2;
        add(brandLabel, gbc);

        gbc.gridy = 3;
        add(ukuranLabel, gbc);

        gbc.gridy = 4;
        add(kategoriLabel, gbc);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Sepatu exampleItem = new Sepatu("ExampleName", "ExampleBrand", 10, "ExampleCategory");
            new DetailItem(exampleItem);
        });
    }
}
