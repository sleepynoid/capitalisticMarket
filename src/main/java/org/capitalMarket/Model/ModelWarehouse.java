package org.capitalMarket.Model;

import java.util.ArrayList;

public class ModelWarehouse {
    // user super admin
    // current limited admin user
    // implement account login system later
    ArrayList<Warehouse> listGudang;
    private static int counterGudang = 0;
    
    public ModelWarehouse() {
        listGudang = new ArrayList<>();
    }

    public Warehouse getGudang(String Username, String Password) {
        for (Warehouse tmpWarehouse : listGudang) {
            // check if the current user have access to that gudang
            // get username & pass
            // if right getwarehouse
        }
        return null;
    }

    public boolean addGudang() {
        // add gudang with asociated user
        // check if the 
        return true;
    }
}
