package pages;

import baseEntities.BasePage;
import elements.CheckBox;
import elements.DropDown;
import elements.RadioButton;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTestCasePage extends BasePage {
    //private final static String pagePath = "/index.php?/admin/projects/add";

    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Test Case')]");

    private final By templateDropDownLocator = By.id("template_id_chzn");
    private final By typeDropDownLocator = By.id("type_id_chzn");

    // Блок инициализации
    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    // Блок атомарных методов
    public DropDown getTemplateDropDown() {
        return new DropDown(driver, templateDropDownLocator);
    }

    public DropDown getTypeDropDown() {
        return new DropDown(driver, typeDropDownLocator);
    }
}
