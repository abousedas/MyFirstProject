package dao;

import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class AthleteDaoTest {
    
    private AthleteDao dao;
    private FileReader reader;
    private Pays pays;
    private Sport sport;
    
    @BeforeTest
    protected void setUp() {
        reader = mock(FileReader.class);
        dao = new AthleteDao(reader);
        pays = new Pays(70);
        sport = new Sport(6);
    }
    
    @Test
    public void should_return_empty_list_when_array_empty() {
        when(reader.read()).thenReturn(new String[] {});
        List athletes = dao.getListeAthletes(pays, sport);
        assertThat(athletes).isEmpty();
    }
    
    @Test
    public void should_return_single_athlete_list_when_array_has_one_item() {
        when(reader.read()).thenReturn(new String[] { "70;6;19;Adam;ROSEN" });
        List athletes = dao.getListeAthletes(pays, sport);
        assertThat(athletes).isNotEmpty();
        assertThat(athletes).hasSize(1);
        assertThat(athletes).contains(new Athlete(19, "Adam", "ROSEN", pays, sport));
    }
    
    @Test
    public void should_return_multiple_athlete_list_when_array_has_more_than_one_item() {
        when(reader.read()).thenReturn(new String[] { 
            "70;6;19;Adam;ROSEN",
            "70;6;2348;Rupert;STAUDINGER"
        });
        List athletes = dao.getListeAthletes(pays, sport);
        assertThat(athletes).isNotEmpty();
        assertThat(athletes).hasSize(2);
        assertThat(athletes).contains(
                new Athlete(19, "Adam", "ROSEN", pays, sport),
                new Athlete(2348, "Rupert", "STAUDINGER", pays, sport)
        );
    }
    
    @Test
    public void should_return_Athlete_list_with_duplicate_when_array_has_duplicate_items() {
        /* 
         * Ce n'est pas logique au niveau metier mais l'application 
         * est concue de cette maniere donc on test.
         */
        when(reader.read()).thenReturn(new String[] { 
            "70;6;19;Adam;ROSEN",
            "70;6;19;Adam;ROSEN",
            "70;6;2348;Rupert;STAUDINGER",
            "70;6;2348;Rupert;STAUDINGER",
            "70;6;2348;Rupert;STAUDINGER"
        });
        List athletes = dao.getListeAthletes(pays, sport);
        assertThat(athletes).isNotEmpty();
        assertThat(athletes).hasSize(5);
        assertThat(athletes).contains(
                new Athlete(19, "Adam", "ROSEN", pays, sport),
                new Athlete(19, "Adam", "ROSEN", pays, sport),
                new Athlete(2348, "Rupert", "STAUDINGER", pays, sport),
                new Athlete(2348, "Rupert", "STAUDINGER", pays, sport),
                new Athlete(2348, "Rupert", "STAUDINGER", pays, sport)
        );
    }
    
    @Test
    public void should_return_list_containing_only_instance_of_Athlete() {
        when(reader.read()).thenReturn(new String[] { 
            "70;6;19;Adam;ROSEN",
            "70;6;2348;Rupert;STAUDINGER"
        });
        List athletes = dao.getListeAthletes(pays, sport);
        assertThat(athletes).isNotEmpty();
        assertThat(athletes).hasSize(2);
        for(Object a : athletes) {
            assertThat(a).isExactlyInstanceOf(Athlete.class);
        }
    }
    
    @Test
    public void should_return_empty_list_when_arrguments_not_exist() {
        Pays pays = new Pays(55555);
        Sport sport = new Sport(44444);
        when(reader.read()).thenReturn(new String[] { 
            "70;6;19;Adam;ROSEN",
            "70;6;2348;Rupert;STAUDINGER"
        });
        List athletes = dao.getListeAthletes(pays, sport);
        assertThat(athletes).isEmpty();
    }
    
    @Test
    public void should_return_empty_list_when_pays_not_exist() {
        when(reader.read()).thenReturn(new String[] { 
            "55555;6;19;Adam;ROSEN",
            "55555;6;2348;Rupert;STAUDINGER"
        });
        List athletes = dao.getListeAthletes(pays, sport);
        assertThat(athletes).isEmpty();
    }
    
    @Test
    public void should_return_empty_list_when_sport_not_exist() {
        when(reader.read()).thenReturn(new String[] { 
            "70;44444;19;Adam;ROSEN",
            "70;44444;2348;Rupert;STAUDINGER"
        });
        List athletes = dao.getListeAthletes(pays, sport);
        assertThat(athletes).isEmpty();
    }
    
}
