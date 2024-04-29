
import java.util.ArrayList;

// package src;

public class Pakaian implements Barang{
    public String nama;
    public double harga; 
    public double harga_beli; 
    public int stok; 
    public String ukuran;
    Kategori kategori; 
    public static ArrayList<Pakaian> DataPakaian = new ArrayList<>();;
    Pakaian(String nama, double harga,double harga_beli, int stok,String ukuran1, Kategori kategoris) {
        this.nama = nama;
        this.harga = harga;
        this.harga_beli = harga_beli;
        this.stok = stok;
        this.ukuran = ukuran1;
        this.kategori = kategoris; 
        DataPakaian.add(this);
    } 
    public Pakaian(String nama,Kategori kategoris) {
        this.nama = nama;
        this.harga = 0;
        this.harga_beli = 0;
        this.stok = 0;
        this.ukuran = "Unknown";
        this.kategori = kategoris;
        DataPakaian.add(this);
    } 
    public Pakaian(double harga, Kategori kategoris) {
        this.nama = "";
        this.harga = harga;
        this.harga_beli = 0;
        this.stok = 0;
        this.ukuran = "Unknown";
        this.kategori = kategoris;
        DataPakaian.add(this);
    } 
    public Pakaian(Kategori kategoris,double harga_beli) {
        this.nama = "";
        this.harga = 0;
        this.harga_beli = harga_beli;
        this.stok = 0;
        this.ukuran = "Unknown";
        this.kategori = kategoris;
        DataPakaian.add(this);
    } 
    public Pakaian(int stok, Kategori kategoris) {
        this.nama = "";
        this.harga = 0;
        this.harga_beli = 0;
        this.stok = stok;
        this.ukuran = "Unknown";
        this.kategori = kategoris;
        DataPakaian.add(this);
    } 
    
    public static ArrayList <Pakaian> getDataPakaian(){
        return DataPakaian;
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
    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }
    
    @Override
    public final void tampil_data() throws NumberFormatException {
        int count=1;
        for (int i = 0; i < DataPakaian.size(); i++) {
            System.out.printf("No. %2d ", (count));
            System.out.println("");
            System.out.println("Nama      : " + DataPakaian.get(i).getNama());
            System.out.println("Harga     : " + DataPakaian.get(i).getHarga());
            System.out.println("Harga Beli: " + DataPakaian.get(i).getHarga_B());
            System.out.println("Stok      : " + DataPakaian.get(i).getStok());
            System.out.println("Ukuran    : " + DataPakaian.get(i).getUkuran());
            System.out.println("Kategori  : " + DataPakaian.get(i).getKategori().getNama());
            System.out.println("Deskripsi : " + DataPakaian.get(i).getKategori().getDeskripsi());
            System.out.println("\n");
            count++;
        }
    }
}
