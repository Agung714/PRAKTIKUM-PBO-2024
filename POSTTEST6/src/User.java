import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class User extends akun {
    private String priv = "User"; 
    
    private ArrayList <Barang> DataBarang;
    public static InputStreamReader p = new InputStreamReader(System.in);
    public static BufferedReader input = new BufferedReader(p);

    public ArrayList<Kuliner> DataKuliner = new ArrayList<>();
    public ArrayList<Pakaian> DataPakaian = new ArrayList<>();

    public User(String username, String password, String priv,ArrayList<Kuliner> DataKuliner,ArrayList<Pakaian> DataPakaian) {
        super(username, password,DataKuliner,DataPakaian);
        this.priv = priv;
        this.DataKuliner=DataKuliner;
        this.DataPakaian=DataPakaian;
    }

    public String getPriv() {
        return priv;
    }
    @Override
    public final void tampil_data() throws NumberFormatException, IOException {
        int count=1;
        for (int i = 0; i < DataKuliner.size(); i++) {
            System.out.printf("No. %2d ", (count));
            System.out.println("");
            System.out.println("Nama     : " + DataKuliner.get(i).getNama());
            System.out.println("Harga    : " + DataKuliner.get(i).getHarga());
            System.out.println("Stok     : " + DataKuliner.get(i).getStok());
            System.out.println("Expired  : " + DataKuliner.get(i).getExpired());
            System.out.println("Kategori : " + DataKuliner.get(i).getKategori().getNama());
            System.out.println("Deskripsi: " + DataKuliner.get(i).getKategori().getDeskripsi());
            System.out.println("\n");
            count++;
        }
        for (int i = 0; i < DataPakaian.size(); i++) {
            System.out.printf("No. %2d ", (count));
            System.out.println("");
            System.out.println("Nama     : " + DataPakaian.get(i).getNama());
            System.out.println("Harga    : " + DataPakaian.get(i).getHarga());
            System.out.println("Stok     : " + DataPakaian.get(i).getStok());
            System.out.println("Ukuran   : " + DataPakaian.get(i).getUkuran());
            System.out.println("Kategori : " + DataPakaian.get(i).getKategori().getNama());
            System.out.println("Deskripsi: " + DataPakaian.get(i).getKategori().getDeskripsi());
            System.out.println("\n");
            count++;
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
