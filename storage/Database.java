package storage;

import model.Customer;
import model.Portofolio;
import model.Saham;
import model.SuratBerhargaNegara;

import java.util.*;

public class Database {
    private static final List<Saham> sahamList = new ArrayList<>();
    private static final List<SuratBerhargaNegara> sbnList = new ArrayList<>();
    private static final Map<Customer, Portofolio> portofolioMap = new HashMap<>();

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
