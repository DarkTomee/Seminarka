package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Tomáš
 */

public class ObjektovySoubor implements DataManager{

    public void uloz(String jmenoSouboru, Inventar inventar) throws Exception {
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(jmenoSouboru));
        output.writeObject(inventar);
        output.close();
    }
    
    public Inventar nacti(String jmenoSouboru) throws Exception {
        ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(jmenoSouboru));
        Inventar inventar = (Inventar) input.readObject();
        input.close();
        return inventar;
    }
    /**
    public Inventar nactiInventarXML(String jmenoSouString) throws Exception {
    	DocumentFactory df = DocumentFactory.getInstance();
    	Document doc = df.createDocument();
    	Element root = df.createElement("people");
    	doc.add(root);
    	Element novak = df.createElement("person");
    	novak.addAttribute("firstname"
    	, "Josef");
    	novak.addAttribute("lastname"
    	,
    	"Novak");
    	Element addr = df.createElement("address");
    	Element city = df.createElement("city");
    	city.setText("Hradec Kralove");
    	addr.add(city);
    	novak.add(addr);
    	root.add(novak); 
		return null;
    }*/
}

