package org.capitalMarket.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import com.google.gson.reflect.TypeToken;

import org.capitalMarket.ModelJSON.ModelJSON;
import org.capitalMarket.Node.Account;

public class ModelAccount {
    public static ArrayList<Account> listUser;
    public Account currentUser = null;
    ModelJSON modelJSON;

    public ModelAccount() {
        modelJSON = new ModelJSON<>("src/main/java/org/capitalMarket/Database/User.json");
        listUser = modelJSON.readFromFile(new TypeToken<ArrayList<Account>>() {
        }.getType());;

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nShutting down. Saving data to JSON file...");
            modelJSON.writeToFile(listUser);
        }));
    }
    // register
    public boolean register(String user, String pass) {
        Account isNotDuplicated = queryAccount(user, pass);
        if (Objects.nonNull(isNotDuplicated)) {
            return false;
        }
        listUser.add(new Account(getLasIdUser()+1, user, pass));
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

    public int getLasIdUser(){
        if(listUser.isEmpty()) {
            return -1;
        }
        int idx = listUser.size() - 1;
        System.out.println(idx);
        return listUser.get(idx).getAccountId();
    }

    public static void main(String[] args) {
        ModelAccount test = new ModelAccount();
        // test.register("alif","nyahh");
        boolean status = test.login("alif", "nyahh");
        System.out.println("login "+ status);
    }
}
