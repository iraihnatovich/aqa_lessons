import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;

public class BaseCalcTest {
    protected Calculator calculator;

    @BeforeSuite
    public void initCalculator() {
        calculator = new Calculator();
    }

    @BeforeGroups(groups = {"general", "extended"})
    public void methodBeforeGeneral() {
        calculator = new Calculator();
    }
}
