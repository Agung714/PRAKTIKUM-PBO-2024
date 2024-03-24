import java.util.*;
public class Barang {
    private String nama;
    private double harga; 
    private int stok;
    Kategori kategori; 
    public static ArrayList<Barang> DataBarang = new ArrayList<>();;
    
    public Barang(String nama, double harga, int stok, Kategori kategoris) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategoris;
        DataBarang.add(this);
    } 
    
    public static ArrayList <Barang> getDatabarang(){
        return DataBarang;
    }
    Kategori getKategori() {
        return this.kategori; 
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}

