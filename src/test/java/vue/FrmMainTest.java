package vue;

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
    public void should_update_the_version_textField_with_version_number() {
        String version = frmMain.getVersion();
        assertThat(version).isNotNull();
        assertThat(version).isNotEmpty();
    }
}
