package model;

/**
 *
 * @author Tomáš
 */
public class Potvora {
    private String jmeno;
    private int utok;
    
    public Potvora(String jmeno, int utok){
        this.jmeno = jmeno;
        this.utok = utok;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getUtok() {
        return utok;
    }

    public void setUtok(int utok) {
        this.utok = utok;
    }
    
}
