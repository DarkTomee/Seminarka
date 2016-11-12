package model;

import java.util.Comparator;

public class KomparatorPolozek implements Comparator<PolozkaInventare> {
    /* Comparator = rozhraní, které umí obecně porovnat dvě položky aniž by mezi 
     * nimi byl nějaký příbuzný vztah (člověk x vlak - váha)
     */
    public static final int DLE_CENY = 0;
    public static final int DLE_NAZVU = 1;
    private int typ = 0;

    public KomparatorPolozek() {
    }

    public KomparatorPolozek(int typ) {
        this.typ = typ;
    }

    @Override
    public int compare(PolozkaInventare o1, PolozkaInventare o2) {
        //Metoda compare je implementovaná z metody java.util.Comparator
        switch (typ) {
            case DLE_CENY:
                return (int) (o1.getCena() - o2.getCena());
                //odečte čísla - když výsledek = 0 jsou stejný
            case DLE_NAZVU:
                return o1.getNazev().compareToIgnoreCase(o2.getNazev());
                //porovnává jestli se shodují názvy, compareToIgnoreCase = porovnává CaseUnsensitive
        }
        return 0;
    }
}
