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
    ModeleListAthletes mAthletes;
    
    public ListPaysObserver(List list, ModeleListAthletes mAthletes) { this.list = list; this.mAthletes = mAthletes; }
    
    public void update(Observable o, Object args) {
        switch(((Action)args).getAction()) {
            case Action.LOAD: chargerPays((ModeleListPays)o); break;
            case Action.SEL : selPays((ModeleListPays)o);
        }
    }
    
    private void chargerPays(ModeleListPays o) {
        int size = o.size();
        list.removeAll();
        for (int i = 0; i < size; i++) {
            list.add(o.get(i).toString());
        }
    }
    
    private void selPays(ModeleListPays o) {
        Pays pays = o.get(o.getPos());
        mAthletes.setPaysCrt(pays);
    }
    
}
