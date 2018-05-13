package dao;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author samyabouseda
 */
public class FileReaderTest {
    
    private FileReader reader;
    
    @BeforeTest
    protected void setUp() {
        reader = new FileReader();
    }
    
    @Test
    public void should_return_empty_list_when_file_is_null() {
        String[] file = reader.read();
        assertThat(file).isEmpty();
    }
    
    @Test
    public void should_return_list_when_file_is_not_null_and_not_empty() {
        reader.setFile("Pays.txt");
        String[] file = reader.read();
        assertThat(file).isNotEmpty();  
    }
    
}
