
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Tomáš
 */
public class VypravaService {
    
    public static int nahoda(int pocetMoznosti){
        
        Random random = new Random();
        int nahoda = random.nextInt(pocetMoznosti);
        return nahoda;
    }
    
    public static String nahodneProstredi(int nahoda){//vždy náhodné prostředí
        String prostredi = "";
        String[] poleStringu = {"do pouště", "do lesa","do odlehlého města", "na vzdálený ostrov","na hřbitov",
            "do pustiny","do odlehlé ulice", "na vrakoviště","do jeskyně", "na vrchol hory"};

        List<String> list = new ArrayList<>(Arrays.asList(poleStringu));
        prostredi = list.get(nahoda);

    return prostredi;
    }
    
    public static Potvora nahodnaPotvora(int nahoda){
        //toto načítání může být realizováno i z externího souboru
        String potvora = "";
        String[][] poleStringu = new String[][] {
        {"vlkodlak", "3"},//název potvory, útok
        {"úpír", "4"},
        {"smrtonoš", "3"},
        {"drak", "5"},
        {"zombie", "2"},
        {"nekromant", "4"},
        {"fanatik", "2"},
        {"nájemný vrah", "4"},
        {"golem", "3"},
        {"temný stín", "1"} };
        return new Potvora(poleStringu[nahoda][0],Integer.parseInt(poleStringu[nahoda][1]));
    }
    
    public static PolozkaInventare nahodnaPolozkaInventare(){
        //toto načítání může být realizováno i z externího souboru
        int nahoda = nahoda(20);
        String[][] poleStringu = new String[][] {
            {"helma", "2"},// název předmětu, cena
            {"brnění", "5"},
            {"meč", "10"},
            {"boty", "2"},
            {"kalhoty", "3"},
            {"batoh", "4"},
            {"měšec zlata", "20"},
            {"hrábě", "1"},
            {"kus plechu", "1"},
            {"lebka", "3"},
            {"kápě", "6"},
            {"čutora", "2"},
            {"luk a toulec šípů", "8"},
            {"štít", "5"},
            {"palcát", "4"},
            {"kladivo", "6"},
            {"pochodeň", "2"},
            {"válečný roh", "3"},
            {"kost", "1"},
            {"diamant", "20"} }; 
        return new PolozkaInventare(poleStringu[nahoda][0], Double.parseDouble(poleStringu[nahoda][1]));
    }
    
}
