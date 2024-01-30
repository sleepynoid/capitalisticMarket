package org.capitalMarket.Node;

public class Account {
    private  int accountId;
    private String Username;
    private String Password;

    public Account(int id, String user, String pass) {
        accountId = id;
        Username = user;
        Password = pass;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
