package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Tomáš
 */
public class InventarService {
    private final static String SOUBOR = "inventar.obj";
    public Inventar inventar;
    private DataManager dm = null;
    
    public InventarService(){
        inventar = new Inventar();
    }
    
    public InventarService(DataManager dm) {
        inventar = new Inventar();
        this.dm = dm;
    }
    
    public void setDataManager(DataManager dm) {
        this.dm = dm;
    }
    
    public String getPolozkyJakoString(boolean okno) {
        String polozkyString = "";
        if (!inventar.getPolozky().isEmpty()){
        for (PolozkaInventare p : inventar.getPolozky()) {
            polozkyString = polozkyString + p.toString() + "\n";
        }
        return polozkyString;
        }
        else {
            if (okno = true){
                polozkyString = "\nInventář je prázdný :( \nMůžeš si předmět vyrobit nebo jdi na výpravu.\n";
            }
            else {
                    System.out.println("Inventář je prázdný :( \nZkus jít na tržiště nebo na výpravu.");
                 }
            return polozkyString;}
    }
    
    public String getPolozkyJakoStringIndexed(boolean okno) {
        String polozkyString = "";
        if (!inventar.getPolozky().isEmpty()){
        for (PolozkaInventare p : inventar.getPolozky()) {
            polozkyString = polozkyString + p.toStringIndexed(inventar, p) + "\n";
        }
        return polozkyString;
        }
        else {
            if (okno = true){
                polozkyString = "\nInventář je prázdný :( \nMůžeš si předmět vyrobit nebo jdi na výpravu.\n";
            }
            else {
                    System.out.println("Inventář je prázdný :( \nZkus jít na tržiště nebo na výpravu.");
                 }
            return polozkyString;}
    }
    
    public void pridejPolozku(PolozkaInventare p) {
        if (p == null) {
            throw new IllegalArgumentException("Polozka je null!");
        }
        inventar.getPolozky().add(p);
    }
    
    public void pridejPolozku(String nazev, double cena) {
        if (nazev.isEmpty() || cena == 0) {
            throw new IllegalArgumentException("Chybne vyplnena Polozka!");
        }

        PolozkaInventare p = new PolozkaInventare(nazev, cena);
        inventar.getPolozky().add(p);
    }
    public List<PolozkaInventare> hledej(String s) {
        List<PolozkaInventare> nalezene = new ArrayList<>();
        String nazev;

        s = s.toUpperCase();

        for (PolozkaInventare pol : inventar.getPolozky()) {
            nazev = pol.getNazev().toUpperCase();
            if (nazev.indexOf(s) != -1) {
                nalezene.add(pol);
            }
        }

        return (nalezene.size() != 0) ? nalezene : null;
    }
    public void serad(int typRazeni) {
        Collections.sort(inventar.getPolozky(), new KomparatorPolozek(typRazeni));
    }

    public void uloz() throws Exception {
        if (dm == null) {
            throw new IllegalArgumentException("Nenastaven datovy manazer!");
        }
        dm.uloz(SOUBOR, inventar);
    }

    public void nacti() throws Exception {
        if (dm == null) {
            throw new IllegalArgumentException("Nenastaven datovy manazer!");
        }
        inventar = dm.nacti(SOUBOR);
    }
    
    public int pocetPredmetu(){
        int pocet = inventar.pocetPredmetu();
        return pocet;
    }
    public void odeberPolozku(int index){
        inventar.odeberPolozku(index);
    }
    
    public PolozkaInventare vyberPolozku(int index){
        PolozkaInventare predmet = inventar.vyberPolozku(index);
        return predmet;
    }    
}
