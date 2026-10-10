public class Bank {
    private Customer[] daftarNasabah;
    private int jumlahNasabah;

    public Bank() {
        this.daftarNasabah = new Customer[10]; 
        this.jumlahNasabah = 0;
    }

    public void tambahNasabah(String depan, String belakang) {
        if (jumlahNasabah < daftarNasabah.length) {
            daftarNasabah[jumlahNasabah++] = new Customer(depan, belakang);
        } else {
            System.out.println("Kapasitas bank sudah penuh!");
        }
    }

    public int getJumlahNasabah() {
        return jumlahNasabah;
    }

    public Customer getNasabah(int indeks) {
        if (indeks >= 0 && indeks < jumlahNasabah) {
            return daftarNasabah[indeks];
        }
        return null;
    }
}