package integration.tests;


import domaine.Pays;
import domaine.Sport;
import metier.ListAthletes;
import metier.ListDisciplines;
import metier.ListPays;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class LoadingAthletesIT {   
    
    private ListPays listPays;
    private ListDisciplines listDisciplines;
    private ListAthletes listAthletes;
    
    @BeforeTest
    protected void setUp() {
        listAthletes = new ListAthletes();
        listPays = new ListPays();
        listDisciplines = new ListDisciplines();
        listPays.chargerDonnes();
        listDisciplines.chargerDonnes();
    }    
    
    @Test
    public void select_country() {
        int pos = listPays.getList().indexOf(new Pays(34, "CAN","Canada"));
        listAthletes.setPaysCrt(listPays.get(pos));
        Pays paysCrt = listAthletes.getPaysCrt();
        assertThat(paysCrt).isNotNull();
        assertThat(paysCrt).isInstanceOf(Pays.class);
        assertThat(paysCrt).isEqualToComparingFieldByField(new Pays(34, "CAN","Canada"));
    }
    
    @Test(dependsOnMethods = "select_country")
    public void select_sport() {
        int pos = listDisciplines.getList().indexOf(new Sport(5, "Hockey sur glace"));
        listAthletes.setSportCrt(listDisciplines.get(pos));
        Sport sportCrt = listAthletes.getSportCrt();
        assertThat(sportCrt).isNotNull();
        assertThat(sportCrt).isInstanceOf(Sport.class);
        assertThat(sportCrt).isEqualToComparingFieldByField(new Sport(5, "Hockey sur glace"));        
    }
    
    @Test(dependsOnMethods = "select_sport")
    public void load_ahtletes() {
        listAthletes.chargerAthletes();
        assertThat(listAthletes.getList()).isNotNull();
        assertThat(listAthletes.getList()).isNotEmpty();
    }
    
}
