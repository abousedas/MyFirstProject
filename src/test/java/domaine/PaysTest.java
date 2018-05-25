package domaine;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class PaysTest {
    
    private Pays pays;
    
    @BeforeTest
    protected void setUp() {
        pays = new Pays(34);
    }
    
    @Test
    public void should_return_negative_number_if_code_is_not_set() {
        pays = new Pays();
        int no = pays.getNo();
        assertThat(no).isEqualTo(-1);
    }
    
    @Test
    public void should_return_null_if_code_is_not_set() {
        String code = pays.getCode();
        assertThat(code).isNull();
    }
    
    @Test
    public void should_return_null_if_nom_is_not_set() {
        String nom = pays.getNom();
        assertThat(nom).isNull();
    }

    @Test
    public void should_return_false_if_param_not_instanceof_pays() {
        assertThat(pays.equals(new Integer(5))).isFalse();
    }

    @Test
    public void should_return_false_if_param_is_null() {
        assertThat(pays.equals(null)).isFalse();
    }

    @Test
    public void should_return_hashCode() {
        assertThat(pays.hashCode()).isNotZero();
    }

    
}
