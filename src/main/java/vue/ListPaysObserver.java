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
        if (args instanceof Action) { update(o, (Action)args); }
    }
    
    private void update(Observable o, Action args) {
        switch(args.getAction()) {
            case Action.LOAD: chargerPays((ListPays)o); break;
            case Action.SEL : selPays((ListPays)o); break;
            default: return;
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
