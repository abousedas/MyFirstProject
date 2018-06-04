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
        sport = new Sport(10);
    }
    
    @Test
    public void should_return_positive_number_when_getNo() {
        int no = sport.getNo();
        assertThat(no).isPositive();
    }

    @Test
    public void should_return_null_if_nom_is_not_set() {
        String nom = sport.getNom();
        assertThat(nom).isNull();
    }

    @Test
    public void should_return_false_if_param_not_instanceof_pays() {
        assertThat(sport.equals(new Integer(5))).isFalse();
    }

    @Test
    public void should_return_false_if_param_is_null() {
        assertThat(sport.equals(null)).isFalse();
    }

    @Test
    public void should_return_hashCode() {
        assertThat(sport.hashCode()).isNotZero();
    }
}
