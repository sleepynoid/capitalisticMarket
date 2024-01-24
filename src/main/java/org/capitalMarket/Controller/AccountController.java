package org.capitalMarket.Controller;

import org.capitalMarket.Model.ModelAccount;

public class AccountController {
    ModelAccount account;
    
    public AccountController() {
        account = new ModelAccount();
    }

    public void login(String user, String pass) {
        account.login(user,pass);
    }

    public void register(String user, String pass) {
        account.register(user, pass);
    }

    public int getID() {
        return account.getAccountId();
    }

    public String getUsername() {
        return account.currentUser.getUsername();
    }
}
