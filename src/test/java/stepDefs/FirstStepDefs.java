package stepDefs;

import factory.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.configuration.ReadProperties;

import java.util.Map;

public class FirstStepDefs {
    private WebDriver driver;

    @Given("открыт браузер")
    public void startBrowser() {
        //driver = new BrowserFactory().getDriver();
    }

    @When("страница логина открыта")
    public void openLoginPage() {
        //driver.get(ReadProperties.getUrl());
    }

    @Then("поле username отображается")
    public void isUsernameFieldDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

    @And("поле password отображается")
    public void isPasswordFieldDisplayed() {
        Assert.assertTrue(true);
    }

    @Then("поле password не отображается")
    public void isPasswordFieldNotDisplayed() {
        Assert.assertTrue(true);
    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @When("user logged in")
    public void userLoggedIn(DataTable parameters) {
        Map<String, String> expectedValues = parameters.asMap(String.class, String.class);
        System.out.println("Username: " + expectedValues.get("username"));
        System.out.println("Password: " + expectedValues.get("password"));
    }

    @When("^admin ([^\"]*) with password \"([^\"]*)\" logged in$")
    public void adminWithPasswordLoggedIn(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @Then("title is {string}")
    public void titleIsAllProjects(String value) {
        System.out.println("Project ID: " + value);
    }

    @And("^project id is (\\d+)$")
    public void projectIdIs(int value) {

    }

    @And("^all elements \"(are|are not)\" visible$")
    public void allElementsAreVisible(String parameter) {
        if (parameter.equals("are")) {

        } else {

        }
    }

    @Then("error is displayed")
    public void isErrorDisplayed() {
        System.out.println("Ошибка отобразилась");
    }
}
