package core;

import configuration.ReadProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitService {
    private WebDriverWait wait;
    private WebDriver driver;
    private Duration timeout;

    public WaitService(WebDriver driver){
        this.driver = driver;
        timeout = Duration.ofSeconds(ReadProperties.getTimeout());
        wait = new WebDriverWait(driver, timeout);
    }

    public WaitService(WebDriver driver, Duration timeout){
        this.driver = driver;
        this.timeout = timeout;
        wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForVisibility (By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean waitForInvisible (By locator){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public Alert waitForAlert (){
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public WebElement waitForElementWithText (By locator, String text){
        if (wait.until(ExpectedConditions.textToBe(locator, text))){
            return waitForVisibility (locator);
        }
        return null;
    }

}
