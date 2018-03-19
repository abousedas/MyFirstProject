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
public class ListAthletesDetails implements Observer {
    TextField no, prenom, nom, natio, sport;
    public ListAthletesDetails(TextField no, TextField prenom, TextField nom, TextField natio, TextField sport) { 
        this.no=no; this.prenom=prenom; this.nom=nom; this.natio=natio; this.sport=sport;
    }
    
    public void update(Observable m, Object args) {
        ListAthletes o = (ListAthletes)m;
        switch(((Action)args).getAction()) {
            case Action.SEL : 
                int posCrt = ((Action)args).getPos();
                if (posCrt != -1){ remplireChamps(posCrt, o); }
                else {viderChamps();}
                break;
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
