package vue;

import java.awt.List;
import metier.Action;
import metier.ListAthletes;
import static org.mockito.Mockito.mock;
import org.testng.annotations.BeforeTest;

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
        listGUI = mock(List.class);
        listAthletes = mock(ListAthletes.class);
        action = mock(Action.class);
        observer = new ListPaysObserver(listGUI, listAthletes);
    }
}
