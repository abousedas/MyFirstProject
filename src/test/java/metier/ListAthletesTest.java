package metier;

import dao.AthleteDao;
import domaine.Athlete;
import domaine.Pays;
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
public class ListAthletesTest {
    
    private ListAthletes listAthletes;
    private AthleteDao dao;
    private Pays pays;
    private Sport sport;
    
    @BeforeTest
    protected void setUp() {
        listAthletes = new ListAthletes();
        dao = mock(AthleteDao.class);
        pays = new Pays(34, "CAN", "Canada");
        sport = new Sport(4, "Curling");
    }
    
    @Test
    public void paysCrt_should_be_equal_to_source_pays() {
        listAthletes.setPaysCrt(pays);
        Pays paysCrt = listAthletes.getPaysCrt();
        assertThat(paysCrt).isNotNull();
        assertThat(paysCrt).isEqualToComparingFieldByField(pays);
    }
    
    @Test
    public void sportCrt_should_be_equal_to_source_sport() {
        listAthletes.setSportCrt(sport);
        Sport sportCrt = listAthletes.getSportCrt();
        assertThat(sportCrt).isNotNull();
        assertThat(sportCrt).isEqualToComparingFieldByField(sport);
    }
    
    @Test
    public void should_not_fill_list_when_list_of_athletes_is_empty() {
        listAthletes.setPaysCrt(pays);
        listAthletes.setSportCrt(sport);
        when(dao.getListeAthletes(pays, sport)).thenReturn(new ArrayList());
        listAthletes.chargerAthletes();
        List sports = listAthletes.getList();
        /**
         * Here we need to test if sport isEmpty.
         */
    }
    
    @Test 
    public void should_return_null_if_pos_is_invalide() {
        Athlete athlete = (Athlete)listAthletes.get(-500);
        assertThat(athlete).isNull();
    }
    
    @Test 
    public void should_return_athlete_if_pos_is_valide() {
        listAthletes.chargerAthletes();
        Athlete athlete = (Athlete)listAthletes.get(0);
        assertThat(athlete).isNotNull();
    }
}
