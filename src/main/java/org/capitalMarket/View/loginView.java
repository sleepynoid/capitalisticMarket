package org.capitalMarket.View;

import javax.swing.*;

import org.capitalMarket.Model.ModelAccount;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginView extends JFrame {
    JTextField usernameField = new JTextField(15);
    JPasswordField passwordField = new JPasswordField(15);

    public loginView() {
        super("Capital");
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

        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Username label and text field
        loginPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx++;
        loginPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        loginPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx++;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle login button click
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                // Add your login logic here
                // System.out.println("Username: " + username);
                // System.out.println("Password: " + new String(password));
                // Clear password field after processing
                if (username.equals(password)) {
                    // Dispose the LoginView window
                    dispose();
                    
                    // Create and show the mainView
                    SwingUtilities.invokeLater(() -> {
                        mainView mainView = new mainView(1,username);
                        mainView.setVisible(true);
                    });
                } else {
                    // Display an error message or take appropriate action for a failed login
                    // JOptionPane.showMessageDialog(new J, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(loginButton, "Password salah");
                }
                passwordField.setText("");
            }
        });
        loginPanel.add(loginButton, gbc);

        add(loginPanel, BorderLayout.CENTER);
    }

    // private static class loginHandler implements ActionListener {
        
    // }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new loginView();
        });
    }
}
