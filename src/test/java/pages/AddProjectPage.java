package pages;

import baseEntities.BasePage;
import elements.CheckBox;
import elements.RadioButton;
import elements.UIElement;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;

public class AddProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/add";

    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Project')]");

    private final By nameInputLocator = By.id("name");
    private final By announcementTextAreaLocator = By.id("announcement_display");
    private final By showAnnouncementCheckBoxLocator = By.id("show_announcement");
    private final By projectTypeRadioButtonLocator = By.name("suite_mode");

    // Блок инициализации
    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleLabelLocator);
    }

    public UIElement getNameInput() {
        return new UIElement(driver, nameInputLocator);
    }

    public UIElement getAnnouncementTextArea() {
        return new UIElement(driver, announcementTextAreaLocator);
    }

    public CheckBox getShowAnnouncement() {
        return new CheckBox(driver, showAnnouncementCheckBoxLocator);
    }

    public RadioButton getProjectType() {
        return new RadioButton(driver, projectTypeRadioButtonLocator);
    }
}
