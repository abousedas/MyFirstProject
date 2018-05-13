package domaine;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class SportTest {
    
    private Sport sport;
    
    @BeforeTest
    protected void setUp() {
    }
    
    @Test
    public void should_return_positive_number_when_getNo() {
        sport = new Sport(10);
        int no = sport.getNo();
        assertThat(no).isPositive();
    }

    @Test
    public void should_return_null_if_nom_is_not_set() {
        sport = new Sport(10);
        String nom = sport.getNom();
        assertThat(nom).isNull();
    }    
}
