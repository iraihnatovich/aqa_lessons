package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitService;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitService wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitService(driver);
    }

    protected abstract By getPageIdentifier();
    public String getPageUrl(){
        return ReadProperties.getUrl();
    }

    public boolean isPageOpened() {
        return wait.waitForVisibilityLocatedBy(getPageIdentifier()).isDisplayed();
    }
}
