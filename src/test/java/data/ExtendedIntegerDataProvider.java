package data;

import org.testng.annotations.DataProvider;

public class ExtendedIntegerDataProvider {
    @DataProvider(name = "ExtendedIntData")
    public static Object[][] dataForDiv() {
        return new Object[][]{
                {8, -3, -2},
                {24, 40, 0},
        };
    }
}
