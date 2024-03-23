package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {
    private final By completeHeaderLocator = By.cssSelector(".complete-header");
    private final By completeMessageLocator = By.cssSelector(".complete-text");
    private final By backButtonLocator = By.cssSelector("#back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return completeHeaderLocator;
    }

    public WebElement getCompleteMessage() {
        return wait.waitForVisibilityLocatedBy(completeMessageLocator);
    }

    public WebElement getCompleteHeader() {
        return wait.waitForVisibilityLocatedBy(completeHeaderLocator);
    }

    public WebElement getBackButton() {
        return wait.waitForVisibilityLocatedBy(backButtonLocator);
    }

    public String getCompleteHeaderText() {
        return getCompleteHeader().getText();
    }

    public String getCompleteMessageText() {
        return getCompleteMessage().getText();
    }

    public boolean hasBackButton() {
        return getBackButton().isDisplayed();
    }
}
