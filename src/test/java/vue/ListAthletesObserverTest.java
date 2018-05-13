package vue;

import domaine.Pays;
import domaine.Sport;
import java.awt.List;
import java.util.ArrayList;
import metier.Action;
import metier.ListAthletes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class ListAthletesObserverTest {
    
    private ListAthletesObserver observer;
    private List listGUI;
    private ListAthletes listAthletes;
    private Action action;
    private Pays pays;
    private Sport sport;
    
    @BeforeTest
    protected void setUp() {
        listAthletes = new ListAthletes();
        pays = new Pays(34, "CAN", "Canada");
        sport = new Sport(4, "Curling");
        listAthletes.setPaysCrt(pays);
        listAthletes.setSportCrt(sport);
        listAthletes.chargerAthletes();
        listGUI = new List();
        observer = new ListAthletesObserver(listGUI);
    }
    
    @Test
    public void should_have_empty_list_if_action_received_is_not_instanceof_action() {
        listAthletes.chargerAthletes();
        observer.update(listAthletes, "LOAD");
        ArrayList list = new ArrayList();
        for(int i = 0; i<listGUI.getItemCount(); i++) { list.add(listGUI.getItem(i)); } 
        assertThat(list).isEmpty();
    }
    
    @Test
    public void should_have_filled_list_if_action_received_is_instanceof_action() {
        action = new Action(Action.LOAD);
        observer.update(listAthletes, action);
        int size = listGUI.getItemCount();
        assertThat(size).isGreaterThan(0);
    }

    @Test
    public void should_have_filled_list_in_model_if_action_received_is_load() {
        action = new Action(Action.UPD);
        observer.update(listAthletes, action);
        java.util.List list = listAthletes.getList();
        assertThat(listGUI.getItemCount()).isEqualTo(list.size());
    }
    
    @Test
    public void should_have_filled_list_in_model_if_action_received_is_upd() {
        action = new Action(Action.UPD);
        observer.update(listAthletes, action);
        int size = listAthletes.size();
        assertThat(size).isGreaterThan(0);
    }
    
    @Test
    public void should_interact_with_model_if_action_received_is_upd() {
        action = new Action(Action.UPD);
        ListAthletes spy = spy(listAthletes);
        observer.update(spy, action);  
        verify(spy, atLeast(1)).chargerAthletes();
    }
    
    @Test
    public void should_only_contain_unique_instance_of_athletes() {
        action = new Action(Action.LOAD);
        observer.update(listAthletes, action);
        java.util.List list = listAthletes.getList();
        assertThat(listGUI.getItemCount()).isEqualTo(list.size());
    }  
}
