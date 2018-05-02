package dao;

import domaine.Athlete;
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
    
    @BeforeTest
    protected void setUp() {
        reader = mock(FileReader.class);
        dao = new AthleteDao(reader);
    }
//    
//    @Test
//    public void should_return_empty_list_when_array_empty() {
//        when(reader.read()).thenReturn(new String[] {});
//        List Athletes = dao.getListeAthletes();
//        assertThat(Athletes).isEmpty();
//    }
//    
//    @Test
//    public void should_return_single_Athlete_list_when_array_has_one_item() {
//        when(reader.read()).thenReturn(new String[] { "12;AUT;Autriche" });
//        List Athlete = dao.getListeAthletes();
//        assertThat(Athlete).isNotEmpty();
//        assertThat(Athlete).hasSize(1);
//        assertThat(Athlete).contains(new Athlete(12, "AUT", "Autriche"));
//    }
//    
//    @Test
//    public void should_return_multiple_Athlete_list_when_array_has_more_than_one_item() {
//        when(reader.read()).thenReturn(new String[] { 
//            "12;AUT;Autriche",
//            "34;CAN;Canada",
//            "49;CRO;Croatie",
//            "66;FRA;France"
//        });
//        List Athlete = dao.getListeAthletes();
//        assertThat(Athlete).isNotEmpty();
//        assertThat(Athlete).hasSize(4);
//        assertThat(Athlete).contains(
//                new Athlete(12, "AUT", "Autriche"),
//                new Athlete(34, "CAN", "Canada"),
//                new Athlete(49, "CRO", "Croatie"),
//                new Athlete(66, "FRA", "France")
//        );
//    }
//    
//    @Test
//    public void should_return_Athlete_list_with_duplicate_when_array_has_duplicate_items() {
//        /* 
//         * Ce n'est pas logique au niveau metier mais l'application 
//         * est concue de cette maniere donc on test.
//         */
//        when(reader.read()).thenReturn(new String[] { 
//            "12;AUT;Autriche",
//            "34;CAN;Canada",
//            "34;CAN;Canada",
//            "49;CRO;Croatie",
//            "66;FRA;France",
//            "66;FRA;France",
//            "66;FRA;France",
//            "66;FRA;France"
//        });
//        List Athlete = dao.getListeAthletes();
//        assertThat(Athlete).isNotEmpty();
//        assertThat(Athlete).hasSize(8);
//        assertThat(Athlete).contains(
//                new Athlete(12, "AUT", "Autriche"),
//                new Athlete(34, "CAN", "Canada"),
//                new Athlete(34, "CAN", "Canada"),
//                new Athlete(49, "CRO", "Croatie"),
//                new Athlete(66, "FRA", "France"),
//                new Athlete(66, "FRA", "France"),
//                new Athlete(66, "FRA", "France"),
//                new Athlete(66, "FRA", "France")
//        );
//    }
//    
//    @Test
//    public void should_return_list_containing_only_instance_of_Athlete() {
//        when(reader.read()).thenReturn(new String[] { 
//            "12;AUT;Autriche",
//            "34;CAN;Canada",
//            "49;CRO;Croatie",
//            "66;FRA;France"
//        });
//        List Athlete = dao.getListeAthletes();
//        assertThat(Athlete).isNotEmpty();
//        assertThat(Athlete).hasSize(4);
//        for(Object p : Athlete) {
//            assertThat(p).isExactlyInstanceOf(Athlete.class);
//        }
//    }
    
}
