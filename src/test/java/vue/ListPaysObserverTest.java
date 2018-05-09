package vue;

import domaine.Pays;
import java.awt.List;
import java.util.ArrayList;
import metier.Action;
import metier.ListAthletes;
import metier.ListPays;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class ListPaysObserverTest {
    
    private ListPaysObserver observer;
    private List listGUI;
    private ListAthletes listAthletes;
    private ListPays listPays;
    private Action action;
    
    @BeforeTest
    protected void setUp() {
        listAthletes = mock(ListAthletes.class);
        listPays = new ListPays();
        listAthletes = new ListAthletes();
        listGUI = new List();
        observer = new ListPaysObserver(listGUI, listAthletes);
    }
    
    @Test
    public void should_have_empty_list_if_action_received_is_not_instanceof_action() {
        listPays.chargerDonnes();
        observer.update(listPays, "LOAD");
        ArrayList list = new ArrayList();
        for(int i = 0; i<listGUI.getItemCount(); i++) { list.add(listGUI.getItem(i)); } 
        assertThat(list).isEmpty();
    }
    
    @Test
    public void should_have_filled_list_if_action_received_is_instanceof_action() {
        action = new Action(Action.LOAD);
        observer.update(listPays, action);
        int size = listGUI.getItemCount();
        assertThat(size).isGreaterThan(0);
    }
    
}
