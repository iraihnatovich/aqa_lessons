package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import services.AdvancedDriver;

public class MyTest extends BaseTest {
    @Test
    public void test(){
        LoginPage login = new LoginPage(driver);
        login.getUsernameInput().sendKeys("123333");
    }
}
