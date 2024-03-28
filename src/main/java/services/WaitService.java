package services;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitService {
    private WebDriver driver;
    private Duration timeout;
    private WebDriverWait driverWait;

    public WaitService(WebDriver driver) {
        this.driver = driver;
        this.timeout = Duration.ofSeconds(ReadProperties.getTimeout());
        driverWait = new WebDriverWait(driver, this.timeout);
    }

    public WaitService(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
        driverWait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForVisibility(By locator) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
