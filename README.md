# Latihan/Eksplorasi Materi Array dan Array of Objects (Sistem Bank Jago)

Repositori ini berisi implementasi program Java yang mengeksplorasi penggunaan **Array** dan **Array of Objects** dalam studi kasus Sistem Manajemen Perbankan & Layanan Transaksi Digital.

## 📌 Penjelasan Konsep Penggunaan Array & Array of Objects

1. **Array 1-Dimensi & Array of Objects:**
   * **`daftarNasabah`** (`Customer[]`) pada kelas `Bank` digunakan untuk menyimpan sekumpulan objek dari kelas `Customer`.
   * **`listRekening`** (`Account[]`) pada kelas `Customer` digunakan untuk menyimpan sekumpulan objek `Account` (rekening) yang dimiliki oleh seorang nasabah.

2. **Manajemen Indeks & Kapasitas Elemen:**
   * Alokasi ukuran tetap pada array (misalnya `Account[5]` untuk maksimal 5 rekening per nasabah dan `Customer[10]` untuk batas maksimal nasabah).
   * Pelacakan indeks/elemen aktif menggunakan variabel counter seperti `jumlahNasabah` dan `totalRekening`.

3. **Encapsulation & Keamanan Saldo:**
   * Atribut `saldoRekening` dienkapsulasi dengan modifier `private` dan diakses/diubah melalui metode setter-getter serta operasi `setorTunai()` dan `tarikTunai()`.

4. **Interaksi Konsol Interaktif (Scanner):**
   * Kelas `Main` menyediakan antarmuka berbasis teks dengan menu interaktif untuk melakukan penambahan nasabah, pendaftaran rekening, cek saldo, serta transaksi setor/tarik tunai.

---

## 🗂️ Struktur File Kode

* `Account.java` - Memodelkan objek rekening perbankan (menyimpan saldo, metode setor & tarik tunai).
* `Customer.java` - Memodelkan data nasabah dan mengelola array dari objek `Account`.
* `Bank.java` - Mengelola sekumpulan data nasabah melalui array dari objek `Customer`.
* `Main.java` - Titik masuk (*entry point*) program yang menyediakan menu transaksi interaktif berbasis konsol.

---

## 🛠️ Informasi Library Tambahan

Program ini dibangun menggunakan **Java Standard Library (JDK)** murni.
* **`java.util.Scanner`**: Digunakan untuk membaca input teks dan angka dari pengguna melalui terminal/konsol.
* *Tidak memerlukan library pihak ketiga (external library).*

## 📸 Screenshot Output Program

Berikut adalah tampilan dari program saat dijalankan:

![Screenshot Output Program](output/Menu1.png.png)
![Screenshot Output Program](output/Menu2.png.png)
![Screenshot Output Program](output/Menu3.png.png)
![Screenshot Output Program](output/Menu4.png.png)
![Screenshot Output Program](output/Menu5.png.png)