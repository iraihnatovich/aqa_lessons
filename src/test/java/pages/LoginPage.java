package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By usernameInputLocator = By.cssSelector("#user-name");
    private final By passwordInputLocator = By.cssSelector("#password");
    private final By loginButtonLocator = By.cssSelector("#login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return usernameInputLocator;
    }

    public WebElement getUsernameInput() {
        return wait.waitForVisibilityLocatedBy(usernameInputLocator);
    }

    public WebElement getPasswordInput() {
        return wait.waitForVisibilityLocatedBy(passwordInputLocator);
    }

    public WebElement getLoginButton() {
        return wait.waitForVisibilityLocatedBy(loginButtonLocator);
    }

}
