/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.Observable;
import java.util.Observer;
import java.awt.List;
import metier.*;
import domaine.*;

/**
 *
 * @author samyabouseda
 */
public class ListPaysObserver implements Observer {
    List list;
    ListAthletes mAthletes;
    
    public ListPaysObserver(List list, ListAthletes mAthletes) { this.list = list; this.mAthletes = mAthletes; }
    
    public void update(Observable o, Object args) {
        switch(((Action)args).getAction()) {
            case Action.LOAD: chargerPays((ListPays)o); break;
            case Action.SEL : selPays((ListPays)o);
        }
    }
    
    private void chargerPays(ListPays o) {
        int size = o.size();
        list.removeAll();
        for (int i = 0; i < size; i++) {
            list.add(o.get(i).toString());
        }
    }
    
    private void selPays(ListPays o) {
        Pays pays = o.get(o.getPos());
        mAthletes.setPaysCrt(pays);
    }
    
}
