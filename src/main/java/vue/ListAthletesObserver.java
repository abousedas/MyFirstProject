/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import domaine.Athlete;
import java.awt.List;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.ListAthletes;

/**
 *
 * @author samyabouseda
 */
public class ListAthletesObserver implements Observer {
    List list;
    public ListAthletesObserver(List list) { 
        this.list=list;
    }
    
    public void update(Observable m, Object args) {
        ListAthletes o = (ListAthletes)m;
        switch(((Action)args).getAction()) {
            case Action.UPD : chargerAthletes(o); break;
            case Action.LOAD: remplireListe(o);
        }
    }
    
    private void chargerAthletes(ListAthletes o) {
        o.chargerAthletes();
    }
    
    private void remplireListe(ListAthletes o) {
        int size = o.size();
        list.removeAll();
        for (int i = 0; i < size; i++) {
            list.add(o.get(i).toString());
        }
    }
}
