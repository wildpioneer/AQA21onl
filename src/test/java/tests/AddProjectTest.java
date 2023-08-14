package tests;

import baseEntities.BaseTest;
import helper.DataHelper;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddTestCasePage;
import utils.configuration.ReadProperties;

public class AddProjectTest extends BaseTest {

    @Test
    public void successLoginTest() {
        loginStep.successLogin(DataHelper.getAdminUser());
        projectStep.AddProject(DataHelper.getProject());

        driver.get("https://aqa21onl03.testrail.io/index.php?/cases/add/2");
        AddTestCasePage addTestCasePage = new AddTestCasePage(driver);
        addTestCasePage.getTemplateDropDown().selectByIndex(1);
        addTestCasePage.getTypeDropDown().selectByIndex(1);
        addTestCasePage.getTemplateDropDown().selectByText("Test Case (Steps)");
        addTestCasePage.getTypeDropDown().selectByText("Other");

        addTestCasePage.getTemplateDropDown().getOptionsList().forEach(System.out::println);

    }

}
