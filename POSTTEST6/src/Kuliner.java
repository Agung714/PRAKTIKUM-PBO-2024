
import java.util.ArrayList;

// package src;
public class Kuliner implements Barang {
    public String nama;
    public double harga; 
    public double harga_beli; 
    public int stok; 
    public String expired;
    Kategori kategori; 
    public static ArrayList<Kuliner> DataKuliner = new ArrayList<>();;
    Kuliner(String nama, double harga,double harga_beli, int stok,String exp, Kategori kategoris) {
        this.nama = nama;
        this.harga = harga;
        this.harga_beli = harga_beli;
        this.stok = stok;
        this.expired = exp;
        this.kategori = kategoris; 
        DataKuliner.add(this);
    } 
    public Kuliner(String nama,Kategori kategoris) {
        this.nama = nama;
        this.harga = 0;
        this.harga_beli = 0;
        this.stok = 0;
        this.expired = "00-00";
        this.kategori = kategoris;
        DataKuliner.add(this);
    } 
    public Kuliner(double harga, Kategori kategoris) {
        this.nama = "";
        this.harga = harga;
        this.harga_beli = 0;
        this.stok = 0;
        this.expired = "00-00";
        this.kategori = kategoris;
        DataKuliner.add(this);
    } 
    public Kuliner(Kategori kategoris,double harga_beli) {
        this.nama = "";
        this.harga = 0;
        this.harga_beli = harga_beli;
        this.stok = 0;
        this.expired = "00-00";
        this.kategori = kategoris;
        DataKuliner.add(this);
    } 
    public Kuliner(int stok, Kategori kategoris) {
        this.nama = "";
        this.harga = 0;
        this.harga_beli = 0;
        this.stok = stok;
        this.expired = "00-00";
        this.kategori = kategoris;
        DataKuliner.add(this);
    } 
    
    public static ArrayList <Kuliner> getDataKuliner(){
        return DataKuliner;
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
    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    @Override
    public final void tampil_data() throws NumberFormatException {
        int count=1;
        for (int i = 0; i < DataKuliner.size(); i++) {
            System.out.printf("No. %2d ", (count));
            System.out.println("");
            System.out.println("Nama      : " + DataKuliner.get(i).getNama());
            System.out.println("Harga     : " + DataKuliner.get(i).getHarga());
            System.out.println("Harga Beli: " + DataKuliner.get(i).getHarga_B());
            System.out.println("Stok      : " + DataKuliner.get(i).getStok());
            System.out.println("Expired   : " + DataKuliner.get(i).getExpired());
            System.out.println("Kategori  : " + DataKuliner.get(i).getKategori().getNama());
            System.out.println("Deskripsi : " + DataKuliner.get(i).getKategori().getDeskripsi());
            System.out.println("\n");
            count++;
        }
    }
}
