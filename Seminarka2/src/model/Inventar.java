package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomáš
 */

class Inventar implements Serializable{
    
   private List<PolozkaInventare> polozky; //zápis kolekce
   
   public Inventar() {
       polozky = new ArrayList<>();
   }
   
    public int pocetPredmetu(){
        int pocet = polozky.size();
        return pocet;
    }

    public List<PolozkaInventare> getPolozky() {
        return polozky;
    }
    public PolozkaInventare vyberPolozku(int index) {
        PolozkaInventare predmet = polozky.get(index);
        return predmet;
    }
    public void odeberPolozku(int index){
        polozky.remove(index);
    }
    
    public void setPolozky(List<PolozkaInventare> polozky) {
        this.polozky = polozky;
    }
    
}
