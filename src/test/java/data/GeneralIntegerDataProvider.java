package data;

import org.testng.annotations.DataProvider;

public class GeneralIntegerDataProvider {
    @DataProvider(name = "GeneralIntData")
    public static Object[][] dataForDiv() {
        return new Object[][]{
                {72, 12, 6},
                {-15, 3, -5},
                {-250, -250, 1},
                {14, 1, 14},
                {0, 165, 0},
        };
    }
}
