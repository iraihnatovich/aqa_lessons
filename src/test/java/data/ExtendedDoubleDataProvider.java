package data;

import org.testng.annotations.DataProvider;

public class ExtendedDoubleDataProvider {
    @DataProvider(name = "ExtendedDoubleData")
    public static Object[][] dataForDivDouble() {
        return new Object[][]{
                {-18.0, 3.0, -6.0},
                {9.62341, 78.75, 0.12220203174603174},
        };
    }
}
