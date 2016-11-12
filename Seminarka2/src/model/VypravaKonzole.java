package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import model.VypravaService;
import utils.Vstupy;

/**
 *
 * @author Tomáš
 */
public class VypravaKonzole{
    
    public static PolozkaInventare vyprava(Hrdina hrdina){
        PolozkaInventare predmet = new PolozkaInventare();
        String prostredi = null;
        int nahoda = VypravaService.nahoda(10);
        
        Potvora potvora = VypravaService.nahodnaPotvora(nahoda);
        
        System.out.println("Rozhodl jsi se jít na výpravu " + VypravaService.nahodneProstredi(VypravaService.nahoda(10)) + " a potkal jsi potvoru jménem " + potvora.getJmeno() +" !");
        predmet = rozhodnuti(potvora, hrdina);
        
        return predmet;
    }
    
    public static PolozkaInventare rozhodnuti(Potvora potvora, Hrdina hrdina){
        char volba = ' ';
        boolean potvoraJeMrtva = false;
        PolozkaInventare predmet = new PolozkaInventare();
        
        do {
            System.out.println("Máš na výber jestli se potvoře " + potvora.getJmeno() + " postavíš[A] nebo jestli se rozhodneš utéct[N]. ");
            volba = Character.toUpperCase(Vstupy.ctiChar("Co uděláš? "));

            switch(volba) {
            case 'A': 
                    System.out.println("\nRozhodl jsi se bojovat.");
                    predmet = boj(potvora, hrdina);
                    if (predmet != null){
                        potvoraJeMrtva = true;}
                    break;
            case 'N':
                    System.out.println("\nRozhodl jsi se utect.");
                    potvoraJeMrtva = utek(potvora, hrdina);
                    break;

            default:
                System.out.println("Špatná volba");
                break;
            }
        } while (potvoraJeMrtva != true);
        return predmet;
    }
    
    public static PolozkaInventare boj(Potvora potvora, Hrdina hrdina){
        int nahodaHrdina = VypravaService.nahoda(10);
        int nahodaPotvora = VypravaService.nahoda(10);
        PolozkaInventare predmet = new PolozkaInventare();
        
        //když šance na výhru bude stejná, tak se šance znovu přehodnotí, dokud se nebudou šance lišit - fér pro potvoru i pro hrdinu
        if (nahodaHrdina == nahodaPotvora){
            do{
                nahodaHrdina = VypravaService.nahoda(10);
                nahodaPotvora = VypravaService.nahoda(10);
                } 
            while (nahodaHrdina != nahodaPotvora);        
        }
        
        if(nahodaHrdina > nahodaPotvora){
            predmet = VypravaService.nahodnaPolozkaInventare();
            System.out.println("Podařilo se Ti zabít potvoru! \nVypadl z ní předmět: " + predmet.getNazev() + ". Předmět najdeš v inventáři.\n");
            //inventarService.pridejPolozku(predmet.getNazev(), predmet.getCena());
        }
        else {
            hrdina.setZivoty((hrdina.getZivoty() - potvora.getUtok()));
            System.out.println("Potvora byla rychlejší a ubrala Ti " + potvora.getUtok() + " zivotu! (zbýtá Ti ještě " + hrdina.getZivoty()+ " životů. "
                    + "Musíš to zkusit znovu \n");
            return null; 
        }
        return predmet;
    }
    
    public static boolean utek(Potvora potvora, Hrdina hrdina){
        int nahodaHrdina = VypravaService.nahoda(10);
        int nahodaPotvora = VypravaService.nahoda(10);
        
        //když šance na výhru bude stejná, tak se šance znovu přehodnotí, dokud se nebudou šance lišit - fér pro potvoru i pro hrdinu
        if (nahodaHrdina == nahodaPotvora){
            do{
                nahodaHrdina = VypravaService.nahoda(10);
                nahodaPotvora = VypravaService.nahoda(10);
                } 
            while (nahodaHrdina != nahodaPotvora);        
        }
        
        if(nahodaHrdina > nahodaPotvora){
             System.out.println("Podařilo se Ti utéct");
             return true;
        }
        else {
            hrdina.setZivoty((hrdina.getZivoty() - potvora.getUtok()));
            System.out.println("Potvora byla rychlejší a ubrala Ti " + potvora.getUtok() + " zivotu! (zbýtá Ti ještě " + hrdina.getZivoty()+ " životů. "
                    + "Musíš to zkusit znovu \n");
            return false;
        }
    }

}
