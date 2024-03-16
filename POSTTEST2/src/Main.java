import java.io.*;
import java.util.*;

public class Main {
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<Barang> DataBarang = new ArrayList<>();
    private static ArrayList<akun> DataAkun = new ArrayList<>();
    private static ArrayList<Kategori> daftarKategori = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        menu_login();
    }
 
    protected static void tambah_data() throws NumberFormatException, IOException {
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

            Barang new_data = new Barang(nama, harga, stok, kategori);
            DataBarang.add(new_data);
        }
        System.out.println("===============================");
        System.out.println("    Data Berhasil Ditambah");
        System.out.println("===============================");
        System.out.println("");
        System.out.println("Tekan enter untuk melanjutkan. . .");
        input.readLine();

    }

    private static void tampil_data() throws NumberFormatException, IOException {
        for (int i = 0; i < DataBarang.size(); i++) {
            System.out.printf("No. %2d ", (i + 1));
            System.out.println("");
            System.out.println("Nama     : " + DataBarang.get(i).getNama());
            System.out.println("Harga    : " + DataBarang.get(i).getHarga());
            System.out.println("Stok     : " + DataBarang.get(i).getStok());
            System.out.println("Kategori : " + DataBarang.get(i).getKategori().getNama());
            System.out.println("Deskripsi: " + DataBarang.get(i).getKategori().getDeskripsi());
            System.out.println("\n");
        }
        System.out.println("Tekan enter untuk melanjutkan. . .");
        input.readLine();
    }

    static void tampil_kategori() throws NumberFormatException, IOException {
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

    private static void update_data() throws NumberFormatException, IOException {
        tampil_data();
        System.out.println("=================");
        System.out.println("Update Data Barang");
        System.out.println("=================");
        System.out.println("");
        System.out.print("Input nama barang : ");
        String nm = input.readLine();
        for (Barang barang : DataBarang) {
            if (barang.getNama().equals(nm)) {
                System.out.println("Nama     : " + barang.getNama());
                System.out.println("Harga    : " + barang.getHarga());
                System.out.println("Stok     : " + barang.getStok());
                System.out.println("Kategori : " + barang.getKategori().getNama());
                System.out.println("Deskripsi: " + barang.getKategori().getDeskripsi());
                System.out.println("\n");

                System.out.println("1. Ubah  Nama");
                System.out.println("2. Ubah  Harga");
                System.out.println("3. Ubah  Stok");
                System.out.println("4. Ubah  Kategori");
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
                        System.out.print("Masukkan Stok : ");
                        barang.setStok(error_int());
                        break;
                    case 4:
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

    private static void delete_data() throws NumberFormatException, IOException {
        tampil_data();
        System.out.println("=================");
        System.out.println("Delete Data Barang");
        System.out.println("=================");
        System.out.print("Input nama barang : ");
        String nm2 = input.readLine();
        for (Barang barang : DataBarang) {
            if (barang.getNama().equals(nm2)) {

                System.out.println("Nama     : " + barang.getNama());
                System.out.println("Harga    : " + barang.getHarga());
                System.out.println("Stok     : " + barang.getStok());
                System.out.println("Kategori : " + barang.getKategori().getNama());
                System.out.println("Deskripsi: " + barang.getKategori().getDeskripsi());
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

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int error_int() throws IOException {
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

    private static void exit() {
        System.out.println("===============================================");
        System.out.println("  TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI");
        System.out.println("===============================================");
    }

    private static void menu_login() throws NumberFormatException, IOException {
        while (true) {
            clear();
            System.out.println("================================");
            System.out.println("       Toko Souvenir Duncan     ");
            System.out.println("================================");
            System.out.println("= 1. Register                  =");
            System.out.println("= 2. Login                     =");
            System.out.println("= 3. Exit                      =");
            System.out.println("================================");
            System.out.print("Masukkan pilihan Anda : ");
            int pilih = error_int();
            switch (pilih) {
                case 1:
                    daftar();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    exit();
                    System.exit(0);
                    break;
                default:
                    System.err.println("==========================");
                    System.err.println(" Inputan tidak terdaftar");
                    System.err.println("==========================");
                    break;
            }
        }

    }

    private static void daftar() throws IOException {
        clear();
        System.out.println("=============================");
        System.out.println("=           REGISTER        =");
        System.out.println("=============================");
        System.out.print("Masukkan username : ");
        String user = input.readLine();
        System.out.print("Masukkan password : ");
        String pass = input.readLine();
        akun new_akun = new akun(user, pass);
        DataAkun.add(new_akun);
        System.out.println("===============================");
        System.out.println("    Akun berhasil ditambah");
        System.out.println("===============================");
        System.out.println("");
        System.out.println("Tekan enter untuk melanjutkan. . .");
        input.readLine();
        login();
    }

    private static void login() throws NumberFormatException, IOException {
        clear();
        System.out.println("==============================");
        System.out.println("=           LOGIN            =");
        System.out.println("==============================");
        System.out.print("Masukkan Username : ");
        String userp = input.readLine();
        System.out.print("Masukkan Password : ");
        String passp = input.readLine();
        for (akun akun : DataAkun) {
            if (akun.getusername().equals(userp)) {
                if (akun.getPass().equals(passp)) {
                    clear();

                    utama();
                    break;
                }
            } else {
                clear();
                System.out.println("=================================");
                System.out.println("  Username atau Password Salah");
                System.out.println("=================================");
            }
        }
    }

    private static void utama() throws NumberFormatException, IOException {
        boolean lanjut = true;
        while (lanjut) {
            clear();
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
                    menu_login();
                    break;
                default:
                    System.err.println("===============================");
                    System.err.println("    Inputan tidak terdaftar");
                    System.err.println("===============================");
                    System.out.println("Tekan enter untuk melanjutkan");
                    input.readLine();
                    break;
            }
        }
        exit();
    }
}