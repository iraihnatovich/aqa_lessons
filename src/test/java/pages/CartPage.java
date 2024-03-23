package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    private final By checkoutButtonLocator = By.cssSelector("#checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return checkoutButtonLocator;
    }

    public WebElement getCheckoutButton() {
        return wait.waitForVisibilityLocatedBy(checkoutButtonLocator);
    }
}
