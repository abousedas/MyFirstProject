package vue;

import domaine.Athlete;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.ListAthletes;

/**
 *
 * @author samyabouseda
 */
public class ListAthletesDetails implements Observer {
    
    private TextField no, prenom, nom, natio, sport; //NOSONAR
    
    public ListAthletesDetails(TextField no, TextField prenom, TextField nom, TextField natio, TextField sport) { 
        this.no=no; this.prenom=prenom; this.nom=nom; this.natio=natio; this.sport=sport;
    }
    
    public void update(Observable o, Object args) {
        if (args instanceof Action) { update(o, (Action)args); }
    }
    
    private void update(Observable m, Action args) {
        ListAthletes o = (ListAthletes)m;
        if(args.getAction() == Action.SEL) {
                int posCrt = args.getPos();
                if (posCrt != -1){ remplireChamps(posCrt, o); }
                else {viderChamps();}
        }
    }
    
    private void remplireChamps(int posCrt, ListAthletes o) {
        Athlete a = o.get(posCrt);
        if (a != null) { 
            this.no.setText(String.valueOf(a.getNo()));
            this.prenom.setText(a.getPrenom());
            this.nom.setText(a.getNom());
            this.natio.setText(a.getPays().toString());
            this.sport.setText(a.getSport().toString());
        }
    }
    
    protected void viderChamps(){
        this.no.setText("");
        this.prenom.setText("");
        this.nom.setText("");
        this.natio.setText("");
        this.sport.setText("");
    }
    
}
