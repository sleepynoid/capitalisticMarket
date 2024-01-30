package org.capitalMarket.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.capitalMarket.Node.Sepatu;

import java.awt.*;
import java.util.List;

public class ListAll extends JFrame {
    private String[] columnNames = {"Name", "Brand", "Ukuran", "Kategori"};
    private DefaultTableModel sepatuTableModel;
    private JTable sepatuTable;

    public ListAll(List<Sepatu> sepatuList) {
        // Frame properties
        setTitle("List of Sepatu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        if (sepatuList != null && !sepatuList.isEmpty()) {
            Object[][] data = new Object[sepatuList.size()][4];

            for (int i = 0; i < sepatuList.size(); i++) {
                Sepatu sepatu = sepatuList.get(i);
                data[i][0] = sepatu.getNama();
                data[i][1] = sepatu.getNamaBrand();
                data[i][2] = sepatu.getUkuran();
                data[i][3] = sepatu.getKategori();
            }

            sepatuTableModel = new DefaultTableModel(data, columnNames);
            sepatuTable = new JTable(sepatuTableModel);
            JScrollPane scrollPane = new JScrollPane(sepatuTable);
            add(scrollPane, BorderLayout.CENTER);
        } else {
            // Display a message if the list is empty
            JLabel emptyLabel = new JLabel("No Sepatu available.");
            emptyLabel.setHorizontalAlignment(JLabel.CENTER);
            add(emptyLabel, BorderLayout.CENTER);
        }

        // Display the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        // Example of how to use the frame
        SwingUtilities.invokeLater(() -> {
            // Assuming you have a list of Sepatu, replace it with your actual data
            List<Sepatu> sepatuList = List.of(
                    new Sepatu("Sepatu1", "Brand1", 20, "Casual"),
                    new Sepatu("Sepatu2", "Brand2", 15, "Sports"),
                    new Sepatu("Sepatu3", "Brand3", 10, "Formal")
            );
            new ListAll(sepatuList);
        });
    }
}
