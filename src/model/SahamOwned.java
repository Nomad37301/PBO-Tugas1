package model;

public class SahamOwned {
    private Saham saham;
    private int jumlah;
    private double hargaBeli;

    public SahamOwned(Saham saham, int jumlah, double hargaBeli) {
        this.saham = saham;
        this.jumlah = jumlah;
        this.hargaBeli = hargaBeli;
    }

    public Saham getSaham() {
        return saham;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    public void tambahJumlah(int tambahan) {
        this.jumlah += tambahan;
    }

    public void kurangiJumlah(int pengurangan) {
        this.jumlah -= pengurangan;
    }
}
