package metier;

import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;

/**
 *
 * @author samyabouseda
 */
public class ListAthletes extends ListeObjects {
    Pays paysCrt;
    Sport sportCrt;
    
    public void chargerAthletes() {
        this.setPos(NO_POS);
        if (paysCrt != null && sportCrt != null) {
            super.aListe = dao.AthleteDao.getListeAthletes(paysCrt, sportCrt);
            setChanged(); notifyObservers(new Action(Action.LOAD));
        }
    }
    
    public void setPaysCrt(Pays pays) { 
        paysCrt = pays; 
        setChanged(); notifyObservers(new Action(Action.UPD));
    }
    public void setSportCrt(Sport sport) { 
        sportCrt = sport; 
        setChanged(); notifyObservers(new Action(Action.UPD));
    }
    
    /** Retourne l'Object d'indice pos, null si pos n'est pas correctement défini. */
    public Athlete get(int pos) {
        if (pos < 0 || pos >= aListe.size()) { return null; }
        return (Athlete)super.get(pos);
    }

}
