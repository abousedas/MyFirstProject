
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("Logger is working!");
        new vue.FrmMain().setVisible(true);
    }
}