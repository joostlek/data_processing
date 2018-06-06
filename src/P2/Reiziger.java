package P2;

import java.sql.Date;
import java.util.List;

public class Reiziger {
    private int reizigerId;
    private String naam;
    private Date gbdatum;
    private List<OVChipKaart> ovchipkaarten;

    public Reiziger() {
    }

    public Reiziger(int reizigerId, String naam, Date gbdatum) {
        this.reizigerId = reizigerId;
        this.naam = naam;
        this.gbdatum = gbdatum;
    }

    public int getReizigerId() {
        return reizigerId;
    }

    public void setReizigerId(int reizigerId) {
        this.reizigerId = reizigerId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGbdatum() {
        return gbdatum;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }

    public List<OVChipKaart> getOvchipkaarten() {
        return ovchipkaarten;
    }

    public void setOvchipkaarten(List<OVChipKaart> ovchipkaarten) {
        this.ovchipkaarten = ovchipkaarten;
    }
}
