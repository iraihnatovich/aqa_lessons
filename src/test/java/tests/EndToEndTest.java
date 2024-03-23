package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import pages.checkout.CheckoutCompletePage;
import pages.checkout.CheckoutInfoPage;
import pages.checkout.CheckoutOverviewPage;
import steps.CheckoutSteps;
import steps.NavigationSteps;
import steps.ProductSteps;

public class EndToEndTest extends BaseTest {
    @Test (testName = "e2e Adding to cart and checkout")
    public void e2eTest(@Optional("John") String firstName,
                        @Optional("Doe") String lastName,
                        @Optional("123432") String zipcode) {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.login(ReadProperties.getUsername(), ReadProperties.getPassword());
        Assert.assertTrue(new ProductsPage(driver).isPageOpened());
        ProductSteps productsSteps = new ProductSteps(driver);
        productsSteps.addToCart(1);
        navigationSteps.navigateToCart();
        Assert.assertTrue(new CartPage(driver).isPageOpened());
        navigationSteps.navigateToCheckout();
        Assert.assertTrue(new CheckoutInfoPage(driver).isPageOpened());
        CheckoutSteps checkoutSteps = new CheckoutSteps(driver);
        checkoutSteps.fillCheckoutInfo(firstName, lastName, zipcode);
        Assert.assertTrue(new CheckoutOverviewPage(driver).isPageOpened());
        checkoutSteps.finishCheckout();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(checkoutCompletePage.isPageOpened());
        Assert.assertEquals(checkoutCompletePage.getTitleText(), "Checkout: Complete!");
        Assert.assertEquals(checkoutCompletePage.getCompleteHeaderText(),
                "Thank you for your order!");
        Assert.assertEquals(checkoutCompletePage.getCompleteMessageText(),
                "Your order has been dispatched, and will arrive just as fast " +
                        "as the pony can get there!");
        Assert.assertTrue(checkoutCompletePage.hasBackButton());

    }

}
