import data.*;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorFunctionalTest extends BaseCalcTest {

    @Test(testName = "General Int division", dataProvider = "GeneralIntData",
            dataProviderClass = GeneralIntegerDataProvider.class, timeOut = 1000, groups = "general")
    public void divInt(int a, int b, int expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(testName = "General Double division", dataProvider = "GeneralDoubleData",
            dataProviderClass = GeneralDoubleDataProvider.class, groups = "general")
    public void divDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(testName = "Extended Int division", dataProvider = "ExtendedIntData",
            dataProviderClass = ExtendedIntegerDataProvider.class,
            invocationCount = 2, threadPoolSize = 2, dependsOnMethods = "divInt",
            groups = "extended")
    public void divIntExtended(int a, int b, int expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(testName = "Extended Double division", dataProvider = "ExtendedDoubleData",
            dataProviderClass = ExtendedDoubleDataProvider.class,
            invocationCount = 2, invocationTimeOut = 500,
            dependsOnMethods = "divDouble", groups = "extended")
    public void divDoubleExtended(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(testName = "Int by Zero",
            expectedExceptions = ArithmeticException.class, dependsOnMethods = "divInt", groups = "general")
    public void intDivByZero() {
        calculator.div(76, 0);
    }

    @Test(testName = "Double by Zero (demo)",
            expectedExceptions = ArithmeticException.class, groups = "general")
    // специально падает
    public void doubleDivGetZero() {
        calculator.div(12.6, 0.0);
    }

    @Test(testName = "Divide double by Zero (infinity)", dataProvider = "InfinityDataProvider",
            dataProviderClass = CalculatorInfinityCaseDataProvider.class,
            dependsOnMethods = "doubleDivGetZero", alwaysRun = true, groups = "general")
    //специально зависимость от падающего теста
    public void doubleDivByZero(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(testName = "Integer by double", description = "to validate division Integer by Double", dependsOnGroups = "extended")
    public void intDivDouble() {
        Assert.assertEquals(calculator.div(5, 2.15), 2.3255813953488373);
    }

    @Parameters({"dividend-value", "divisor-value", "quotient-expected-value"})
    @Test(testName = "Double by int", priority = 1)
    public void doubleDivInteger(@Optional("54.9812923") double dividend, @Optional("9") int divisor, @Optional("6.109032477777777") double quotient) {
        Assert.assertEquals(calculator.div(dividend, divisor), quotient);

    }

    @Test(testName = "Zero div by Zero", enabled = false, expectedExceptions = ArithmeticException.class)
    // специально задизебленный неверный тест
    public void doubleZeroZero() {
        Assert.assertEquals(calculator.div(0.0, 0.0), 0.0);
    }

    @Test(testName = "test with retryAnalyzer", retryAnalyzer = Retry.class)
    public void retryTest() {
        Assert.assertEquals(calculator.div(60, 3), 21);
    }

}
