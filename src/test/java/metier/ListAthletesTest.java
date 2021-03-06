package metier;

import dao.AthleteDao;
import dao.FileReader;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
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
        listAthletes.setPaysCrt(new Pays(1212121));
        listAthletes.setSportCrt(sport);
        listAthletes.chargerAthletes();
        List athletes = listAthletes.getList();
        assertThat(athletes).isEmpty();
    }
    
    @Test
    public void should_fill_the_list_after_chargerAthletes() {
        listAthletes.setSportCrt(sport);
        listAthletes.setPaysCrt(pays);
        listAthletes.chargerAthletes();
        List athletes = listAthletes.getList();
        assertThat(athletes.size()).isGreaterThan(0);
        for(Object item : athletes) {
            assertThat(item).isExactlyInstanceOf(Athlete.class);
        }
    }    
    
    @Test 
    public void should_return_null_if_pos_is_under_boundry() {
        Athlete athlete = (Athlete)listAthletes.get(-500);
        assertThat(athlete).isNull();
    }
    
    @Test 
    public void should_return_null_if_pos_is_over_boundry() {
        Athlete athlete = (Athlete)listAthletes.get(Integer.MAX_VALUE);
        assertThat(athlete).isNull();
    }
    
    @Test 
    public void should_return_athlete_if_pos_is_valide() {
        listAthletes.setSportCrt(sport);
        listAthletes.setPaysCrt(pays);
        listAthletes.chargerAthletes();
        Athlete athlete = (Athlete)listAthletes.get(0);
        assertThat(athlete).isNotNull();
    }
    
    @Test 
    public void observable_should_have_changed_after_chargerAthletes() {  
        listAthletes.setSportCrt(sport);
        listAthletes.setPaysCrt(pays);        
        listAthletes.chargerAthletes();
        assertThat(listAthletes.hasChanged()).isFalse();
    }

    @Test 
    public void observable_should_have_changed_after_setSportCrt() {        
        listAthletes.setSportCrt(sport);
        assertThat(listAthletes.hasChanged()).isFalse();
    }
    
    @Test 
    public void observable_should_have_changed_after_setPaysCrt() {        
        listAthletes.setPaysCrt(pays);
        assertThat(listAthletes.hasChanged()).isFalse();
    }
    
}
