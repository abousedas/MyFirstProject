package vue;

import java.awt.List;
import java.util.ArrayList;
import metier.Action;
import metier.ListAthletes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
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
    private Action action;
    
    @BeforeTest
    protected void setUp() {
        listAthletes = mock(ListAthletes.class);
        listGUI = new List();
        observer = new ListPaysObserver(listGUI, listAthletes);
    }
    
    @Test
    public void should_have_empty_list_if_action_received_is_not_instanceof_action() {
        observer.update(listAthletes, "LOAD");
        ArrayList list = new ArrayList();
        for(int i = 0; i<listGUI.getItemCount(); i++) { list.add(listGUI.getItem(i)); } 
        assertThat(list).isEmpty();
    }
    
    @Test
    public void should_have_filled_list_if_action_received_is_instanceof_action() {
        /*
         * Here we need to test if the list co
         */
    }
}
