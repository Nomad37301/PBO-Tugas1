package storage;

import model.Customer;
import model.Portofolio;
import model.Saham;
import model.SuratBerhargaNegara;

import java.time.LocalDate;
import java.util.*;

public class Database {
    private static final List<Saham> sahamList = new ArrayList<>();
    private static final List<SuratBerhargaNegara> sbnList = new ArrayList<>();
    private static final Map<Customer, Portofolio> portofolioMap = new HashMap<>();

    static {
        // Dummy Data Saham
        sahamList.add(new Saham("BBRI", "Bank BRI", 5000));
        sahamList.add(new Saham("TLKM", "Telkom Indonesia", 4500));
        sahamList.add(new Saham("ASII", "Astra International", 7000));

        // Dummy Data SBN
        sbnList.add(new SuratBerhargaNegara("SBR010", 6.0, 24, LocalDate.of(2027, 4, 1), 500_000_000));
        sbnList.add(new SuratBerhargaNegara("ORI021", 5.5, 36, LocalDate.of(2028, 10, 1), 300_000_000));
        sbnList.add(new SuratBerhargaNegara("SR017", 5.8, 36, LocalDate.of(2028, 3, 1), 400_000_000));
    }

    public static List<Saham> getSahamList() {
        return sahamList;
    }

    public static List<SuratBerhargaNegara> getSbnList() {
        return sbnList;
    }

    public static Map<Customer, Portofolio> getPortofolioMap() {
        return portofolioMap;
    }

    public static Portofolio getPortofolio(Customer customer) {
        return portofolioMap.computeIfAbsent(customer, k -> new Portofolio());
    }
}
