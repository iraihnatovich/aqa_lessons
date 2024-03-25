package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowserService;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

}
