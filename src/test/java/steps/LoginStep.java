package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step
    public DashboardPage successLogin(String username, String psw) {
        loginPage.login(username, psw);

        return dashboardPage;
    }

    @Step
    public LoginPage negativeLogin(String username, String psw) {
        loginPage.login(username, psw);

        return loginPage;
    }
}
