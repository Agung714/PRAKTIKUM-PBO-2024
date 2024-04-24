
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public abstract class akun{
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
    
    public abstract void tampil_data() throws NumberFormatException, IOException;
    
}


