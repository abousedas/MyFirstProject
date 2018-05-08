package metier;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class ActionTest {
    
    private Action action;
    private static final int LOAD = 1;
    
    @BeforeTest
    protected void setUp() {
        action = new Action(Action.LOAD);
    }
    
    @Test
    public void should_return_action_id_when_getAction_is_called() {
        int actionId = action.getAction();
        assertThat(actionId).isNotNull();
        assertThat(actionId).isEqualTo(LOAD);
    }
    
    @Test
    public void should_return_negative_pos_when_pos_not_set() {
        int pos = action.getPos();
        assertThat(pos).isNotNull();
        assertThat(pos).isNegative();
    }
    
    @Test
    public void should_return_postitive_pos_when_pos_is_set() {
        action = new Action(Action.LOAD, 1);
        int pos = action.getPos();
        assertThat(pos).isNotNull();
        assertThat(pos).isPositive();
        assertThat(pos).isEqualTo(1);
    }
}
