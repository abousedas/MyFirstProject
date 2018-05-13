package vue;

import domaine.Sport;
import java.awt.List;
import java.util.ArrayList;
import metier.Action;
import metier.ListAthletes;
import metier.ListDisciplines;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class ListDisciplinesObserverTest {
    
    private ListDisciplinesObserver observer;
    private List listGUI;
    private ListAthletes listAthletes;
    private ListDisciplines listDisciplines;
    private Action action;
    
    @BeforeTest
    protected void setUp() {
        listAthletes = new ListAthletes();
        listDisciplines = new ListDisciplines();
        listGUI = new List();
        observer = new ListDisciplinesObserver(listGUI, listAthletes);
    }
    
    @Test
    public void should_have_empty_list_if_action_received_is_not_instanceof_action() {
        listDisciplines.chargerDonnes();
        observer.update(listDisciplines, "LOAD");
        ArrayList list = new ArrayList();
        for(int i = 0; i<listGUI.getItemCount(); i++) { list.add(listGUI.getItem(i)); } 
        assertThat(list).isEmpty();
    }
    
    @Test
    public void should_have_filled_list_if_action_received_is_instanceof_action() {
        action = new Action(Action.LOAD);
        observer.update(listDisciplines, action);
        int size = listGUI.getItemCount();
        assertThat(size).isGreaterThan(0);
    }
    
    @Test
    public void should_have_sportCrt_if_action_received_is_sel() {
        listDisciplines.setPos(0);
        action = new Action(Action.SEL, listDisciplines.getPos());
        observer.update(listDisciplines, action);
        Sport sportCrt = listAthletes.getSportCrt();
        assertThat(sportCrt).isNotNull();
    }

    @Test
    public void should_only_contain_unique_instance_of_discipline() {
        action = new Action(Action.LOAD);
        observer.update(listDisciplines, action);
        java.util.List list = listDisciplines.getList();
        assertThat(listGUI.getItemCount()).isEqualTo(list.size());
    }    
}
