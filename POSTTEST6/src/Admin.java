// package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// import Praktikum.pert6.pert6.src.Pakaian;
 
public class Admin extends akun {
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private String priv = "Admin";
    public ArrayList<Kategori> daftarKategori = new ArrayList<>();
    // private ArrayList<Barang> DataBarang;
    String namaKategori;
    public ArrayList<Kuliner> DataKuliner = new ArrayList<>();
    public ArrayList<Pakaian> DataPakaian = new ArrayList<>();

    public Admin(String username, String password, String priv, ArrayList<Kuliner> DataKuliner,ArrayList<Pakaian> DataPakaian) {
        super(username, password,DataKuliner,DataPakaian);
        this.priv = priv;
        this.DataKuliner = DataKuliner;
        this.DataPakaian = DataPakaian;
    }

    // public ArrayList<Barang> getDataBarang() {
    //     return DataBarang;
    // } 

    public String getPriv() {
        return priv;
    }

    public static int error_int() throws IOException {
        int masukkan_integer = 0;
        while (true) {
            try {
                masukkan_integer = Integer.parseInt(input.readLine());
                break;
            } catch (NumberFormatException e) {
                System.err.print("\tInputan harus Integer : ");
            }
        }
        return masukkan_integer;
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void tambah_data() throws IOException {
        System.out.println("=================");
        System.out.println("Tambah Data Barang");
        System.out.println("=================\n");
        System.out.print("Masukan Jumlah Data yang ingin dimasukan : ");
        int batasan = error_int();
        clear();
        for (int i = 0; i < batasan; i++) {
            System.out.println("==============================");
            System.out.println("Data ke- " + (i + 1));
            System.out.print("Masukkan Nama Barang : ");
            String nama = input.readLine();
            System.out.print("Masukkan Harga Barang :");
            double harga = error_int();
            System.out.print("Masukkan Harga Beli Barang :");
            double harga_b = error_int();
            System.out.print("Masukkan Jumlah Stok Barang :");
            int stok = error_int();
            while(true){

                System.out.println("================================");
            System.out.println("        Kategori Barang         ");
            System.out.println("================================");
            System.out.println("= 1. Kuliner                    =");
            System.out.println("= 2. Pakaian                    =");
            System.out.println("================================");
            System.out.print("Masukkan pilihan Anda : ");
            int pilih = error_int();
            
            if(pilih == 1){

             namaKategori = "Kuliner";
             break;
            }
            else if(pilih == 2){

             namaKategori = "Pakaian";
             break;
            }
            else{
                System.out.println("Inputan tidak terdaftar");
                continue;}
        }
        System.out.println(namaKategori);
            System.out.print("Masukkan Deskripsi Kategori : ");
            String deskripsiKategori = input.readLine();
            Kategori kategori = new Kategori(namaKategori, deskripsiKategori);
            if (!daftarKategori.contains(kategori)) {
                daftarKategori.add(kategori);
            }
            if(namaKategori == "Kuliner"){
                System.out.print("Masukkan Tanggal Expired :");
            String exp = input.readLine();
            Kuliner new_data = new Kuliner(nama, harga,harga_b, stok,exp, kategori);
            DataKuliner.add(new_data);
        }
        else if(namaKategori == "Pakaian"){
                System.out.print("Masukkan Ukuran Pakaian :");
            String size = input.readLine();
                Pakaian new_data = new Pakaian(nama, harga,harga_b, stok,size, kategori);
                DataPakaian.add(new_data);

            }
            
        }
        System.out.println("===============================");
        System.out.println("    Data Berhasil Ditambah");
        System.out.println("===============================");
        System.out.println("");
        System.out.println("Tekan enter untuk melanjutkan. . .");
        input.readLine();

    }
    @Override
    public final void tampil_data() throws NumberFormatException, IOException {
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
        System.out.println("Tekan enter untuk melanjutkan. . .");
        input.readLine();
    }

    void tampil_kategori() throws NumberFormatException, IOException {
        clear();
        System.out.println("===============");
        System.out.println("Daftar Kategori");
        System.out.println("===============");
        for (int i = 0; i < daftarKategori.size(); i++) {
            System.out.printf("No. %2d ", (i + 1));
            System.out.println("");
            System.out.println("Nama          : " + daftarKategori.get(i).getNama());
            System.out.println("Deskripsi     : " + daftarKategori.get(i).getDeskripsi());
            System.out.println("------------------------------");
        }
        System.out.println("Tekan enter untuk melanjutkan. . .");
        input.readLine();
    }

    private void update_data() throws NumberFormatException, IOException {
        tampil_data();
        System.out.println("=================");
        System.out.println("Update Data Barang");
        System.out.println("=================");
        System.out.println("");
        System.out.print("Input nama barang : ");
        String nm = input.readLine();
        for (Kuliner kuliner : DataKuliner) {
            if (kuliner.getNama().equals(nm)) {
                System.out.println("Nama      : " + kuliner.getNama());
                System.out.println("Harga     : " + kuliner.getHarga());
                System.out.println("Harga Beli: " + kuliner.getHarga_B());
                System.out.println("Stok      : " + kuliner.getStok());
                System.out.println("Kategori  : " + kuliner.getKategori().getNama());
                System.out.println("Deskripsi : " + kuliner.getKategori().getDeskripsi());
                System.out.println("\n");

                System.out.println("1. Ubah  Nama");
                System.out.println("2. Ubah  Harga");
                System.out.println("3. Ubah  Harga Beli");
                System.out.println("4. Ubah  Stok");
                System.out.print("Pilihan : ");
                int pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan Nama baru : ");
                        kuliner.setNama(input.readLine());
                        break;
                    case 2:
                        System.out.print("Masukkan Harga baru : ");
                        kuliner.setHarga(error_int());
                        break;
                        case 3:
                        System.out.print("Masukkan Harga Beli baru : ");
                        kuliner.setHarga_B(error_int());
                        break;
                    case 4:
                    System.out.print("Masukkan Stok : ");
                    kuliner.setStok(error_int());
                    break;
                    case 5:
                            System.out.print("Masukkan Expired baru : ");
                            kuliner.setExpired(input.readLine());
                            break;
                    default:
                        System.err.println("==========================");
                        System.err.println("  Inputan tidak terdaftar ");
                        System.err.println("==========================");
                        break;
                }
            }
        }
        for (Pakaian Pakaian : DataPakaian) {
            if (Pakaian.getNama().equals(nm)) {
                System.out.println("Nama      : " + Pakaian.getNama());
                System.out.println("Harga     : " + Pakaian.getHarga());
                System.out.println("Harga Beli: " + Pakaian.getHarga_B());
                System.out.println("Stok      : " + Pakaian.getStok());
                System.out.println("Ukuran    : " + Pakaian.getUkuran());
                System.out.println("Kategori  : " + Pakaian.getKategori().getNama());
                System.out.println("Deskripsi : " + Pakaian.getKategori().getDeskripsi());
                System.out.println("\n");

                System.out.println("1. Ubah  Nama");
                System.out.println("2. Ubah  Harga");
                System.out.println("3. Ubah  Harga Beli");
                System.out.println("4. Ubah  Stok");
                System.out.print("Pilihan : ");
                int pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan Nama baru : ");
                        Pakaian.setNama(input.readLine());
                        break;
                        case 2:
                        System.out.print("Masukkan Harga baru : ");
                        Pakaian.setHarga(error_int());
                        break;
                        case 3:
                        System.out.print("Masukkan Harga Beli baru : ");
                        Pakaian.setHarga_B(error_int());
                        break;
                        case 4:
                        System.out.print("Masukkan Stok : ");
                        Pakaian.setStok(error_int());
                        break;
                        case 5:
                            System.out.print("Masukkan Ukuran baru : ");
                            Pakaian.setUkuran(input.readLine());
                            break;
                    default:
                        System.err.println("==========================");
                        System.err.println("  Inputan tidak terdaftar ");
                        System.err.println("==========================");
                        break;
                }
            }
        }
    }

    private void delete_data() throws NumberFormatException, IOException {
        tampil_data();
        System.out.println("=================");
        System.out.println("Delete Data Barang");
        System.out.println("=================");
        System.out.print("Input nama barang : ");
        String nm2 = input.readLine();
        for (Kuliner kuliner : DataKuliner) {
            if (kuliner.getNama().equals(nm2)) {

                System.out.println("Nama      : " + kuliner.getNama());
                System.out.println("Harga     : " + kuliner.getHarga());
                System.out.println("Harga Beli: " + kuliner.getHarga_B());
                System.out.println("Stok      : " + kuliner.getStok());
                System.out.println("Kategori  : " + kuliner.getKategori().getNama());
                System.out.println("Deskripsi : " + kuliner.getKategori().getDeskripsi());
                System.out.println("\n");

                System.out.print("Hapus data [y/n] : ");
                String yakin = input.readLine();
                if (yakin.equalsIgnoreCase("y")) {
                    DataKuliner.remove(kuliner);
                    System.out.println("===============================");
                    System.out.println("    Data berhasil dihapus !");
                    System.out.println("===============================");
                }
                break;
            }
        }for (Pakaian pakaian : DataPakaian) {
            if (pakaian.getNama().equals(nm2)) {

                System.out.println("Nama      : " + pakaian.getNama());
                System.out.println("Harga     : " + pakaian.getHarga());
                System.out.println("Harga Beli: " + pakaian.getHarga_B());
                System.out.println("Stok      : " + pakaian.getStok());
                System.out.println("Kategori  : " + pakaian.getKategori().getNama());
                System.out.println("Deskripsi : " + pakaian.getKategori().getDeskripsi());
                System.out.println("\n");

                System.out.print("Hapus data [y/n] : ");
                String yakin = input.readLine();
                if (yakin.equalsIgnoreCase("y")) {
                    DataPakaian.remove(pakaian);
                    System.out.println("===============================");
                    System.out.println("    Data berhasil dihapus !");
                    System.out.println("===============================");
                }
                break;
            }
        }
    }

    public void adminMenu() throws IOException {
        clear();
        while (true) {
            System.out.println("\t=========================");
            System.out.println("\t          Menu      ");
            System.out.println("\t=========================");
            System.out.println("\t= 1. Tambah Data Barang =");
            System.out.println("\t= 2. Lihat Data Barang  =");
            System.out.println("\t= 3. Lihat Kategori     =");
            System.out.println("\t= 4. Ubah Data Barang   =");
            System.out.println("\t= 5. Hapus Data Barang  =");
            System.out.println("\t= 6. Kembali            =");
            System.out.print("\n\tMasukan Pilihan Anda : ");
            int pilih = error_int();
            switch (pilih) {
                case 1:
                    clear();
                    tambah_data();
                    break;
                case 2:
                    clear();
                    tampil_data();
                    break;
                case 3:
                    clear();
                    tampil_kategori();
                    break;
                case 4:
                    clear();
                    update_data();
                    break;
                case 5:
                    clear();
                    delete_data();
                    break;
                case 6:
                    clear();
                    return;
                default:
                    System.err.println("===============================");
                    System.err.println("    Inputan tidak terdaftar");
                    System.err.println("===============================");
                    System.out.println("Tekan enter untuk melanjutkan");
                    input.readLine();
                    break;
            }
        }
    }
}
