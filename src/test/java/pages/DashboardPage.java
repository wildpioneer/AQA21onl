package pages;

import factory.BrowserSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    private final static String pagePath = "/index.php?/dashboard/";

    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");

    public TopMenuPage topMenuPage;
    public SideMenuPage sideMenuPage;

    // Блок инициализации
    public DashboardPage() {
        topMenuPage = new TopMenuPage();
        sideMenuPage = new SideMenuPage();
    }

    // Блок атомарных методов
    public WebElement getHeaderTitle() {
        return BrowserSingleton.getInstance().driver.findElement(headerTitleLabelLocator);
    }

    public boolean isPageOpened() {
        return getHeaderTitle().isDisplayed();
    }
}
