package service;

import java.util.List;
import java.util.Scanner;
import menu.MenuUtil;
import model.Customer;
import model.Portofolio;
import model.Saham;
import model.SahamOwned;
import storage.Database;

public class SahamService {
    public static void tambahSaham(Scanner scanner) {
        System.out.print("Kode saham: ");
        String kode = scanner.nextLine();
        System.out.print("Nama perusahaan: ");
        String nama = scanner.nextLine();
        System.out.print("Harga awal: ");
        double harga = Double.parseDouble(scanner.nextLine());

        Database.getSahamList().add(new Saham(kode, nama, harga));
        System.out.println("✅ Saham berhasil ditambahkan.\n");
    }

    public static void ubahHargaSaham(Scanner scanner) {
        List<Saham> sahamList = Database.getSahamList();
        if (sahamList.isEmpty()) {
            System.out.println("Tidak ada saham tersedia.");
            return;
        }

        tampilkanSaham(sahamList);
        int index = MenuUtil.getIntegerInput(scanner, "Pilih indeks saham: ", 1, sahamList.size());

        if (index < 1 || index > sahamList.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        Saham saham = sahamList.get(index - 1);
        System.out.print("Harga baru: ");
        double hargaBaru = Double.parseDouble(scanner.nextLine());
        saham.setHarga(hargaBaru);
        System.out.println("✅ Harga berhasil diubah.\n");
    }

    public static void beliSaham(Scanner scanner, Customer customer) {
        List<Saham> sahamList = Database.getSahamList();
        if (sahamList.isEmpty()) {
            System.out.println("Belum ada saham tersedia.\n");
            return;
        }

        tampilkanSaham(sahamList);
        System.out.print("Pilih indeks saham: ");
        int index = MenuUtil.getIntegerInput(scanner, "Pilih indeks saham: ", 1, sahamList.size());

        if (index < 1 || index > sahamList.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        Saham saham = sahamList.get(index - 1);
        System.out.print("Jumlah lembar: ");
        int jumlah = Integer.parseInt(scanner.nextLine());

        Portofolio p = Database.getPortofolio(customer);
        SahamOwned owned = new SahamOwned(saham, jumlah, saham.getHarga());
        p.tambahSaham(owned);

        System.out.println("✅ Pembelian saham berhasil.\n");
    }

    public static void jualSaham(Scanner scanner, Customer customer) {
        Portofolio p = Database.getPortofolio(customer);
        List<SahamOwned> list = p.getSahamList();

        if (list.isEmpty()) {
            System.out.println("Tidak ada saham yang dimiliki.");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            SahamOwned so = list.get(i);
            System.out.printf("%d. %s - %d lembar (Harga Beli: Rp%.2f)\n",
                    i + 1, so.getSaham().getNamaPerusahaan(), so.getJumlah(), so.getHargaBeli());
        }

        int index = MenuUtil.getIntegerInput(scanner, "Pilih indeks saham: ", 1, list.size());

        if (index < 1 || index > list.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        SahamOwned selected = list.get(index - 1);
        System.out.print("Jumlah lembar dijual: ");
        int jual = Integer.parseInt(scanner.nextLine());

        if (jual > selected.getJumlah()) {
            System.out.println("Jumlah lembar melebihi kepemilikan.");
        } else {
            selected.kurangiJumlah(jual);
            if (selected.getJumlah() == 0) {
                list.remove(selected);
            }
            System.out.println("✅ Penjualan berhasil.\n");
        }
    }

    private static void tampilkanSaham(List<Saham> sahamList) {
        System.out.println("Daftar Saham:");
        for (int i = 0; i < sahamList.size(); i++) {
            System.out.println((i + 1) + ". " + sahamList.get(i));
        }
    }
}
