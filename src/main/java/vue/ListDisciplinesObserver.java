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
import metier.ListAthletes;
import metier.ListDisciplines;

/**
 *
 * @author samyabouseda
 */
public class ListDisciplinesObserver implements Observer {
    List list;
    ListAthletes mAthletes;
    
    public ListDisciplinesObserver(List list, ListAthletes mAthletes) { this.list = list; this.mAthletes = mAthletes; }
    
    public void update(Observable o, Object args) {
        if (args instanceof Action) { update(o, (Action)args); }
    }

    private void update(Observable o, Action args) {
        switch(args.getAction()) {
            case Action.LOAD: chargerDisciplines((ListDisciplines)o); break;
            case Action.SEL : selSport((ListDisciplines)o); break;
        }
    }
    
    private void chargerDisciplines(ListDisciplines o) {
        int size = o.size();
        list.removeAll();
        for (int i = 0; i < size; i++) {
            list.add(o.get(i).toString());
        }
    }
    
    private void selSport(ListDisciplines o) {
        Sport sport = o.get(o.getPos());
        mAthletes.setSportCrt(sport);
    }
}
