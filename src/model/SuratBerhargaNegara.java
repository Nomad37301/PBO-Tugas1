package model;

import java.time.LocalDate;

public class SuratBerhargaNegara {
    private String nama;
    private double bunga;
    private int jangkaWaktu; // dalam bulan
    private LocalDate tanggalJatuhTempo;
    private double kuotaNasional;

    public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, LocalDate tanggalJatuhTempo, double kuotaNasional) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }

    public String getNama() {
        return nama;
    }

    public double getBunga() {
        return bunga;
    }

    public int getJangkaWaktu() {
        return jangkaWaktu;
    }

    public LocalDate getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public double getKuotaNasional() {
        return kuotaNasional;
    }

    public void kurangiKuota(double nominal) {
        this.kuotaNasional -= nominal;
    }

    @Override
    public String toString() {
        return String.format("%s | Bunga: %.2f%% | Jatuh Tempo: %s | Kuota: Rp%.2f",
                nama, bunga, tanggalJatuhTempo.toString(), kuotaNasional);
    }
}
