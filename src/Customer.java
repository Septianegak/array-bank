public class Customer {
    private String namaDepan;
    private String namaBelakang;
    private Account[] listRekening;
    private int totalRekening;

    public Customer(String depan, String belakang) {
        this.namaDepan = depan;
        this.namaBelakang = belakang;
        this.listRekening = new Account[5]; 
        this.totalRekening = 0;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void tambahRekening(Account akunBaru) {
        if (totalRekening < 5) {
            listRekening[totalRekening++] = akunBaru;
        } else {
            System.out.println("Batas maksimum kepemilikan 5 rekening telah tercapai.");
        }
    }

    public Account getRekening(int indeks) {
        if (indeks >= 0 && indeks < totalRekening) {
            return listRekening[indeks];
        }
        return null;
    }

    public int getTotalRekening() {
        return totalRekening;
    }
}