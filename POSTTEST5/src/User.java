import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class User extends akun {
    private String priv = "User"; 
    
    private ArrayList <Barang> DataBarang;
    public static InputStreamReader p = new InputStreamReader(System.in);
    public static BufferedReader input = new BufferedReader(p);

    public User(String username, String password, String priv,ArrayList<Barang> DataBarang) {
        super(username, password,DataBarang);
        this.priv = priv;
        this.DataBarang=DataBarang;
    }

    public String getPriv() {
        return priv;
    }
    @Override
    public final void tampil_data() throws NumberFormatException, IOException {
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
// bisa menu dijadikan overdrive
    public void userMenu() throws IOException {
        akun.clear();
        System.out.println("\t=========================");
        System.out.println("\t          Menu      ");
        System.out.println("\t=========================");
        System.out.println("\t= 1. Lihat Data Barang  =");
        System.out.println("\t= 2. Kembali            =");
        System.out.print("\n\tMasukan Pilihan Anda : ");
        int pilih = akun.error_int();
        switch (pilih) {
            case 1:
                tampil_data();
                break;
            case 2:
                akun.clear();
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
