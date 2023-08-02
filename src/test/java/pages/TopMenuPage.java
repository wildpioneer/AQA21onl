package pages;

import factory.BrowserSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage {
    private final By topPanelLocator = By.className("top-panel");

    public WebElement getTopPanel() {
        return BrowserSingleton.getInstance().driver.findElement(topPanelLocator);
    }
}
