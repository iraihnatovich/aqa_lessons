package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    WebDriver driver;

    @Test
    public void testOne() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.getUsernameInput().sendKeys("123333");
        Thread.sleep(4000);
    }

}
