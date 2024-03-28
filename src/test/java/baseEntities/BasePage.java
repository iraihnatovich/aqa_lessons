package baseEntities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import services.WaitService;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitService wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitService(driver);
        PageFactory.initElements(driver, this);
    }

    protected abstract WebElement getPageIdentifier();

    public boolean isOpened() {
        return getPageIdentifier().isDisplayed();
    }
}
