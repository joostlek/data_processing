package P2;

import java.util.List;

public class Product {
    private int productNummer;
    private String productNaam;
    private String beschrijving;
    private double price;
    private List<Integer> kaartnummers;

    public Product() {
    }

    public Product(int productNummer, String productNaam, String beschrijving, double price, List<Integer> kaartnummers) {
        this.productNummer = productNummer;
        this.productNaam = productNaam;
        this.beschrijving = beschrijving;
        this.price = price;
        this.kaartnummers = kaartnummers;
    }

    public int getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Integer> getKaartnummers() {
        return kaartnummers;
    }

    public void setKaartnummers(List<Integer> kaartnummers) {
        this.kaartnummers = kaartnummers;
    }
}
