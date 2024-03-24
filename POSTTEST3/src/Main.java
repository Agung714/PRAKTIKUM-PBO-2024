import java.io.*;
import java.util.*;

public class Main {
    static InputStreamReader p = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(p);
    private static ArrayList<Barang> DataBarang = new ArrayList<>();
    public static Admin MyAdmin = new Admin("1", "1", "Admin",DataBarang);
    public static User user1 = new User("2", "2", "user",DataBarang);
    public static akun akun = new akun("2", "2");
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        menu_login();
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

        public static void menu_login() throws NumberFormatException, IOException {
        while (true) {
            clear();
            System.out.println("================================");
            System.out.println("       Toko Souvenir Duncan     ");
            System.out.println("================================");
            System.out.println("= 1. Login Admin               =");
            System.out.println("= 2. Login User                =");
            System.out.println("= 3. Exit                      =");
            System.out.println("================================");
            System.out.print("Masukkan pilihan Anda : ");
            int pilih = error_int();
            switch (pilih) {
                case 1:
                    login();
                    break;
                case 2:
                    login_user();
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

    private static void login() throws NumberFormatException, IOException {
        clear();
        System.out.println("==============================");
        System.out.println("=           LOGIN            =");
        System.out.println("==============================");
        System.out.print("Masukkan Username : ");
        String userp = input.readLine();
        System.out.print("Masukkan Password : ");
        String passp = input.readLine();
        if(userp.equalsIgnoreCase(MyAdmin.getUsername()) && passp.equalsIgnoreCase(MyAdmin.getPass())) {
            MyAdmin.adminMenu();
        }else {
            System.out.println("Username atau password salah!!!");input.readLine();
        }
    }
    private static void login_user() throws NumberFormatException, IOException {
        clear();
        System.out.println("==============================");
        System.out.println("=           LOGIN            =");
        System.out.println("==============================");
        System.out.print("Masukkan Username : ");
        String userp = input.readLine();
        System.out.print("Masukkan Password : ");
        String passp = input.readLine();
            if (akun.getUsername().equals(userp)) {
                if (akun.getPass().equals(passp)) {
                    clear();
                    user1.userMenu();
                }
            } 
            else {
                clear();
                System.out.println("=================================");
                System.out.println("  Username atau Password Salah");
                System.out.println("=================================");
            }
    }
}