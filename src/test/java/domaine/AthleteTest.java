package domaine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class AthleteTest {
    
    private Athlete athlete;
    private Pays pays;
    private Sport sport;
    
    @BeforeTest
    protected void setUp() {
        pays = mock(Pays.class);
        sport = mock(Sport.class);
        athlete = new Athlete(12);
    }
    
    @Test
    public void should_return_positive_number_when_getNo() {
        int no = athlete.getNo();
        assertThat(no).isPositive();
    }
    
    @Test
    public void should_return_null_if_nom_is_not_set() {
        String nom = athlete.getNom();
        assertThat(nom).isNull();
    }
    
    @Test
    public void should_return_null_if_prenom_is_not_set() {
        String prenom = athlete.getPrenom();
        assertThat(prenom).isNull();
    }
    
    @Test
    public void should_return_null_if_pays_is_not_set() {
        Pays pays = athlete.getPays();
        assertThat(pays).isNull();
    }

    @Test
    public void should_return_null_if_sport_is_not_set() {
        Sport sport = athlete.getSport();
        assertThat(sport).isNull();
    }    
    
    @Test
    public void should_return_empty_string_if_nom_or_prenom_is_not_set() {
        String athleteString = athlete.toString();
        assertThat(athleteString).isBlank();
    }

    @Test
    public void should_return_string_if_nom_or_prenom_is_set() {
        athlete = new Athlete(12, "bob", "dylan", pays, sport);
        String athleteString = athlete.toString();
        assertThat(athleteString).isNotBlank();
    }
    
}
