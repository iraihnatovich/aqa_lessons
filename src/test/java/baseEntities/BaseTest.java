package baseEntities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.AdvancedDriver;


public class BaseTest {
    protected WebDriver driver ;
//    private WaitService waitDriver;
protected AdvancedDriver advancedDriver;

    @BeforeMethod
    public void setup(){
//        driver = new BrowserService().getDriver();
//        waitDriver = new WaitService(driver);
        advancedDriver = new AdvancedDriver();
         driver = advancedDriver.getDriver();
         driver.get("https://www.saucedemo.com/");

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
