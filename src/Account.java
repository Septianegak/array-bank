public class Account {
    private double saldoRekening;

    public Account(double saldoAwal) {
        this.saldoRekening = saldoAwal;
    }

    public double getSaldoRekening() {
        return saldoRekening;
    }

    public boolean setorTunai(double nominal) {
        if (nominal > 0) {
            saldoRekening += nominal;
            return true;
        }
        return false;
    }

    public boolean tarikTunai(double nominal) {
        if (saldoRekening >= nominal && nominal > 0) {
            saldoRekening -= nominal;
            return true;
        }
        return false;
    }
}