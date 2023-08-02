package tests;

import factory.BrowserSingleton;
import org.testng.annotations.AfterTest;

public class BaseTest {

    @AfterTest
    public void tearDown() {
        BrowserSingleton.getInstance().driver.quit();
    }
}
