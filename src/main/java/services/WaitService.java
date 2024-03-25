package services;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitService {
    private WebDriverWait driverWait;
    private WebDriver driver;
    private Duration timeout;

    public WaitService(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
        this.driverWait = new WebDriverWait(driver, timeout);
    }

    public WaitService(WebDriver driver) {
        this.driver = driver;
        this.timeout = Duration.ofSeconds(ReadProperties.getTimeout());
        this.driverWait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForVisibilityLocatedBy(By locator) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {
        return driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}
