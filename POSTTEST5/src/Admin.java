import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Admin extends akun {
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private String priv = "Admin";
    public ArrayList<Kategori> daftarKategori = new ArrayList<>();
    private ArrayList<Barang> DataBarang;

    public Admin(String username, String password, String priv, ArrayList<Barang> DataBarang) {
        super(username, password,DataBarang);
        this.priv = priv;
        this.DataBarang = DataBarang;
    }

    public ArrayList<Barang> getDataBarang() {
        return DataBarang;
    } 

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

            System.out.print("Masukkan Nama Kategori : ");
            String namaKategori = input.readLine();
            System.out.print("Masukkan Deskripsi Kategori : ");
            String deskripsiKategori = input.readLine();
            Kategori kategori = new Kategori(namaKategori, deskripsiKategori);
            if (!daftarKategori.contains(kategori)) {
                daftarKategori.add(kategori);
            }

            Barang new_data = new Barang(nama, harga,harga_b, stok, kategori);
            DataBarang.add(new_data);
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
        for (int i = 0; i < DataBarang.size(); i++) {
            System.out.printf("No. %2d ", (i + 1));
            System.out.println("");
            System.out.println("Nama      : " + DataBarang.get(i).getNama());
            System.out.println("Harga     : " + DataBarang.get(i).getHarga());
            System.out.println("Harga Beli: " + DataBarang.get(i).getHarga_B());
            System.out.println("Stok      : " + DataBarang.get(i).getStok());
            System.out.println("Kategori  : " + DataBarang.get(i).getKategori().getNama());
            System.out.println("Deskripsi : " + DataBarang.get(i).getKategori().getDeskripsi());
            System.out.println("\n");
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
        for (Barang barang : DataBarang) {
            if (barang.getNama().equals(nm)) {
                System.out.println("Nama      : " + barang.getNama());
                System.out.println("Harga     : " + barang.getHarga());
                System.out.println("Harga Beli: " + barang.getHarga_B());
                System.out.println("Stok      : " + barang.getStok());
                System.out.println("Kategori  : " + barang.getKategori().getNama());
                System.out.println("Deskripsi : " + barang.getKategori().getDeskripsi());
                System.out.println("\n");

                System.out.println("1. Ubah  Nama");
                System.out.println("2. Ubah  Harga");
                System.out.println("3. Ubah  Harga Beli");
                System.out.println("4. Ubah  Stok");
                System.out.println("5. Ubah  Kategori");
                System.out.print("Pilihan : ");
                int pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan Nama baru : ");
                        barang.setNama(input.readLine());
                        break;
                    case 2:
                        System.out.print("Masukkan Harga baru : ");
                        barang.setHarga(error_int());
                        break;
                        case 3:
                        System.out.print("Masukkan Harga Beli baru : ");
                        barang.setHarga_B(error_int());
                        break;
                    case 4:
                    System.out.print("Masukkan Stok : ");
                    barang.setStok(error_int());
                    break;
                    case 5:
                        System.out.print("Masukkan Kategori baru : ");
                        barang.getKategori().setNama(input.readLine());
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
        for (Barang barang : DataBarang) {
            if (barang.getNama().equals(nm2)) {

                System.out.println("Nama      : " + barang.getNama());
                System.out.println("Harga     : " + barang.getHarga());
                System.out.println("Harga Beli: " + barang.getHarga_B());
                System.out.println("Stok      : " + barang.getStok());
                System.out.println("Kategori  : " + barang.getKategori().getNama());
                System.out.println("Deskripsi : " + barang.getKategori().getDeskripsi());
                System.out.println("\n");

                System.out.print("Hapus data [y/n] : ");
                String yakin = input.readLine();
                if (yakin.equalsIgnoreCase("y")) {
                    DataBarang.remove(barang);
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
