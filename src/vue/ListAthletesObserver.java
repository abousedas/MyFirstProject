/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.List;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.ModeleListAthletes;

/**
 *
 * @author samyabouseda
 */
public class ListAthletesObserver implements Observer {
    List list;
    
    public ListAthletesObserver(List list) { this.list = list; }
    
    public void update(Observable o, Object args) {
        switch(((Action)args).getAction()) {
            case Action.UPD : chargerAthletes((ModeleListAthletes)o); break;
            case Action.LOAD: remplireListe((ModeleListAthletes)o);
        }
    }
    
    private void chargerAthletes(ModeleListAthletes o) {
        o.chargerAthletes();
    }
    
    private void remplireListe(ModeleListAthletes o) {
        int size = o.size();
        list.removeAll();
        for (int i = 0; i < size; i++) {
            list.add(o.get(i).toString());
        }
    }
    
}
