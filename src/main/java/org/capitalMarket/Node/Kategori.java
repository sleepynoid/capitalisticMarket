package org.capitalMarket.Node;

import java.util.Objects;

public class Kategori {
    private int idKategori;
    private String nameKategori;

    public Kategori(int idKategori, String nameKategori) {
        this.idKategori = idKategori;
        this.nameKategori = nameKategori;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public String getNameKategori() {
        return nameKategori;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategori kategori = (Kategori) o;
        return idKategori == kategori.idKategori && Objects.equals(nameKategori, kategori.nameKategori);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKategori, nameKategori);
    }

    @Override
    public String toString() {
        return "Kategori{" +
                "idKategori=" + idKategori +
                ", nameKategori='" + nameKategori + '\'' +
                '}';
    }
}
