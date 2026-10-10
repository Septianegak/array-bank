import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bankPusat = new Bank();
        Scanner inputUser = new Scanner(System.in);

        // Inisialisasi data awal
        bankPusat.tambahNasabah("Neymar", "Jr");
        bankPusat.getNasabah(0).tambahRekening(new Account(50000.0));
        bankPusat.getNasabah(0).tambahRekening(new Account(30000.0));

        bankPusat.tambahNasabah("Lionel", "Messi");
        bankPusat.getNasabah(1).tambahRekening(new Account(100000.0));

        boolean statusProgram = true;

        while (statusProgram) {
            System.out.println("\n==============================================");
            System.out.println("                  BANK JAGO        ");
            System.out.println("==============================================");
            System.out.println("1. Tampilkan Seluruh Nasabah & Saldo");
            System.out.println("2. Registrasi Nasabah Baru");
            System.out.println("3. Pembukaan Rekening Baru");
            System.out.println("4. Menu Transaksi (Setor / Tarik)");
            System.out.println("5. Keluar Aplikasi");
            System.out.println("==============================================");
            System.out.print("Silakan pilih menu (1-5): ");

            int pilihanMenu = inputUser.nextInt();
            inputUser.nextLine(); 

            switch (pilihanMenu) {
                case 1:
                    System.out.println("\n--- DAFTAR NASABAH & REKENING ---");
                    int totalN = bankPusat.getJumlahNasabah();
                    if (totalN == 0) {
                        System.out.println("Belum ada data nasabah.");
                    } else {
                        for (int i = 0; i < totalN; i++) {
                            Customer n = bankPusat.getNasabah(i);
                            System.out.println((i + 1) + ". " + n.getNamaDepan() + " " + n.getNamaBelakang());
                            System.out.println("   Jumlah Akun: " + n.getTotalRekening());
                            for (int j = 0; j < n.getTotalRekening(); j++) {
                                System.out.println("   -> Rekening " + (j + 1) + " | Saldo: Rp " + n.getRekening(j).getSaldoRekening());
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- REGISTRASI NASABAH BARU ---");
                    System.out.print("Masukkan Nama Depan  : ");
                    String fName = inputUser.nextLine();
                    System.out.print("Masukkan Nama Belakang: ");
                    String lName = inputUser.nextLine();

                    bankPusat.tambahNasabah(fName, lName);
                    System.out.println("Berhasil mendaftarkan nasabah: " + fName + " " + lName);
                    break;

                case 3:
                    System.out.println("\n--- BUKA REKENING BARU ---");
                    if (bankPusat.getJumlahNasabah() == 0) {
                        System.out.println("Mohon daftarkan nasabah terlebih dahulu.");
                        break;
                    }
            
                    System.out.print("Pilih Nomor Nasabah (1 - " + bankPusat.getJumlahNasabah() + "): ");
                    int idxN = inputUser.nextInt() - 1;
                    Customer targetNasabah = bankPusat.getNasabah(idxN);

                    if (targetNasabah != null) {
                        System.out.print("Masukkan Setoran Awal (Rp): ");
                        double saldoAwal = inputUser.nextDouble();
                        targetNasabah.tambahRekening(new Account(saldoAwal));
                        System.out.println("Rekening baru berhasil dibuka untuk " + targetNasabah.getNamaDepan() + "!");
                    } else {
                        System.out.println("Nomor nasabah tidak valid.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- MENU TRANSAKSI ---");
                    if (bankPusat.getJumlahNasabah() == 0) {
                        System.out.println("Data nasabah kosong.");
                        break;
                    }
                    System.out.print("Pilih Nomor Nasabah (1 - " + bankPusat.getJumlahNasabah() + "): ");
                    int nIndex = inputUser.nextInt() - 1;
                    Customer cAktif = bankPusat.getNasabah(nIndex);

                    if (cAktif == null || cAktif.getTotalRekening() == 0) {
                        System.out.println("Nasabah tidak ditemukan atau belum memiliki rekening.");
                        break;
                    }

                    System.out.print("Pilih Nomor Rekening (1 - " + cAktif.getTotalRekening() + "): ");
                    int rIndex = inputUser.nextInt() - 1;
                    Account akunAktif = cAktif.getRekening(rIndex);

                    if (akunAktif != null) {
                        System.out.println("\nSaldo Terkini: Rp " + akunAktif.getSaldoRekening());
                        System.out.println("1. Setor Saldo");
                        System.out.println("2. Tarik Saldo");
                        System.out.print("Pilih jenis transaksi (1/2): ");
                        int jenis = inputUser.nextInt();

                        if (jenis == 1) {
                            System.out.print("Nominal setoran: Rp ");
                            double nominalSetor = inputUser.nextDouble();
                            if (akunAktif.setorTunai(nominalSetor)) {
                                System.out.println("Setoran sukses! Saldo sekarang: Rp " + akunAktif.getSaldoRekening());
                            } else {
                                System.out.println("Nominal tidak boleh kurang dari atau sama dengan 0.");
                            }
                        } else if (jenis == 2) {
                            System.out.print("Nominal penarikan: Rp ");
                            double nominalTarik = inputUser.nextDouble();
                            if (akunAktif.tarikTunai(nominalTarik)) {
                                System.out.println("Penarikan sukses! Sisa saldo: Rp " + akunAktif.getSaldoRekening());
                            } else {
                                System.out.println("Gagal: Saldo tidak mencukupi atau nominal salah.");
                            }
                        } else {
                            System.out.println("Pilihan transaksi tidak valid.");
                        }
                    } else {
                        System.out.println("Nomor rekening tidak valid.");
                    }
                    break;

                case 5:
                    statusProgram = false;
                    System.out.println("\nTerima kasih telah menggunakan BANK JAGO");
                    break;

                default:
                    System.out.println("\nPilihan menu salah! Masukkan angka 1 sampai 5.");
                    break;
            }
        }
        inputUser.close();
    }
}