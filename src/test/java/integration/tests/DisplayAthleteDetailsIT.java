package integration.tests;


import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;
import java.awt.TextField;
import metier.ListAthletes;
import metier.ListDisciplines;
import metier.ListPays;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import vue.ListAthletesDetails;

/**
 *
 * @author samyabouseda
 */
public class DisplayAthleteDetailsIT {   
    
    private ListPays listPays;
    private ListDisciplines listDisciplines;
    private ListAthletes listAthletes;
    private ListAthletesDetails observer;
    private TextField tfNo, tfPrenom, tfNom, tfNatio, tfSport;
    
    @BeforeTest
    protected void setUp() {
        tfNo = new TextField();
        tfPrenom = new TextField();
        tfNom = new TextField();
        tfNatio = new TextField();
        tfSport = new TextField();
        observer = new ListAthletesDetails(tfNo, tfPrenom, tfNom, tfNatio, tfSport);
        listAthletes = new ListAthletes();
        listAthletes.addObserver(observer);
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
    public void load_athletes() {
        listAthletes.chargerAthletes();
        assertThat(listAthletes.getList()).isNotNull();
        assertThat(listAthletes.getList()).isNotEmpty();
    }
    
    @Test(dependsOnMethods = "load_athletes")
    public void select_athlete() {
        int pos = listAthletes.getList().indexOf(new Athlete(329, "Bailey", "BRAM", new Pays(34, "CAN","Canada"), new Sport(5, "Hockey sur glace")));
        listAthletes.setPos(pos);
        assertThat(tfNo.getText()).isNotEmpty();
        assertThat(tfPrenom.getText()).isNotEmpty();
        assertThat(tfNom.getText()).isNotEmpty();
        assertThat(tfNatio.getText()).isNotEmpty();
        assertThat(tfSport.getText()).isNotEmpty();
    }
    
    @Test(dependsOnMethods = "select_athlete")
    public void show_athlete_details() {
        assertThat(tfNo.getText()).isEqualToIgnoringCase("329");
        assertThat(tfPrenom.getText()).isEqualToIgnoringCase("Bailey");
        assertThat(tfNom.getText()).isEqualToIgnoringCase("BRAM");
        assertThat(tfNatio.getText()).isEqualToIgnoringCase("Canada");
        assertThat(tfSport.getText()).isEqualToIgnoringCase("Hockey sur glace");
    }
    
}
