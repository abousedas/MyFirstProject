/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import domaine.Sport;
import java.awt.List;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.ModeleListAthletes;
import metier.ModeleListDisciplines;
import metier.ModeleListPays;

/**
 *
 * @author samyabouseda
 */
public class ListDisciplineObserver implements Observer {
    List list;
    ModeleListAthletes mAthletes;
    
    public ListDisciplineObserver(List list, ModeleListAthletes mAthletes) { this.list = list; this.mAthletes = mAthletes; }
    
    public void update(Observable o, Object args) {
        switch(((Action)args).getAction()) {
            case Action.LOAD: chargerDisciplines((ModeleListDisciplines)o); break;
            case Action.SEL : selSport((ModeleListDisciplines)o);
        }
    }
    
    private void chargerDisciplines(ModeleListDisciplines o) {
        int size = o.size();
        list.removeAll();
        for (int i = 0; i < size; i++) {
            list.add(o.get(i).toString());
        }
    }
    
    private void selSport(ModeleListDisciplines o) {
        Sport sport = o.get(o.getPos());
        mAthletes.setSportCrt(sport);
    }
}
