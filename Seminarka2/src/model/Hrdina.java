package model;

/**
 *
 * @author Tomáš
 */
public class Hrdina {
    private int zivoty;
    private int zlato;
    
    public Hrdina (int zivoty, int zlato){
        this.zivoty = zivoty;
        this.zlato = zlato;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }

    public int getZlato() {
        return zlato;
    }

    public void setZlato(int zlato) {
        this.zlato = zlato;
    }
    
}
