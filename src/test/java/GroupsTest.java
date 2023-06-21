import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsTest {

    @Test (groups = "smoke")
    public void stepb() {
        System.out.println("stepb...");
    }

    @Test (groups = "regression")
    public void astepa2() {
        System.out.println("stepa2...");
    }

    @Test (groups = "regression", dependsOnGroups = "smoke")
    public void stepa11() {
        System.out.println("stepa1...");
    }

    @Test (groups = {"smoke", "regression"})
    public void stepa12() {
        System.out.println("stepa12...");
    }
}
