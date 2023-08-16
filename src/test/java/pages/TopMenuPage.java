package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class TopMenuPage extends BasePage {
    private final By topPanelLocator = By.className("top-panel");

    public TopMenuPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return topPanelLocator;
    }

    public SelenideElement getTopPanel() {
        return $(topPanelLocator);
    }
}
