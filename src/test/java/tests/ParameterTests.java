package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitService;

public class ParameterTests extends BaseTest {

    @Test
    public void infoAlertTest() {
        System.out.println(System.getProperty("testProp"));
    }
}