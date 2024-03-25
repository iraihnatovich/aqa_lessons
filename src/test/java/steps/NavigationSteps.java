package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class NavigationSteps extends BaseSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
    }

    public void navigateToCart() {
        productsPage = new ProductsPage(driver);
        productsPage.getCartButton().click();
    }

    public void navigateToCheckout() {
        cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
    }

}
