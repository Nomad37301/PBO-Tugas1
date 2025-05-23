package service;

import java.util.List;
import java.util.Scanner;
import menu.MenuUtil;
import model.Customer;
import model.Portofolio;
import model.SBNOwned;
import model.SuratBerhargaNegara;
import storage.Database;

public class SBNService {
    public static void tambahSBN(Scanner scanner) {
        System.out.print("Nama SBN: ");
        String nama = scanner.nextLine();
        System.out.print("Bunga (%): ");
        double bunga = Double.parseDouble(scanner.nextLine());
        System.out.print("Jangka Waktu (bulan): ");
        int bulan = Integer.parseInt(scanner.nextLine());
        System.out.print("Tanggal Jatuh Tempo (YYYY-MM-DD): ");
        String tanggal = scanner.nextLine();
        System.out.print("Kuota Nasional (Rp): ");
        double kuota = Double.parseDouble(scanner.nextLine());

        SuratBerhargaNegara sbn = new SuratBerhargaNegara(nama, bunga, bulan,
                java.time.LocalDate.parse(tanggal), kuota);
        Database.getSbnList().add(sbn);

        System.out.println("✅ SBN berhasil ditambahkan.\n");
    }

    public static void beliSBN(Scanner scanner, Customer customer) {
        List<SuratBerhargaNegara> sbnList = Database.getSbnList();
        if (sbnList.isEmpty()) {
            System.out.println("Tidak ada produk SBN tersedia.");
            return;
        }

        for (int i = 0; i < sbnList.size(); i++) {
            System.out.println((i + 1) + ". " + sbnList.get(i));
        }

        int index = MenuUtil.getIntegerInput(scanner, "Pilih indeks SBN: ", 1, sbnList.size());

        if (index < 1 || index > sbnList.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        SuratBerhargaNegara sbn = sbnList.get(index - 1);
        System.out.print("Nominal pembelian (Rp): ");
        double nominal = Double.parseDouble(scanner.nextLine());

        if (nominal > sbn.getKuotaNasional()) {
            System.out.println("Kuota tidak mencukupi.");
            return;
        }

        sbn.kurangiKuota(nominal);

        Portofolio p = Database.getPortofolio(customer);
        SBNOwned owned = new SBNOwned(sbn, nominal);
        p.tambahSBN(owned);

        System.out.println("✅ Pembelian SBN berhasil.\n");
    }

    public static void simulasiKupon(Scanner scanner, Customer customer) {
        Portofolio p = Database.getPortofolio(customer);
        List<SBNOwned> list = p.getSbnList();

        if (list.isEmpty()) {
            System.out.println("Tidak ada SBN dimiliki.");
            return;
        }

        System.out.println("Simulasi Kupon SBN per bulan:");
        for (SBNOwned sbn : list) {
            System.out.printf("%s - Kupon: Rp%.2f\n", sbn.getSbn().getNama(), sbn.hitungKuponBulanan());
        }
    }

    public static void hapusSBN(Scanner scanner) {
        List<SuratBerhargaNegara> list = Database.getSbnList();
        if (list.isEmpty()) {
            System.out.println("Belum ada produk SBN yang tersedia.");
            return;
        }

        System.out.println("=== Daftar SBN ===");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, list.get(i));
        }

        int index = MenuUtil.getIntegerInput(scanner, "Pilih indeks SBN untuk dihapus: ", 1, list.size());
        SuratBerhargaNegara removed = list.remove(index - 1);
        System.out.println("✅ SBN " + removed.getNama() + " berhasil dihapus.\n");
    }
}

