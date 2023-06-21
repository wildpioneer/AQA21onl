import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {

    @Test
    public void stepb() {
        System.out.println("stepb...");
    }

    @Test (dependsOnMethods = "stepb")
    public void astepa2() {
        System.out.println("stepa2...");
        Assert.assertTrue(false);
    }

    @Test (dependsOnMethods = "astepa2", alwaysRun = true)
    public void stepa11() {
        System.out.println("stepa11...");
    }

    @Test (dependsOnMethods = {"stepb", "astepa2"})
    public void stepa12() {
        System.out.println("stepa11...");
    }
}
