package model;

/**
 *
 * @author Tomáš
 */
public interface DataManager  {
    public void uloz(String jmenoSouboru, Inventar inventar) throws Exception;
    
    public Inventar nacti(String jmenoSouboru) throws Exception;
    //Sklad = návratová hodnota
}
