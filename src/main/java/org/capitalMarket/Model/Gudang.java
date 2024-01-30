package org.capitalMarket.Model;

import java.util.ArrayList;

import org.capitalMarket.ModelJSON.ModelJSON;
import org.capitalMarket.Node.Account;
import org.capitalMarket.Node.Sepatu;

import com.google.gson.reflect.TypeToken;

public class Gudang {
    static ArrayList<Sepatu> listSepatu;
    ModelJSON modelJSON;
    public Gudang() {
        modelJSON = new ModelJSON<>("src/main/java/org/capitalMarket/Database/Gudang.json");
        listSepatu = modelJSON.readFromFile(new TypeToken<ArrayList<Sepatu>>() {
        }.getType());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nShutting down. Saving data to JSON file...");
            modelJSON.writeToFile(listSepatu);
        }));
    }
    public void add(Sepatu newSepatu) {
        listSepatu.add(newSepatu);
    }

    public boolean del(String nameSepatu) {
        return listSepatu.removeIf(e -> e.getNama().equals(nameSepatu));
    }

    public ArrayList<Sepatu> getListSepatu() {
        return listSepatu;
    }

    public void save() {
        modelJSON.writeToFile(listSepatu);
    }

    public Sepatu getSepatu(String findString) {
        for (Sepatu tmpSepatu : listSepatu) {
            if (tmpSepatu.getNama().equals(findString)) {
                return tmpSepatu;
            }
        }
        return null;
    }
    
    public void setListSepatu(ArrayList<Sepatu> listSepatu) {
        this.listSepatu = listSepatu;
    }

    public static void main(String[] args) {
        Gudang test = new Gudang();
        test.add(new Sepatu("nikku", "nikka", 10, "sepatu lari"));
    }
}
