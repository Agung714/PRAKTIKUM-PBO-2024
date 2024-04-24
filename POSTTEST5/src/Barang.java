import java.util.*;
public class Barang {
    private String nama;
    private double harga; 
    private double harga_beli; 
    private int stok; 
    Kategori kategori; 
    public static ArrayList<Barang> DataBarang = new ArrayList<>();;
    
    public Barang(String nama, double harga,double harga_beli, int stok, Kategori kategoris) {
        this.nama = nama;
        this.harga = harga;
        this.harga_beli = harga_beli;
        this.stok = stok;
        this.kategori = kategoris;
        DataBarang.add(this);
    } 
    public Barang(String nama,Kategori kategoris) {
        this.nama = nama;
        this.harga = 0;
        this.harga_beli = 0;
        this.stok = 0;
        this.kategori = kategoris;
        DataBarang.add(this);
    } 
    public Barang(double harga, Kategori kategoris) {
        this.nama = "";
        this.harga = harga;
        this.harga_beli = 0;
        this.stok = 0;
        this.kategori = kategoris;
        DataBarang.add(this);
    } 
    public Barang(Kategori kategoris,double harga_beli) {
        this.nama = "";
        this.harga = 0;
        this.harga_beli = harga_beli;
        this.stok = 0;
        this.kategori = kategoris;
        DataBarang.add(this);
    } 
    public Barang(int stok, Kategori kategoris) {
        this.nama = "";
        this.harga = 0;
        this.harga_beli = 0;
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
    public double getHarga_B() {
        return harga_beli;
    }
    public void setHarga_B(double harga_beli) {
        this.harga_beli = harga_beli;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}

