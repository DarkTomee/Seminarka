package model;

/**
 *
 * @author Tomáš
 */
public class VypravaOkno{
    
    public static Potvora vyprava(Hrdina hrdina){
        PolozkaInventare predmet = new PolozkaInventare();
        String prostredi = null;
        int nahoda = VypravaService.nahoda(10);
        
        Potvora potvora = VypravaService.nahodnaPotvora(nahoda);
        
        app.SeminarkaAppOkno.taKonzole.append("\nRozhodl jsi se jít na výpravu " + VypravaService.nahodneProstredi(VypravaService.nahoda(10)) 
                + " a potkal jsi potvoru jménem " + potvora.getJmeno() +" !\n");

        rozhodnuti(potvora, hrdina);
        
        return potvora; //VYRESIT !!!
    }
    
    public static Potvora rozhodnuti(Potvora potvora, Hrdina hrdina){
        char volba = ' ';
        boolean potvoraJeMrtva = false;
        PolozkaInventare predmet = new PolozkaInventare();

            app.SeminarkaAppOkno.taKonzole.append("\nMáš na výber jestli se potvoře " + potvora.getJmeno() + 
                    " postavíš nebo jestli se rozhodneš utéct. \nCo uděláš?");
            
            app.SeminarkaAppOkno.btBoj.setVisible(true);
            app.SeminarkaAppOkno.btUtek.setVisible(true);
            
            app.SeminarkaAppOkno.tfVyhledavaciPole.setVisible(false);
            app.SeminarkaAppOkno.btHledejPolozku.setVisible(false);
            
            app.SeminarkaAppOkno.laCena.setVisible(false);
            app.SeminarkaAppOkno.laNazev.setVisible(false);
            app.SeminarkaAppOkno.tfCena.setVisible(false);
            app.SeminarkaAppOkno.tfNazev.setVisible(false);
            app.SeminarkaAppOkno.btVyrobit.setVisible(false);

        return potvora;
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
            app.SeminarkaAppOkno.taKonzole.append("\n\nPodařilo se Ti zabít potvoru! Vypadl z ní předmět: " + predmet.getNazev() + ".\nPředmět najdeš v inventáři.\n\n");
            return predmet;
        }
        else {
            hrdina.setZivoty((hrdina.getZivoty() - potvora.getUtok()));
            if(hrdina.getZivoty()<= 0){
                smrt(potvora, hrdina);
            }
            app.SeminarkaAppOkno.laZivoty.setText("Životy: " + hrdina.getZivoty());
            app.SeminarkaAppOkno.taKonzole.append("\n\nPotvora byla rychlejší a ubrala Ti " + potvora.getUtok() + " zivotu! (zbýtá Ti ještě " + hrdina.getZivoty()+ " životů.)\n"
                    + "Musíš to zkusit znovu.\n");
            rozhodnuti(potvora, hrdina);
            return null; 
        }
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
             app.SeminarkaAppOkno.taKonzole.append("\n\nPodařilo se Ti utéct\n\n");
             return true;
        }
        else {
            hrdina.setZivoty((hrdina.getZivoty() - potvora.getUtok()));
            if(hrdina.getZivoty()<= 0){
                smrt(potvora, hrdina);
            }
            app.SeminarkaAppOkno.laZivoty.setText("Životy: " + hrdina.getZivoty());
            app.SeminarkaAppOkno.taKonzole.append("\n\nPotvora byla rychlejší a ubrala Ti " + potvora.getUtok() + " zivotu! (zbýtá Ti ještě " + hrdina.getZivoty()+ " životů. "
                    + "Musíš to zkusit znovu \n");
            return false;
        }
    }
    private static void smrt(Potvora potvora, Hrdina hrdina)
    { 
        app.SeminarkaAppOkno.taKonzole.append("\n\n\nSkoro jsi umřel :( přizabila Tě potvora jménem " + potvora.getJmeno() + ".\nNaštěstí Tě místní léčitelé vyléčili :-)\n");
        hrdina.setZivoty(30);
        app.SeminarkaAppOkno.laZivoty.setText("Životy: " + hrdina.getZivoty());
    }
}
