package pages;

import factory.BrowserSingleton;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import services.WaitService;

public class LoginPage {

    // Блок описания локаторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By pswInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");
    private final By errorFieldTextLocator = By.className("loginpage-message");

    private WaitService waitService;

    // Блок инициализации
    public LoginPage() {
        waitService = new WaitService();
    }

    // Блок атомарных методов
    public WebElement getEmailInput() {
        return waitService.waitForExists(emailInputLocator);
    }

    public WebElement getPswInput() {
        return waitService.waitForExists(pswInputLocator);
    }

    public boolean isPswInputDisplayed() {
        return waitService.waitForVisibility(getPswInput()).isDisplayed();
    }

    public WebElement getLogInButton() {
        return BrowserSingleton.getInstance().driver.findElement(logInButtonLocator);
    }

    public void setEmail(String value) {
        getEmailInput().sendKeys(value);
    }

    public WebElement getErrorTextElement() {
        return BrowserSingleton.getInstance().driver.findElement(errorTextLocator);
    }

    public WebElement getErrorFieldTextElement() {
        return BrowserSingleton.getInstance().driver.findElement(errorFieldTextLocator);
    }

    // Блок комплексных методов
    public void login(User user) {
        setEmail(user.getEmail());
        getPswInput().sendKeys(user.getPassword());
        getLogInButton().click();
    }

}
