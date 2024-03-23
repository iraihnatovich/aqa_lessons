package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInfoPage extends BasePage {

    private final By firstNameInputLocator = By.cssSelector("#first-name");
    private final By lastNameInputLocator = By.cssSelector("#last-name");
    private final By postalCodeInputLocator = By.cssSelector("#postal-code");
    private final By continueButtonLocator = By.cssSelector("#continue");


    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return firstNameInputLocator;
    }

    public WebElement getFirstNameInput() {
        return wait.waitForVisibilityLocatedBy(firstNameInputLocator);
    }

    public WebElement getLastNameInput() {
        return wait.waitForVisibilityLocatedBy(lastNameInputLocator);
    }

    public WebElement getPostalCodeInput() {
        return wait.waitForVisibilityLocatedBy(postalCodeInputLocator);
    }

    public WebElement getContinueButton() {
        return wait.waitForVisibilityLocatedBy(continueButtonLocator);
    }
}
