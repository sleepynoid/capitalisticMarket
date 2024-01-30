package org.capitalMarket.Controller;

import org.capitalMarket.Model.ModelGudang;
import org.capitalMarket.Node.Account;
import org.capitalMarket.Node.Sepatu;

public class ControllerGudang {
    static ModelGudang gudang;

    public ControllerGudang(Account akun) {
        gudang = new ModelGudang(akun);
    }

    void add(Sepatu newSepatu) {
        gudang.add(newSepatu);
        gudang.save
    }

    void del(String namaSepatu) {
        gudang.del(namaSepatu);
    }

    Sepatu getSepatu(String findString) {
        Sepatu target = gudang.getSepatu(findString);
        return target == null ? null:target;
    }
}
