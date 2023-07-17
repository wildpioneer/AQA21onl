package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public DashboardPage successLogin(String username, String psw) {
        loginPage.login(username, psw);

        return dashboardPage;
    }

    public LoginPage negativeLogin(String username, String psw) {
        loginPage.login(username, psw);

        return loginPage;
    }
}
