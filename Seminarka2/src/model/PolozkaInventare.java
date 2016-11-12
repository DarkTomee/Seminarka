package model;

import java.io.Serializable;

/**
 *
 * @author Tomáš
 */
public class PolozkaInventare implements Serializable{
    private String nazev;
    private double cena;
    
    public PolozkaInventare(){
        nazev = null;
        cena = 0;
    }
    
    public PolozkaInventare(String nazev, double cena) {
        this.nazev = nazev;
        this.cena = cena;
    }
    
    public String toString(){
        return (getNazev().substring(0, 1).toUpperCase() + getNazev().substring(1)) + " v hodnotě " + getCena() + " zlatých";
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    String toStringIndexed(Inventar inventar, PolozkaInventare p) {
        return (inventar.getPolozky().indexOf(p) + ".  " + getNazev().substring(0, 1).toUpperCase() + getNazev().substring(1)) + " v hodnotě " + getCena() + " zlatých";
    }
}
