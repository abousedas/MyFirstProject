package vue;

import java.awt.List;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.ListAthletes;

/**
 *
 * @author samyabouseda
 */
public class ListAthletesObserver implements Observer {
    
    private List list;
    
    public ListAthletesObserver(List list) { 
        this.list=list;
    }
    
    public void update(Observable o, Object args) {
        if (args instanceof Action) { update(o, (Action)args); }
    }
    
    private void update(Observable m, Action args) {
        ListAthletes o = (ListAthletes)m;
        switch(((Action)args).getAction()) {
            case Action.UPD : o.chargerAthletes(); break;
            case Action.LOAD: remplireListe(o);
        }
    }
    
    private void remplireListe(ListAthletes o) {
        int size = o.size();
        list.removeAll();
        for (int i = 0; i < size; i++) {
            list.add(o.get(i).toString());
        }
    }
}
