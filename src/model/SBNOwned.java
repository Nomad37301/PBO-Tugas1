package model;

public class SBNOwned {
    private SuratBerhargaNegara sbn;
    private double totalInvestasi;

    public SBNOwned(SuratBerhargaNegara sbn, double totalInvestasi) {
        this.sbn = sbn;
        this.totalInvestasi = totalInvestasi;
    }

    public SuratBerhargaNegara getSbn() {
        return sbn;
    }

    public double getTotalInvestasi() {
        return totalInvestasi;
    }

    public void tambahInvestasi(double nominal) {
        this.totalInvestasi += nominal;
    }

    public double hitungKuponBulanan() {
        return (sbn.getBunga() / 100.0) / 12.0 * 0.9 * totalInvestasi;
    }
}
