import java.util.*;

// Kelas induk untuk Saham dan SBN
abstract class Investasi {
    String nama;

    // Constructor untuk inisialisasi objek Investasi
    Investasi(String nama) {
        this.nama = nama;
    }

    // Method abstrak untuk menampilkan detail investasi
    abstract void tampilDetail();
}

// Class untuk Saham, mewarisi Investasi
class Saham extends Investasi {
    String kode;
    double harga;

    // Constructor untuk inisialisasi objek Saham
    Saham(String kode, String nama, double harga) {
        super(nama);
        this.kode = kode;
        this.harga = harga;
    }

    @Override
    void tampilDetail() {
        System.out.printf("Saham %s - %s | Harga: Rp %.2f\n", kode, nama, harga);
    }
}

// Class untuk SBN, mewarisi Investasi
class SBN extends Investasi {
    double bunga;
    int jangkaWaktu;
    String tanggalJatuhTempo;
    double kuotaNasional;

    // Constructor untuk inisialisasi objek SBN
    SBN(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, double kuotaNasional) {
        super(nama);
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }

    @Override
    void tampilDetail() {
        System.out.printf("SBN %s | Bunga: %.2f%% | Kuota: Rp %.2f | Jatuh Tempo: %s\n", nama, bunga, kuotaNasional, tanggalJatuhTempo);
    }
}

// Class Customer, menyimpan data pengguna dan saham yang dimiliki
class Customer {
    String username;
    Map<String, Integer> sahamDimiliki = new HashMap<>();
    Map<String, Double> nominalSaham = new HashMap<>();
    Map<String, Double> sbnDimiliki = new HashMap<>();

    // Constructor untuk inisialisasi objek Customer
    Customer(String username) {
        this.username = username;
    }
}

// Main program untuk aplikasi investasi
public class InvestasiApp {
    static Scanner input = new Scanner(System.in);
    static Map<String, String> akun = new HashMap<>();  // Penyimpanan akun login (username dan password)
    static List<Investasi> listInvestasi = new ArrayList<>();  // Daftar investasi (Saham dan SBN)
    static Map<String, Customer> pelanggan = new HashMap<>();  // Penyimpanan data customer

    public static void main(String[] args) {
        // Hardcoded akun untuk admin dan user
        akun.put("admin", "admin123");
        akun.put("user", "user123");
        pelanggan.put("user", new Customer("user"));

        // Program utama yang menampilkan menu login
        while (true) {
            System.out.println("\n== MENU AWAL ==\n1. Login\n0. Keluar");
            String pilihan = input.nextLine();
            if (pilihan.equals("1")) {
                System.out.print("Username: ");
                String username = input.nextLine();
                System.out.print("Password: ");
                String password = input.nextLine();
                if (akun.containsKey(username) && akun.get(username).equals(password)) {
                    if (username.equals("admin")) adminMenu();  // Menu admin
                    else customerMenu(pelanggan.get(username));  // Menu customer
                } else {
                    System.out.println("Login gagal!");
                }
            } else if (pilihan.equals("0")) {
                break;
            }
        }
    }

    // Menu admin, dengan opsi untuk melihat saham dan SBN
    static void adminMenu() {
        while (true) {
            System.out.println("\n== MENU ADMIN ==\n1. Saham\n2. SBN\n3. Lihat Daftar Investasi\n4. Logout");
            String pilihan = input.nextLine();
            if (pilihan.equals("1")) adminSaham();  // Tambah saham
            else if (pilihan.equals("2")) adminSBN();  // Tambah SBN
            else if (pilihan.equals("3")) tampilInvestasi();  // Lihat daftar investasi
            else break;  // Keluar dari menu admin
        }
    }

    // Menu untuk mengelola saham
    static void adminSaham() {
        while (true) {
            System.out.println("\n== MENU SAHAM ==\n1. Tambah Saham\n2. Ubah Harga Saham\n3. Hapus Saham\n4. Kembali");
            String pilihan = input.nextLine();
            if (pilihan.equals("1")) {
                System.out.print("Kode: "); String kode = input.nextLine();
                System.out.print("Nama Perusahaan: "); String nama = input.nextLine();
                System.out.print("Harga: "); double harga = Double.parseDouble(input.nextLine());
                listInvestasi.add(new Saham(kode, nama, harga));
            } else if (pilihan.equals("2")) {
                tampilInvestasi();
                System.out.print("Kode Saham: ");
                String kode = input.nextLine();
                for (Investasi i : listInvestasi) {
                    if (i instanceof Saham) {
                        Saham s = (Saham) i;
                        if (s.kode.equals(kode)) {
                            System.out.print("Harga baru: ");
                            s.harga = Double.parseDouble(input.nextLine());
                            break;
                        }
                    }
                }
            } else if (pilihan.equals("3")) {
                tampilInvestasi();
                System.out.print("Kode Saham yang akan dihapus: ");
                String kode = input.nextLine();
                listInvestasi.removeIf(i -> i instanceof Saham && ((Saham) i).kode.equals(kode));
            } else break;
        }
    }

    // Menu untuk mengelola SBN
    static void adminSBN() {
        while (true) {
            System.out.println("\n== MENU SBN ==\n1. Tambah SBN\n2. Hapus SBN\n3. Kembali");
            String pilihan = input.nextLine();
            if (pilihan.equals("1")) {
                System.out.print("Nama: "); String nama = input.nextLine();
                System.out.print("Bunga (%): "); double bunga = Double.parseDouble(input.nextLine());
                System.out.print("Jangka Waktu (bulan): "); int waktu = Integer.parseInt(input.nextLine());
                System.out.print("Tanggal Jatuh Tempo: "); String tjt = input.nextLine();
                System.out.print("Kuota Nasional: "); double kuota = Double.parseDouble(input.nextLine());
                listInvestasi.add(new SBN(nama, bunga, waktu, tjt, kuota));
            } else if (pilihan.equals("2")) {
                tampilInvestasi();
                System.out.print("Nama SBN yang akan dihapus: ");
                String nama = input.nextLine();
                listInvestasi.removeIf(i -> i instanceof SBN && ((SBN) i).nama.equals(nama));
            } else break;
        }
    }

    // Menampilkan daftar saham dan SBN yang tersedia
    static void tampilInvestasi() {
        System.out.println("\n== DAFTAR INVESTASI ==");
        for (Investasi i : listInvestasi) {
            i.tampilDetail();
        }
    }

    // Menu untuk customer, termasuk opsi untuk membeli saham dan SBN
    static void customerMenu(Customer user) {
        while (true) {
            System.out.println("\n== MENU CUSTOMER ==\n1. Beli Investasi\n2. Portofolio\n3. Logout");
            String pilihan = input.nextLine();
            switch (pilihan) {
                case "1" -> beliInvestasi(user);
                case "2" -> lihatPortofolio(user);
                case "3" -> { return; }
            }
        }
    }

    // Fitur untuk membeli saham dan SBN
    static void beliInvestasi(Customer user) {
        tampilInvestasi();
        System.out.print("Pilih Investasi: "); String nama = input.nextLine();
        System.out.print("Nominal Pembelian: "); double nominal = Double.parseDouble(input.nextLine());
        for (Investasi i : listInvestasi) {
            if (i instanceof Saham) {
                Saham s = (Saham) i;
                if (s.nama.equals(nama)) {
                    user.sahamDimiliki.put(nama, user.sahamDimiliki.getOrDefault(nama, 0) + 1);
                    user.nominalSaham.put(nama, user.nominalSaham.getOrDefault(nama, 0.0) + nominal);
                    break;
                }
            } else if (i instanceof SBN) {
                SBN sbn = (SBN) i;
                if (sbn.nama.equals(nama)) {
                    user.sbnDimiliki.put(nama, user.sbnDimiliki.getOrDefault(nama, 0.0) + nominal);
                    sbn.kuotaNasional -= nominal;
                    break;
                }
            }
        }
    }

    // Fitur untuk melihat portofolio customer
    static void lihatPortofolio(Customer user) {
        System.out.println("\n== PORTOFOLIO ==");
        for (String nama : user.sahamDimiliki.keySet()) {
            System.out.printf("Saham %s: %d lembar\n", nama, user.sahamDimiliki.get(nama));
        }
        for (String nama : user.sbnDimiliki.keySet()) {
            System.out.printf("SBN %s: Rp %.2f\n", nama, user.sbnDimiliki.get(nama));
        }
    }
}


123123123