import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class akun{
    private String Username;
    private String Password;
    public static InputStreamReader p = new InputStreamReader(System.in);
    public static BufferedReader input = new BufferedReader(p);
    private ArrayList<Barang> DataBarang;

    
    public akun(String user, String pass,ArrayList<Barang> DataBarang){
        this.Username = user;
        this.Password = pass;
        this.DataBarang = DataBarang;
    }
    

    public String getUsername(){
        return Username; 
    }
    public String getAkun(){
        return Username;
    }

    public String getPass(){
        return Password;
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
    
    public void tampil_data() throws NumberFormatException, IOException {
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
}


