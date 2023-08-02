package steps;

import factory.BrowserSingleton;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import utils.configuration.ReadProperties;

public class LoginStep {

    public DashboardPage successLogin(User user) {
        BrowserSingleton.getInstance().driver.get(ReadProperties.getUrl());
        new LoginPage().login(user);

        return new DashboardPage();
    }
}
