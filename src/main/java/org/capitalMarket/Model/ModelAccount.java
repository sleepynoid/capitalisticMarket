package org.capitalMarket.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import org.capitalMarket.Node.Account;

public class ModelAccount {
    public ArrayList<Account> listUser;
    public Account currentUser = null;
    boolean loginStatus = false;

    public ModelAccount() {
        listUser = new ArrayList<>();
    }
    // register
    public boolean register(String user, String pass) {
        Account isNotDuplicated = queryAccount(user, pass);
        if (Objects.nonNull(isNotDuplicated)) {
            return false;
        }
        listUser.add(new Account(user, pass));
        return true;
    }

    // login
    public boolean login(String user, String pass) {
        Account userAccount = queryAccount(user, pass);
        if (Objects.isNull(userAccount)) {
            return false;
        }
        currentUser = userAccount;
        return true;
    }

    public int getAccountId() {
        if (!loginStatus) {
            return 0;
        }
        return currentUser.getAccountId();
    }

    public Account queryAccount(String username, String password) {
        for (Account tempAccount : listUser) {
            String tmpString = tempAccount.getUsername();
            String tmpString2 = tempAccount.getPassword();
            if (tmpString.equals(username) && tmpString2.equals(password) ) {
                return tempAccount;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ModelAccount test = new ModelAccount();
        test.register("alif","nyahh");
        boolean status = test.login("null", "null");
        System.out.println("login "+ status);
    }
}
