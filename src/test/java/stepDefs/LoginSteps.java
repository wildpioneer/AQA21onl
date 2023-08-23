package stepDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.configuration.ReadProperties;

public class LoginSteps extends BaseTest {
    private BaseTest baseTest;
    private LoginPage loginPage;

    public LoginSteps(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Given("start browser")
    public void startBrowser() {

    }

    @Given("open login page")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
    }

    @When("user enter username {} and password {}")
    public void setUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(username);
        loginPage.getPswInput().sendKeys(password);
    }

    @When("user clicks login button")
    public void clickLoginButton() {
        loginPage.getLogInButton().click();
    }

    @Then("dashboard page is displayed")
    public void isDashboardPageDisplayed() {
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }
}
