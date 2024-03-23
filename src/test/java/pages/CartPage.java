package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    //    private final By cartItemLocator = By.cssSelector("#cart_item_label");
//    private final By cartBadgeLocator = By.cssSelector("#shopping_cart_badge");
    private final By checkoutButtonLocator = By.cssSelector("#checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return checkoutButtonLocator;
    }
//    public List <WebElement> getCartItems(){
//        return wait.waitForAllVisibleElementsLocatedBy(cartItemLocator);
//    }
//
//    public WebElement getCartSingleItem(int index){
//        return getCartItems().get(index);
//    }
//    public WebElement getCartBadge(){
//        return wait.waitForVisibilityLocatedBy(cartBadgeLocator);
//    }
//    public int getAmountOfCartItems(){
//        return Integer.parseInt(getCartBadge().getText()) ;
//    }

    public WebElement getCheckoutButton() {
        return wait.waitForVisibilityLocatedBy(checkoutButtonLocator);
    }
}
