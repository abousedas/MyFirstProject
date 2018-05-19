package vue;

import java.awt.Component;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class FrmMainTest {
    
    private FrmMain frmMain;
    
    @BeforeTest
    protected void setUp() {
        frmMain = new FrmMain(); 
    }
    
    @Test
    public void should_not_be_null_after_initialisation() {
        assertThat(frmMain).isNotNull();
    }
    
    @Test 
    public void should_have_a_title_after_init_components() {
        assertThat(frmMain.getTitle()).isNotBlank();
    }
    
    @Test
    public void list_of_pays_manager_should_be_filled_after_loadData() {
        List list = frmMain.listPays.getList();
        assertThat(list.size()).isGreaterThan(0);
    }
    
    @Test
    public void list_of_discipline_manager_should_be_filled_after_loadData() {
        List list = frmMain.listDisciplines.getList();
        assertThat(list.size()).isGreaterThan(0);
    }
    
    @Test
    public void pays_manager_should_have_an_observer_after_initObservers() {
        assertThat(frmMain.listPays.countObservers()).isGreaterThan(0); // isGreaterThan vs isEqual ???
    }

    @Test
    public void disciplines_manager_should_have_an_observer_after_initObservers() {
        assertThat(frmMain.listDisciplines.countObservers()).isGreaterThan(0); // isGreaterThan vs isEqual ???
    }
    
    @Test
    public void athletes_manager_should_have_observers_after_initObservers() {
        assertThat(frmMain.listAthletes.countObservers()).isGreaterThan(1); // isGreaterThan vs isEqual ???
    }
    
    @Test
    public void should_have_windowListeners() {
       assertThat(frmMain.getWindowListeners().length).isGreaterThan(0);
    }
    
    @Test
    public void list_components_should_have_items_listeners() {
        Component[] components = frmMain.getComponents();
        for(Object item : components) {
            if(item instanceof java.awt.List) { 
                java.awt.List list = (java.awt.List)item;
                assertThat(list.getItemListeners().length).isGreaterThan(0);
            }
        }
    }

    @Test
    public void textFields_components_should_have_editable_property_set_to_false() {
        Component[] components = frmMain.getComponents();
        for(Object item : components) {
            if(item instanceof java.awt.TextField) { 
                java.awt.TextField textField = (java.awt.TextField)item;
                assertThat(textField.isEditable()).isFalse();
            }
        }
    }  

}
