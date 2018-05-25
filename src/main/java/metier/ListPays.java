/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.FileReader;
import dao.PaysDao;
import domaine.Pays;
import java.util.Observer;

/**
 *
 * @author samyabouseda
 */
public class ListPays extends ListeObjects {
    
    private PaysDao paysDao = new PaysDao(new FileReader());
    
    public ListPays() { super(); }
    public ListPays(Observer obs) { super(obs); }
    
    public void chargerDonnes() {
        super.aListe = (java.util.ArrayList)paysDao.getListePays();
        setChanged(); notifyObservers(new Action(Action.LOAD));
    }
    
    /** Retourne l'Object d'indice pos, null si pos n'est pas correctement défini. */
    public Pays get(int pos) {
        if (pos < 0 || pos >= aListe.size()) { return null; }
        return (Pays)super.get(pos);
    }
    
    public Pays get() {return (Pays)super.get();  } 
    
    public int size() { return super.size(); }
}
