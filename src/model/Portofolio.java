package model;

import java.util.ArrayList;
import java.util.List;

public class Portofolio {
    private List<SahamOwned> sahamList;
    private List<SBNOwned> sbnList;

    public Portofolio() {
        this.sahamList = new ArrayList<>();
        this.sbnList = new ArrayList<>();
    }

    public List<SahamOwned> getSahamList() {
        return sahamList;
    }

    public List<SBNOwned> getSbnList() {
        return sbnList;
    }

    public void tambahSaham(SahamOwned sahamOwned) {
        this.sahamList.add(sahamOwned);
    }

    public void tambahSBN(SBNOwned sbnOwned) {
        this.sbnList.add(sbnOwned);
    }
}
