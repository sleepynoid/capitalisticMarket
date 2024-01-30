package org.capitalMarket.Node;

public class Sepatu {
    private String nama;
    private String namaBrand;
    private String kategori;
    private int ukuran;

    public Sepatu(String nama, String namaBrand, int ukuran, String kategori) {
        this.nama = nama;
        this.namaBrand = namaBrand;
        this.ukuran = ukuran;
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public String getNamaBrand() {
        return namaBrand;
    }

    public int getUkuran() {
        return ukuran;
    }
    
    public String getKategori() {
        return kategori;
    }

}
