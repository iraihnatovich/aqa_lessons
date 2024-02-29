package data;

import org.testng.annotations.DataProvider;

public class GeneralDoubleDataProvider {
    @DataProvider (name = "GeneralDoubleData")
    public static Object [][] dataForDivDouble(){
        return new Object[][]{
                {6.39, 2.13, 3.0},
                {14.87, -3.6931, -4.0264276623974435},
                {18.87, 18.87, 1.0},
                {453.97735, 1.0, 453.97735},
                {0, 85.8, 0.0},
        };
    }
}
