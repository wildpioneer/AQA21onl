package tests;

import factory.BrowserSingleton;
import helper.DataHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;

public class SingletoneTest extends BaseTest {

    @Test
    public void successLoginTest() {
        Assert.assertTrue(
                new LoginStep().successLogin(DataHelper.getAdminUser()).isPageOpened()
        );
    }
}
