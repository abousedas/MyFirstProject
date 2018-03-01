/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;

/**
 *
 * @author samyabouseda
 */
public class ModeleListAthletes extends ListeObjects {
    Pays paysCrt;
    Sport sportCrt;
    
    public void chargerAthletes() {
        if (paysCrt != null && sportCrt != null) {
            super.aListe = dao.AthleteDao.getListeAthletes(paysCrt, sportCrt);
            setChanged(); notifyObservers(new Action(Action.LOAD));
        }
        System.out.println(paysCrt);
        System.out.println(sportCrt);
    }
    
    public void setPaysCrt(Pays pays) { 
        paysCrt = pays; 
        setChanged(); notifyObservers(new Action(Action.UPD));
        System.out.println("Pays select: " + pays.toString());
    }
    public void setSportCrt(Sport sport) { 
        sportCrt = sport; 
        setChanged(); notifyObservers(new Action(Action.UPD));
        System.out.println("Sport select: " + sport.toString());
    }
    
    /** Retourne l'Object d'indice pos, null si pos n'est pas correctement défini. */
    public Athlete get(int pos) {
        if (pos < 0 || pos >= aListe.size()) { return null; }
        return (Athlete)super.get(pos);
    }

}
