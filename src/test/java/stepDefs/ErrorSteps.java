package stepDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;

public class ErrorSteps extends BaseTest {
    private BaseTest baseTest;

    public ErrorSteps(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Then("error {} is displayed")
    public void isErrorDisplayed(String errorMessage) {
        Assert.assertTrue(new LoginPage(driver).getErrorTextElement().getText().equals(errorMessage));
    }
}
