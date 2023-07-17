package tests;

import org.testng.annotations.Test;

public class TestCaseTest {

    @Test
    public void testStep1() {

    }

    @Test( dependsOnMethods = "testStep1")
    public void testStep2() {

    }

    @Test( dependsOnMethods = "testStep2")
    public void testStep3() {

    }
}
