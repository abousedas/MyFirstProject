package metier;

import dao.AthleteDao;
import dao.FileReader;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;

import java.util.ArrayList;

/**
 *
 * @author samyabouseda
 */
public class ListAthletes extends ListeObjects {
    
    private Pays paysCrt;
    private Sport sportCrt;
    
    private AthleteDao athleteDao = new AthleteDao(new FileReader());
    
    public void chargerAthletes() {
        if (paysCrt != null && sportCrt != null) {
            this.setPos(NO_POS);
            super.aListe = (ArrayList) athleteDao.getListeAthletes(paysCrt, sportCrt);
            setChanged(); 
            notifyObservers(new Action(Action.LOAD));
        }
    }
    
    public void setPaysCrt(Pays pays) { 
        paysCrt = pays; 
        setChanged(); 
        notifyObservers(new Action(Action.UPD));
    }
    public void setSportCrt(Sport sport) { 
        sportCrt = sport; 
        setChanged(); 
        notifyObservers(new Action(Action.UPD));
    }
    
    public Pays getPaysCrt() { return paysCrt; }
    
    public Sport getSportCrt() { return sportCrt; }
    
    /** Retourne l'Object d'indice pos, null si pos n'est pas correctement défini. */
    @Override
    public Athlete get(int pos) {
        if (pos < 0 || pos >= aListe.size()) { return null; }
        return (Athlete)super.get(pos);
    }
    
    public int size() { return super.size(); } //NOSONAR
    
}
