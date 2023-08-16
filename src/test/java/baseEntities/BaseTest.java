package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import steps.LoginStep;
import steps.ProjectStep;
import utils.configuration.ReadProperties;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected LoginStep loginStep;
    protected ProjectStep projectStep;

    static Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        org.apache.log4j.BasicConfigurator.configure();

        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 8000;
        //Configuration.browser = Browsers.CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.fastSetValue = true;
        Configuration.headless = false;
        //Configuration.assertionMode = SOFT;

        loginStep = new LoginStep();
        projectStep = new ProjectStep();

        open("/");

        logger.info("Browser is started");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

}
