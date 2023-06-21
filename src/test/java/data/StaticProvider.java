package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider (name = "Data for Sum test", parallel = true)
    public static Object[][] dataForSumTest() {
        return new Object[][] {
                {-2, -3, -5},
                {0, 0, 0},
                {-1, 2, 1},
                {2, 3, 5}
        };
    }
}
