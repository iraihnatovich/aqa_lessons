package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //locator description (By emailInputLocator)
    private final By usernameInputLocator = By.cssSelector("#user-name");
    private final By passwordInputLocator = By.cssSelector("#password");
    private final By loginButtonLocator = By.cssSelector("#login-button");
    protected WebDriver driver;

    //initialization block
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //methods
    public WebElement getUsernameInput(){
        return driver.findElement(usernameInputLocator);
    }
    public WebElement getPasswordInput(){
        return driver.findElement(passwordInputLocator);
    }
    public WebElement getLoginButton(){
        return driver.findElement(loginButtonLocator);
    }

}
