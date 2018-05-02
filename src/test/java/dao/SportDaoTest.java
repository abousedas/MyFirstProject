package dao;

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
public class SportDaoTest {
    
    private SportDao dao;
    private FileReader reader;
    
    @BeforeTest
    protected void setUp() {
        reader = mock(FileReader.class);
        dao = new SportDao(reader);
    }
    
    @Test
    public void should_return_empty_list_when_array_empty() {
        when(reader.read()).thenReturn(new String[] {});
        List sports = dao.getListeSports();
        assertThat(sports).isEmpty();
    }
    
    @Test
    public void should_return_single_sport_list_when_array_has_one_item() {
        when(reader.read()).thenReturn(new String[] { "7;Patinage artistique" });
        List sports = dao.getListeSports();
        assertThat(sports).isNotEmpty();
        assertThat(sports).hasSize(1);
        assertThat(sports).contains(new Sport(7, "Patinage artistique"));
    }
    
    @Test
    public void should_return_multiple_sport_list_when_array_has_more_than_one_item() {
        when(reader.read()).thenReturn(new String[] { 
            "4;Curling",
            "5;Hockey sur glace",
            "6;Luge",
            "7;Patinage artistique"
        });
        List sports = dao.getListeSports();
        assertThat(sports).isNotEmpty();
        assertThat(sports).hasSize(4);
        assertThat(sports).contains(
                new Sport(4, "Curling"),
                new Sport(5, "Hockey sur glace"),
                new Sport(6, "Luge"),
                new Sport(7, "Patinage artistique")
        );
    }
    
    @Test
    public void should_return_sport_list_with_duplicate_when_array_has_duplicate_items() {
        /* 
         * Ce n'est pas logique au niveau metier mais l'application 
         * est concue de cette maniere donc on test.
         */
        when(reader.read()).thenReturn(new String[] { 
            "4;Curling",
            "4;Curling",
            "5;Hockey sur glace",
            "6;Luge",
            "6;Luge",
            "6;Luge",
            "7;Patinage artistique",
            "7;Patinage artistique"
        });
        List sports = dao.getListeSports();
        assertThat(sports).isNotEmpty();
        assertThat(sports).hasSize(8);
        assertThat(sports).contains(
                new Sport(4, "Curling"),
                new Sport(4, "Curling"),
                new Sport(5, "Hockey sur glace"),
                new Sport(6, "Luge"),
                new Sport(6, "Luge"),
                new Sport(6, "Luge"),
                new Sport(7, "Patinage artistique"),
                new Sport(7, "Patinage artistique")
        );
    }
    
    @Test
    public void should_return_list_containing_only_instance_of_sport() {
        when(reader.read()).thenReturn(new String[] { 
            "4;Curling",
            "5;Hockey sur glace",
            "6;Luge",
            "7;Patinage artistique"
        });
        List sports = dao.getListeSports();
        assertThat(sports).isNotEmpty();
        assertThat(sports).hasSize(4);
        for(Object s : sports) {
            assertThat(s).isExactlyInstanceOf(Sport.class);
        }
    }
    
}
