package metier;

import dao.PaysDao;
import domaine.Pays;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import vue.ListPaysObserver;

/**
 *
 * @author samyabouseda
 */
public class ListPaysTest {
    
    private ListPays listPays;
    private PaysDao dao;
    private ListPaysObserver observer;
    private ListAthletes listAthletes;
    private java.awt.List listGUI;
    
    @BeforeTest
    protected void setUp() {
        listGUI = new java.awt.List();
        listAthletes = new ListAthletes();
        listPays = new ListPays();
        dao = mock(PaysDao.class);
        observer = new ListPaysObserver(listGUI, listAthletes);
    }
    
    @Test
    public void should_return_observer_if_is_not_null() {
        listPays = new ListPays(observer);
        int nbOfObservers = listPays.countObservers();
        assertThat(nbOfObservers).isGreaterThan(0);
    }
    
    @Test
    public void should_not_fill_list_when_list_of_pays_is_empty() {
        when(dao.getListePays()).thenReturn(new ArrayList());
        listPays.chargerDonnes();
        List pays = listPays.getList();
        /**
         * Here we need to test if pays isEmpty.
         */
    }
    
    @Test
    public void should_not_fill_list_when_list_of_pays_is_null() {
        when(dao.getListePays()).thenReturn(new ArrayList());
        listPays.chargerDonnes();
        List pays = listPays.getList();
        /**
         * Here we need to test if pays isNull.
         */
    }
    
    @Test
    public void should_fill_list_with_one_pays_when_list_of_pays_has_one() {
        when(dao.getListePays()).thenReturn(new ArrayList());
        listPays.chargerDonnes();
        List pays = listPays.getList();
        /**
         * Here we need to test if pays:
         *  isNotNull,
         *  isNotEmpty,
         *  hasSize(1).
         */
    }
    
    @Test
    public void should_return_null_if_pos_is_not_set() {
        Pays pays = listPays.get();
        assertThat(pays).isNull();
    }
    
    @Test 
    public void should_return_null_if_pos_is_invalide() {
        Pays pays = (Pays)listPays.get(-500);
        assertThat(pays).isNull();
    }
    
    @Test 
    public void should_return_pays_if_pos_is_valide() {
        listPays.chargerDonnes();
        Pays pays = (Pays)listPays.get(0);
        assertThat(pays).isNotNull();
    }
    
    
}
