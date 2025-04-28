package service;

import model.Customer;
import model.Portofolio;
import model.SBNOwned;
import model.SahamOwned;
import storage.Database;

import java.util.List;

public class PortofolioService {
    public static void tampilkanPortofolio(Customer customer) {
        Portofolio portofolio = Database.getPortofolio(customer);
        List<SahamOwned> sahamList = portofolio.getSahamList();
        List<SBNOwned> sbnList = portofolio.getSbnList();

        System.out.println("=== PORTOFOLIO INVESTASI ===");

        System.out.println("📈 Saham Dimiliki:");
        double totalBeli = 0, totalPasar = 0;
        for (SahamOwned so : sahamList) {
            double nilaiPasar = so.getSaham().getHarga() * so.getJumlah();
            totalPasar += nilaiPasar;
            totalBeli += so.getHargaBeli() * so.getJumlah();

            System.out.printf("- %s | %d lembar | Beli: Rp%.2f | Pasar: Rp%.2f\n",
                    so.getSaham().getNamaPerusahaan(),
                    so.getJumlah(),
                    so.getHargaBeli() * so.getJumlah(),
                    nilaiPasar);
        }
        System.out.printf("Total Nilai Beli: Rp%.2f | Total Nilai Pasar: Rp%.2f\n", totalBeli, totalPasar);

        System.out.println("\n🏦 SBN Dimiliki:");
        for (SBNOwned sbn : sbnList) {
            System.out.printf("- %s | Investasi: Rp%.2f | Kupon per bulan: Rp%.2f\n",
                    sbn.getSbn().getNama(),
                    sbn.getTotalInvestasi(),
                    sbn.hitungKuponBulanan());
        }

        System.out.println();
    }
}
