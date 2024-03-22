package baseEntities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowserService;
import services.WaitService;

public class BaseTest {
    private WebDriver driver;
    private WaitService waitDriver;

    @BeforeMethod
    public void setup(){
        driver = new BrowserService().getDriver();
        waitDriver = new WaitService(driver);
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
