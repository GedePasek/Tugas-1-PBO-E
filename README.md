  # 💼 InvestasiApp - Simulasi Investasi Saham & SBN

InvestasiApp adalah aplikasi berbasis Java console yang memungkinkan pengguna melakukan simulasi investasi dalam bentuk **Saham** dan **Surat Berharga Negara (SBN)**. Aplikasi ini menyediakan dua peran utama: **Admin** dan **Customer**, dengan fitur pengelolaan dan pembelian investasi.

---

## 🧩 Fitur Utama

### 👨‍💼 Admin
- Tambah, ubah harga, dan hapus **Saham**
- Tambah dan hapus **SBN**
- Lihat seluruh daftar investasi yang tersedia

### 👤 Customer
- Melihat daftar investasi
- Membeli saham berdasarkan harga dan nominal
- Membeli SBN selama masih tersedia kuota nasional
- Melihat portofolio investasi pribadi

---

## 🏁 Cara Menjalankan

1. Pastikan Anda telah menginstal **Java JDK 17 atau lebih baru**
2. Clone repositori ini:

```bash
git clone https://github.com/username/InvestasiApp.git
cd InvestasiApp
```

---

## 📖Cara Penggunaan Aplikasi
InvestasiApp dapat dijalankan di **IDE INTELLIJ** dan pastikan kalian menginstal **JDK 11** Atau yang lebih baru.

### ℹ️Informasi Login 

| Role   | Username | Password   |
|--------|----------|------------|
| Admin  | admin    | admin123   |
| User   | user     | user123    |

Kode kami terdapat 2 role yang tersedia, yaitu **Admin** dan **User**. 

---


<img src="gambar/tampilanAwal.jpg" width="500">
 
Gambar diatas merupakan **tampilan awal** saat kode program dijalankan. terdapat 2 opsi yaitu, **Login** dan **Keluar**.


<img src="gambar/tampilanKeluar.jpg" width="500">

Gambar di atas merupakan tampilan kelar ketika pengguna memilih opsi keluar(0).

---

<img src="gambar/loginAdminGagal.jpg" width="500">

Gambar di atas merupakan tampialn login sebagai admin. Jika menginput username atau password yang salah maka akan ada pesan seperti gambar di atas dan akan otomatis kembali ke menu login. Jika password dan username sudah benar, maka program akan berjalan ke tampilan selanjutnya.

<img src="gambar/tampilanAdminLogin.jpg" width="500">

Gambar di atas merupakan contoh jika password dan username benar. Program akan menampilkan **Menu Admin** yang berisi opsi **Saham**, **SBN**, **Lihat Daftar Investasi**, dan **Logout**. 

<img src="gambar/tambahSaham.jpg" width="500">

Gambar di atas merupakan tampilan ketika kita memilih opsi **Saham** pada **Menu Admin**. Disana terdapat **Tambah Saham**, **Ubah Harga Saham**, **Hapus Saham**, dan **Kembali**. Ketika pengguna menginput angka 1, maka program akan lanjut ke opsi **Tambah Saham** untuk menambah saham seperti pada gambar di atas. 
