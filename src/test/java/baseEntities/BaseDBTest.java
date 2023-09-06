package baseEntities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

public class BaseDBTest {
    protected DataBaseService dataBaseService;

    @BeforeTest
    public void setupConnectuion() {
        dataBaseService = new DataBaseService();
    }

    @AfterTest
    public void closeConnection() {
        dataBaseService.closeConnection();
    }
}
