package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage {
    private final By finishButtonLocator = By.cssSelector("#finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return finishButtonLocator;
    }

    public WebElement getFinishButton() {
        return wait.waitForVisibilityLocatedBy(finishButtonLocator);
    }
}
