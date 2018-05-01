package dao;

import domaine.Pays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class PaysDaoTest {
    
    private PaysDao dao;
    private FileReader reader;
    
    @BeforeTest
    protected void setUp() {
        reader = mock(FileReader.class);
        dao = new PaysDao(reader);
    }
    
    @Test
    public void should_return_empty_list_when_array_empty() {
        when(reader.read()).thenReturn(new String[] {});
        List pays = dao.getListePays();
        assertThat(pays).isEmpty();
    }
    
    @Test
    public void should_return_single_pays_list_when_array_has_one_item() {
        when(reader.read()).thenReturn(new String[] { "12;AUT;Autriche" });
        List pays = dao.getListePays();
        assertThat(pays).isNotEmpty();
        assertThat(pays).hasSize(1);
        assertThat(pays).contains(new Pays(12, "AUT", "Autriche"));
    }
    
    @Test
    public void should_return_multiple_pays_list_when_array_has_more_than_one_item() {
        when(reader.read()).thenReturn(new String[] { 
            "12;AUT;Autriche",
            "34;CAN;Canada",
            "49;CRO;Croatie",
            "66;FRA;France"
        });
        List pays = dao.getListePays();
        assertThat(pays).isNotEmpty();
        assertThat(pays).hasSize(4);
        assertThat(pays).contains(
                new Pays(12, "AUT", "Autriche"),
                new Pays(34, "CAN", "Canada"),
                new Pays(49, "CRO", "Croatie"),
                new Pays(66, "FRA", "France")
        );
    }
    
    @Test
    public void should_return_pays_list_with_duplicate_when_array_has_duplicate_items() {
        /* 
         * Ce n'est pas logique au niveau metier mais l'application 
         * est concue de cette maniere donc on test.
         */
        when(reader.read()).thenReturn(new String[] { 
            "12;AUT;Autriche",
            "34;CAN;Canada",
            "34;CAN;Canada",
            "49;CRO;Croatie",
            "66;FRA;France",
            "66;FRA;France",
            "66;FRA;France",
            "66;FRA;France"
        });
        List pays = dao.getListePays();
        assertThat(pays).isNotEmpty();
        assertThat(pays).hasSize(8);
        assertThat(pays).contains(
                new Pays(12, "AUT", "Autriche"),
                new Pays(34, "CAN", "Canada"),
                new Pays(34, "CAN", "Canada"),
                new Pays(49, "CRO", "Croatie"),
                new Pays(66, "FRA", "France"),
                new Pays(66, "FRA", "France"),
                new Pays(66, "FRA", "France"),
                new Pays(66, "FRA", "France")
        );
    }
    
    @Test
    public void should_return_list_containing_only_instance_of_pays() {
        when(reader.read()).thenReturn(new String[] { 
            "12;AUT;Autriche",
            "34;CAN;Canada",
            "49;CRO;Croatie",
            "66;FRA;France"
        });
        List pays = dao.getListePays();
        assertThat(pays).isNotEmpty();
        assertThat(pays).hasSize(4);
        for(Object p : pays) {
            assertThat(p).isExactlyInstanceOf(Pays.class);
        }
    }
    
}
