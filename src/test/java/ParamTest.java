import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class ParamTest {

    @Parameters({"login-value", "psw-value"})
    @Test
    public void paramTest(@Optional("Default login") String login, @Optional("Default psw") String psw) {
        System.out.println("Login is: " + login);
        System.out.println("Psw is: " + psw);
    }
}
