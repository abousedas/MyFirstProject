/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.FileReader;
import dao.SportDao;
import domaine.Sport;

/**
 *
 * @author samyabouseda
 */
public class ListDisciplines extends ListeObjects {
    
    private SportDao sportDao = new SportDao(new FileReader());
    
    public void chargerDonnes() {
        super.aListe = sportDao.getListeSports();
        setChanged(); notifyObservers(new Action(Action.LOAD));
    }
    
    /** Retourne l'Object d'indice pos, null si pos n'est pas correctement défini. */
    public Sport get(int pos) {
        if (pos < 0 || pos >= aListe.size()) { return null; }
        return (Sport)super.get(pos);
    }
}
