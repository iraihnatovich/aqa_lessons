package data;

import org.testng.annotations.DataProvider;

public class CalculatorInfinityCaseDataProvider {
    @DataProvider(name = "InfinityDataProvider")
    public static Object[][] dataForDiv() {
        return new Object[][]{
                {43.8798, 0.0, Double.POSITIVE_INFINITY},
                {-43.8798, 0.0, Double.NEGATIVE_INFINITY},
                {651.65, 0, Double.POSITIVE_INFINITY},
                {-41, 0.0, Double.NEGATIVE_INFINITY},
                {0, 0.0, Double.NaN},
                {0.0, 0, Double.NaN},
        };
    }
}
