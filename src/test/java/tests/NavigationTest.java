package tests;

import baseEntities.BaseTest;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.configuration.ReadProperties;

public class NavigationTest extends BaseTest {

    @Test
    public void successLoginTest() {
        driver.get(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("atrostyanko@gmail.com");
        loginPage.getPswInput().sendKeys("Qwertyu_1");
        loginPage.getLogInButton().click();
    }
}
