package app;

import model.Hrdina;
import model.InventarService;
import model.ObjektovySoubor;
import utils.Vstupy;
import model.PolozkaInventare;
import model.VypravaKonzole;

/**
 *
 * @author Tomas
 * ¨
Oddělení datového modelu od prezentační logiky.
Použití alespoň jedné asociace 1:N (agregace) mezi třídami modelu (např. evidence nějakých záznamů).
Požadovaná funkčnost z pohledu uživatele: 
 - přidání, úprava, smazání a zobrazení záznamu,
 - vyhledávání a řazení dat, 
 - ukládání a načítání dat ze souboru.
 */

//Konzolová verze sloužila k vývoji verze "s oknem" a proto není kompletní
public class SeminarkaAppKonzole {
    private InventarService inventarService = null;
    
    public static void main(String[] args) {
        new SeminarkaAppKonzole().start();
    }
    
    public void start() {
        inventarService = new InventarService();
        inventarService.setDataManager(new ObjektovySoubor());
        model.Hrdina hrdina  = new model.Hrdina(30, 0);
        
        zobrazMenu(hrdina);
        
    }
    
    public void zobrazMenu(Hrdina hrdina){
        int volba = 0;
        boolean okno = false;
        PolozkaInventare predmet = new PolozkaInventare();
        
        
        do {
            
        System.out.println("--------- Vítej v menu hrdino --------");
        System.out.println(">>> Momentálně máš " + hrdina.getZivoty() + " životů");
        System.out.println(">>> Momentálně máš " + hrdina.getZlato()+ " zlatých");
        System.out.println("--------------------------------------");
        System.out.println("Stiskni 1 - Pro zobrazení inventaře");
        System.out.println("Stiskni 2 - Výprava na dobrudružnou výpravu");
        System.out.println("Stiskni 3 - Konec");
        volba = Vstupy.ctiInt("Vase volba: ");
        
        
            switch (volba) {

                case 1:
                    System.out.println("\n--------------- INVENÁŘ --------------");
                    System.out.println(inventarService.getPolozkyJakoString(okno));
                    break;
                case 2:
                    predmet = VypravaKonzole.vyprava(hrdina);
                    if (predmet != null){
                        inventarService.pridejPolozku(predmet.getNazev(), predmet.getCena());
                    }
                    break;
                /*case 5: //pak smazat
                    ulozData();
                    System.out.println(inventarService.getPolozkyJakoString(okno));
                    nactiData();
                    System.out.println(inventarService.getPolozkyJakoString(okno));
                    break;*/
                default:
                    break;
            }

        } while (volba != 3);
    }
    public void ulozData(){
        try {
            inventarService.uloz();
            System.out.println("Data uložena");
            } catch (Exception e) {
            System.out.println("Chyba pri ukládání dat: " + e.getMessage());
        }
    }
    public void nactiData(){
        try {
            inventarService.nacti();
            System.out.println("Data načtena");
            } catch (Exception e) {
            System.out.println("Chyba při načítání dat: " + e.getMessage());
        }
    }
}
    

