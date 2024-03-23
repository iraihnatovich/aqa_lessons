package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.WebDriver;
import pages.checkout.CheckoutInfoPage;
import pages.checkout.CheckoutOverviewPage;

public class CheckoutSteps extends BaseSteps {
    public CheckoutSteps(WebDriver driver) {
        super(driver);
    }

    public void fillCheckoutInfo(String firstName, String lastName, String zipcode) {
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.getFirstNameInput().sendKeys(firstName);
        checkoutInfoPage.getLastNameInput().sendKeys(lastName);
        checkoutInfoPage.getPostalCodeInput().sendKeys(zipcode);
        checkoutInfoPage.getContinueButton().click();
    }

    public void finishCheckout() {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.getFinishButton().click();
    }
}
