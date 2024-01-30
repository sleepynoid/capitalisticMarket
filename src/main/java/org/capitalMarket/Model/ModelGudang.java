package org.capitalMarket.Model;

import java.util.ArrayList;

import org.capitalMarket.ModelJSON.ModelJSON;
import org.capitalMarket.Node.Account;
import org.capitalMarket.Node.Sepatu;

import com.google.gson.reflect.TypeToken;

public class ModelGudang {
    Gudang gudang;
    ModelJSON modelJSON;

    public ModelGudang(Account akun) {
        modelJSON = new ModelJSON<>("src/main/java/org/capitalMarket/Database/Gudang.json");
        gudang = new Gudang(akun);

        gudang.setListSepatu(modelJSON.readFromFile(new TypeToken<ArrayList<Account>>() {}.getType()));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nShutting down. Saving data to JSON file...");
            modelJSON.writeToFile(gudang.getListSepatu());
        }));
    }

    public void add(Sepatu newSepatu) {
        gudang.add(newSepatu);
    }

    public void del(String namaSepatu) {
        gudang.del(namaSepatu);
    }

    public Sepatu getSepatu(String findString) {
        for (Sepatu tmpSepatu : gudang.getListSepatu()) {
            if (tmpSepatu.getNama().equals(findString)) {
                return tmpSepatu;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ModelGudang test = new ModelGudang(new Account(1, "null", "null"));
        test.add(new Sepatu("nikken", "niku", 10, "Sepatu lari"));
        for (Sepatu tmp : test.gudang.getListSepatu()) {
            System.out.println(tmp.getNama());
        }

    }
}
