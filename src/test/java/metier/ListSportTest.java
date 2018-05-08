package metier;

import dao.SportDao;
import domaine.Sport;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class ListSportTest {
    
    private ListDisciplines listSports;
    private SportDao dao;
    
    @BeforeTest
    protected void setUp() {
        listSports = new ListDisciplines();
        dao = mock(SportDao.class);
    }
    
    @Test
    public void should_not_fill_list_when_list_of_sport_is_empty() {
        when(dao.getListeSports()).thenReturn(new ArrayList());
        listSports.chargerDonnes();
        List sports = listSports.getList();
        /**
         * Here we need to test if sport isEmpty.
         */
    }
    
    @Test
    public void should_not_fill_list_when_list_of_sport_is_null() {
        when(dao.getListeSports()).thenReturn(new ArrayList());
        listSports.chargerDonnes();
        List sports = listSports.getList();
        /**
         * Here we need to test if sport isNull.
         */
    }
    
    @Test
    public void should_fill_list_with_one_sport_when_list_of_sport_has_one() {
        when(dao.getListeSports()).thenReturn(new ArrayList());
        listSports.chargerDonnes();
        List sports = listSports.getList();
        /**
         * Here we need to test if sport:
         *  isNotNull,
         *  isNotEmpty,
         *  hasSize(1).
         */
    }
    
    @Test 
    public void should_return_null_if_pos_is_invalide() {
        Sport sport = (Sport)listSports.get(-500);
        assertThat(sport).isNull();
    }
    
    @Test 
    public void should_return_sport_if_pos_is_valide() {
        listSports.chargerDonnes();
        Sport sport = (Sport)listSports.get(0);
        assertThat(sport).isNotNull();
    }
    
    
}
