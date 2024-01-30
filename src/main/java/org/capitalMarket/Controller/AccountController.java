package org.capitalMarket.Controller;

import java.util.Objects;

import org.capitalMarket.Model.ModelAccount;
import org.capitalMarket.Node.Account;

public class AccountController {
    ModelAccount account;
    boolean loginStatus;
    Account currentUser;
    
    public AccountController() {
        account = new ModelAccount();
        loginStatus = false;
        currentUser = null;
    }

    public boolean login(String user, String pass) {
        loginStatus = account.login(user, pass);
        if (!loginStatus) {
            return false;
        }
        currentUser = account.queryAccount(user, pass);
        return loginStatus;
    }

    public boolean register(String user, String pass) {
        return account.register(user, pass);
    }

    public int getAccountId() {
        if (!loginStatus) {
            return 0;
        }
        return currentUser.getAccountId();
    }

    public String getUsername() {
        return account.currentUser.getUsername();
    }

    public Account getCurrentUser() {
        return currentUser;
    }

    public static void main(String[] args) {
        AccountController test = new AccountController();
        boolean status = test.register("alif", "null");
        System.out.println("status register "+status);
        status = test.login("alif", "null");
        System.out.println("status login "+status);
    }
}
