package vue;

import domaine.Pays;
import domaine.Sport;
import java.awt.TextField;
import metier.Action;
import metier.ListAthletes;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class ListAthletesDetailsTest {
    
    private ListAthletesDetails observer;
    private ListAthletes listAthletes;
    private TextField tfNo, tfPrenom, tfNom, tfNatio, tfSport;
    private Action action;
    private Pays pays;
    private Sport sport;
    
    @BeforeTest
    protected void setUp() {
        tfNo = new TextField();
        tfPrenom = new TextField();
        tfNom = new TextField();
        tfNatio = new TextField();
        tfSport = new TextField();
        pays = new Pays(34, "CAN", "Canada");
        sport = new Sport(4, "Curling");
        listAthletes = new ListAthletes();
        listAthletes.setPaysCrt(pays);
        listAthletes.setSportCrt(sport);
        listAthletes.chargerAthletes();
        observer = new ListAthletesDetails(tfNo, tfPrenom, tfNom, tfNatio, tfSport);
    }
    
    @Test
    public void textFields_should_be_empty_if_action_received_is_not_instanceof_action() {
        observer.update(listAthletes, "SEL");
        assertThat(tfNo.getText()).isEmpty();
        assertThat(tfPrenom.getText()).isEmpty();
        assertThat(tfNom.getText()).isEmpty();
        assertThat(tfNatio.getText()).isEmpty();
        assertThat(tfSport.getText()).isEmpty();
    }
    
    @Test
    public void textFields_should_be_filled_with_details_if_action_received_is_sel() {
        action = new Action(Action.SEL, 0);
        observer.update(listAthletes, action);
        assertThat(tfNo.getText()).isNotEmpty();
        assertThat(tfPrenom.getText()).isNotEmpty();
        assertThat(tfNom.getText()).isNotEmpty();
        assertThat(tfNatio.getText()).isNotEmpty();
        assertThat(tfSport.getText()).isNotEmpty();
    }
    
    @Test
    public void textFields_should_be_empty_if_pos_received_is_negative() {
        action = new Action(Action.SEL, -1);
        observer.update(listAthletes, action);
        assertThat(tfNo.getText()).isEmpty();
        assertThat(tfPrenom.getText()).isEmpty();
        assertThat(tfNom.getText()).isEmpty();
        assertThat(tfNatio.getText()).isEmpty();
        assertThat(tfSport.getText()).isEmpty();
    }
    
    @Test
    public void textFields_should_be_cleared_if_pos_received_after_being_filled_is_negative() {
        textFields_should_be_filled_with_details_if_action_received_is_sel();
        textFields_should_be_empty_if_pos_received_is_negative();
    }
}
